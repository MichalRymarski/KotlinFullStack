package website.back.controllers

import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import kotlinx.html.*
import website.GoogleCloudStorageService
import website.VideoObject
import website.back.db.getUserNicknameByEmail
import website.back.db.getVideosForUser
import website.back.db.handleVideoSave
import website.back.plugins.UserSession
import website.front.ANSI_GREEN
import website.front.ANSI_RESET
import website.front.components.VideoGrid
import website.front.components.shared.ChannelPill
import website.front.components.shared.HeaderLoggedIn
import website.front.components.shared.HeaderNotLoggedIn
import website.front.links.imports
import website.syntax_extensions.classes


fun Routing.ChannelController(storageService: GoogleCloudStorageService) {
    get("/channel") {
        val profileEmail = call.request.queryParameters["email"]
        val userSession = call.sessions.get<UserSession>()
        val videos = getVideosForUser(profileEmail.orEmpty())

        when (profileEmail) {
            null -> {
                call.respondHtml(status = HttpStatusCode.NotFound) {
                    imports()
                    body(classes = classes("overflow-hidden ")) {
                        id = "home"
                        h5 { +"Channel doesn't exist!" }
                    }
                }
            }

            userSession?.email -> {
                val profileNick = getUserNicknameByEmail(profileEmail)

                call.respondHtml(status = HttpStatusCode.OK) {
                    imports()
                    body(classes = classes("overflow-hidden ")) {
                        id = "home"
                        ChannelView(profileNick, profileEmail, videos, userSession)
                    }
                }
            }

            else -> {
                call.respondHtml(status = HttpStatusCode.OK) {
                    val profileNick = getUserNicknameByEmail(profileEmail)

                    imports()
                    body(classes = classes("overflow-hidden ")) {
                        id = "home"
                        ChannelView(profileNick, profileEmail, videos, userSession)
                    }
                }
            }
        }
    }

    post("/upload") {
        val userSession = call.sessions.get<UserSession>()
        if (userSession == null) {
            call.respond(HttpStatusCode.Unauthorized)
            return@post
        }
        val userEmail = userSession.email

        val multipart = call.receiveMultipart()
        var videoUrl: String? = null
        var thumbnailUrl: String? = null
        var videoTitle: String? = null

        println("${ANSI_GREEN}Uploading video for user $userEmail$ANSI_RESET")

        multipart.forEachPart { part ->
            when (part) {
                is PartData.FormItem -> { // Handle text input fields like title
                    when (part.name) {
                        "title" -> videoTitle = part.value // Extract the title value
                    }
                }

                is PartData.FileItem -> { // Handle file input fields like video and image
                    when (part.name) {
                        "video" -> videoUrl = storageService.uploadVideo(part)
                        "image" -> thumbnailUrl = storageService.uploadImage(part)
                    }
                }

                else -> part.dispose()
            }
            part.dispose()
        }

        if (videoTitle.isNullOrBlank() || videoUrl == null || thumbnailUrl == null) {
            call.respond(HttpStatusCode.BadRequest, "Missing required fields")
            return@post
        }
        val success = handleVideoSave(userEmail, videoUrl, thumbnailUrl, videoTitle)

        if (success) {
            val videos = getVideosForUser(userEmail) // Retrieve the updated list of videos
            call.respondHtml {
                body {
                    RenderVideoList(videos)
                }
            }
        } else {
            // If saving the video record fails, respond with an error
            call.respond(HttpStatusCode.InternalServerError, "A problem occurred while saving the video. Please try again later.")
        }
    }
}


private fun FlowContent.RenderVideoList(videos: List<VideoObject>) {
    VideoGrid(videos)
}

private fun FlowContent.ChannelView(channelNick: String, channelEmail: String, videos: List<VideoObject>, userSession: UserSession?) {
    div(classes = classes("relative h-screen bg-customBlack overflow-y-auto")) {
        attributes["x-data"] = "{ sidebarOpen: false }"

        if (userSession == null) {
            HeaderNotLoggedIn()
        } else {
            HeaderLoggedIn(userSession)
        }

        div(classes = classes("flex flex-col px-8 pb-8")) {
            if (userSession?.email == channelEmail) {
                div(classes = classes("pl-20")) {
                    div(classes = classes("w-1/3 p-3  bg-customGray shadow-md rounded-lg mb-4")) {
                        h3(classes = classes("text-sm font-bold mb-2 text-white")) { +"Add a New Video" }
                        form {
                            attributes["hx-post"] = "/upload"
                            attributes["hx-encoding"] = "multipart/form-data"
                            attributes["hx-target"] = "#videoGrid"
                            attributes["hx-swap"] = "outerHTML"

                            div {
                                classes = setOf("mb-2")
                                input(type = InputType.text) {
                                    id = "video-title"
                                    name = "title"
                                    placeholder = "Enter a title for the video"
                                    classes = setOf("block", "w-full", "text-xs", "border", "rounded", "mb-2", "bg-customGray", "text-white", "p-1")
                                }

                                input(type = InputType.file) {
                                    id = "video-upload"
                                    name = "video"
                                    accept = "video/*"
                                    classes = setOf(
                                        "block",
                                        "w-full",
                                        "text-xs",
                                        "border",
                                        "rounded",
                                        "mb-2",
                                        "text-white",
                                        "file:bg-customGray",
                                        "file:text-white"
                                    )
                                }

                                input(type = InputType.file) {
                                    id = "thumbnail-upload"
                                    name = "image"
                                    accept = "image/*"
                                    classes =
                                        setOf("block", "w-full", "text-xs", "border", "rounded", "text-white", "file:bg-customGray", "file:text-white")
                                }
                            }

                            button(type = ButtonType.submit) {
                                classes = setOf("bg-blue-500", "text-white", "px-3", "py-1", "rounded", "text-sm", "hover:bg-blue-600", "mt-2")
                                +"Upload"
                            }
                        }
                    }
                }
            }
            div {
                div(classes = classes("flex items-center pl-20 gap-4 my-6")) {
                    ChannelPill(generateColorFromEmail(channelEmail), channelNick.take(1))
                    div(classes = classes("text-white text-xl")) {
                        +channelNick
                    }
                }
                div {
                    id = "videoGrid"
                    RenderVideoList(videos)
                }
            }
        }
    }
}

fun generateColorFromEmail(email: String): String {
    val hash = email.hashCode()
    val color = "#" + Integer.toHexString(hash).takeLast(6)
    return color
}