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
import website.back.db.getVideosForUser
import website.back.db.handleVideoSave
import website.back.plugins.UserSession
import website.front.links.imports


fun Routing.ChannelController(storageService: GoogleCloudStorageService) {
    get("/channel") {
        val profileEmail = call.request.queryParameters["email"]
        val userSession = call.sessions.get<UserSession>()
        val videos = getVideosForUser(profileEmail.orEmpty())

        when (profileEmail) {
            null -> {
                call.respondHtml(status = HttpStatusCode.NotFound) {
                    imports()
                    body {
                        h5 { +"Channel doesn't exist!" }
                    }
                }
            }

            userSession?.email -> {
                call.respondHtml(status = HttpStatusCode.OK) {
                    imports()
                    body {
                        // Channel owner header
                        ChannelView(profileEmail, videos)
                    }
                }
            }

            else -> {
                call.respondHtml(status = HttpStatusCode.OK) {
                    imports()
                    body {
                        // Channel header for visitors
                        div {
                            classes = setOf("mb-8")
                            h5 { +"Channel" }
                            p { +profileEmail }
                        }

                        // Video list - view only
                        div {
                            classes = setOf("grid", "grid-cols-1", "md:grid-cols-2", "lg:grid-cols-3", "gap-4")
                            videos.forEach { video ->
                                div {
                                    classes = setOf("p-4", "border", "rounded")
                                    video {
                                        classes = setOf("w-full")
                                        controls = true
                                        source {
                                            src = video.videoUrl
                                            type = "video/mp4"
                                        }
                                    }
                                }
                            }
                        }
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
        val userEmail  = userSession.email

        val multipart = call.receiveMultipart()
        var videoUrl: String? = null
        var thumbnailUrl: String? = null
        var videoTitle: String? = null

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
        // Return the updated video list

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
    div {
        id = "videoList"
        classes = setOf("grid", "grid-cols-1", "md:grid-cols-2", "lg:grid-cols-3", "gap-4")
        videos.forEach { video ->
            div {
                classes = setOf("p-4", "border-4", "rounded") // Thicker border here
                a(href = "/video/${video.id}") { // Create a link for the video
                    img {
                        src = video.thumbnailUrl
                        classes = setOf("w-full", "h-32", "object-cover", "mb-2") // Smaller thumbnails (height reduced to 32)
                    }
                    h4 {
                        classes = setOf("text-center", "text-lg", "font-semibold", "mt-2")
                        +video.title.orEmpty() // Use an empty string if the title is null
                    }
                }
            }
        }
    }
}

private fun FlowContent.ChannelView(profileEmail: String, videos: List<VideoObject>) {
    div {
        classes = setOf("mb-8")
        h5 { +"Your Channel" }
        p { +profileEmail }
    }

    // Upload form - only visible to the channel owner
    div {
        classes = setOf("mb-8", "p-6", "border", "rounded-lg", "bg-gray-50")
        h3 {
            classes = setOf("text-lg", "font-semibold", "mb-4")
            +"Upload a New Video"
        }
        form {
            attributes["hx-post"] = "/upload"
            attributes["hx-encoding"] = "multipart/form-data"
            attributes["hx-target"] = "#videoList"

            div {
                classes = setOf("mb-4")
                label {
                    classes = setOf("block", "mb-2", "text-sm", "font-medium")
                    htmlFor = "video-title"
                    +"Video Title"
                }
                input(type = InputType.text) {
                    id = "video-title"
                    name = "title"
                    placeholder = "Enter a title for the video"
                    classes = setOf("block", "w-full", "text-sm", "border", "rounded", "mb-4")
                }

                label {
                    classes = setOf("block", "mb-2", "text-sm", "font-medium")
                    htmlFor = "video-upload"
                    +"Choose video file"
                }
                input(type = InputType.file) {
                    id = "video-upload"
                    name = "video"
                    accept = "video/*"
                    classes = setOf("block", "w-full", "text-sm", "border", "rounded", "mb-4")
                }

                label {
                    classes = setOf("block", "mb-2", "text-sm", "font-medium")
                    htmlFor = "thumbnail-upload"
                    +"Choose thumbnail image"
                }
                input(type = InputType.file) {
                    id = "thumbnail-upload"
                    name = "image"
                    accept = "image/*"
                    classes = setOf("block", "w-full", "text-sm", "border", "rounded")
                }
            }

            button(type = ButtonType.submit) {
                classes = setOf("bg-blue-500", "text-white", "px-4", "py-2", "rounded")
                +"Upload"
            }
        }
    }

    // Render video list
    RenderVideoList(videos) // Reusing the new method here
}

