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
import website.back.plugins.UserSession
import website.front.ANSI_RED
import website.front.ANSI_RESET
import website.front.links.imports


fun Routing.ChannelController(storageService: GoogleCloudStorageService) {
    get("/channel") {
        val profileEmail = call.request.queryParameters["email"]
        val userSession = call.sessions.get<UserSession>()
        val videos = storageService.listVideos()

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
                        div {
                            classes = setOf("mb-8")
                            h5 { +"Your Channel" }
                            p { +profileEmail }
                        }

// Upload form - only visible to channel owner
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
                                        htmlFor = "video-upload"
                                        +"Choose video file"
                                    }
                                    input(type = InputType.file) {
                                        id = "video-upload"
                                        name = "video"
                                        accept = "video/*"
                                        classes = setOf("block", "w-full", "text-sm", "border", "rounded", "cursor-pointer",
                                            "file:mr-4", "file:py-2", "file:px-4",
                                            "file:border-0",
                                            "file:text-sm", "file:font-semibold",
                                            "file:bg-blue-50", "file:text-blue-700",
                                            "hover:file:bg-blue-100")
                                    }
                                    p {
                                        classes = setOf("mt-1", "text-sm", "text-gray-500")
                                        +"MP4, WebM, or OGG files"
                                    }
                                }

                                button(type = ButtonType.submit) {
                                    classes = setOf("w-full", "bg-blue-500", "hover:bg-blue-600",
                                        "text-white", "px-4", "py-2", "rounded",
                                        "font-medium", "transition-colors")
                                    +"Upload Video"
                                }
                            }
                        }
                        // Video list
                        div {
                            id = "videoList"
                            classes = setOf("grid", "grid-cols-1", "md:grid-cols-2", "lg:grid-cols-3", "gap-4")
                            videos.forEach { videoUrl ->
                                div {
                                    classes = setOf("p-4", "border", "rounded")
                                    video {
                                        classes = setOf("w-full")
                                        controls = true
                                        source {
                                            src = videoUrl
                                            type = "video/mp4"
                                        }
                                    }
                                    // Add delete button for channel owner
                                    button {
                                        attributes["hx-delete"] = "/video?url=${videoUrl}"
                                        attributes["hx-target"] = "#videoList"
                                        classes = setOf("mt-2", "bg-red-500", "text-white", "px-2", "py-1", "rounded")
                                        +"Delete Video"
                                    }
                                }
                            }
                        }
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
                            videos.forEach { videoUrl ->
                                div {
                                    classes = setOf("p-4", "border", "rounded")
                                    video {
                                        classes = setOf("w-full")
                                        controls = true
                                        source {
                                            src = videoUrl
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

        val multipart = call.receiveMultipart()
        var videoUrl: String? = null

        multipart.forEachPart { part ->
            when (part) {
                is PartData.FileItem -> {
                    videoUrl = storageService.uploadVideo(part)
                }
                else -> part.dispose()
            }
            part.dispose()
        }

        // Return the updated video list
        val videos = storageService.listVideos()
        println("$ANSI_RED ${storageService.listVideos()} $ANSI_RESET")
        call.respondHtml {
            body {
                div {
                    id = "videoList"
                    classes = setOf("grid", "grid-cols-1", "md:grid-cols-2", "lg:grid-cols-3", "gap-4")
                    videos.forEach { videoUrl ->
                        div {
                            classes = setOf("p-4", "border", "rounded")
                            video {
                                classes = setOf("w-full")
                                controls = true
                                source {
                                    src = videoUrl
                                    type = "video/mp4"
                                }
                            }
                            button(type = ButtonType.button) {
                                attributes["hx-delete"] = "/video?url=${videoUrl}"
                                attributes["hx-target"] = "#videoList"
                                classes = setOf("mt-2", "bg-red-500", "text-white", "px-2", "py-1", "rounded")
                                +"Delete Video"
                            }
                        }
                    }
                }
            }
        }    }

    /*delete("/video") {
        val videoUrl = call.request.queryParameters["url"]
        val userSession = call.sessions.get<UserSession>()
        val videos = storageService.listVideos()

        if (userSession != null && videoUrl != null) {
            // Extract filename from URL and delete
            val fileName = videoUrl.substringAfterLast("/")
            storageService.deleteVideo(fileName)

            // Return updated video list
            call.respondHtml(status = HttpStatusCode.OK) {
                videos.forEach { videoUrl ->
                    div {
                        classes = setOf("p-4", "border", "rounded")
                        video {
                            classes = setOf("w-full")
                            controls = true
                            source {
                                src = videoUrl
                                type = "video/mp4"
                            }
                        }
                        button(type = ButtonType.button) {  // Added ButtonType
                            attributes["hx-delete"] = "/video?url=${videoUrl}"
                            attributes["hx-target"] = "#videoList"
                            classes = setOf("mt-2", "bg-red-500", "text-white", "px-2", "py-1", "rounded")
                            +"Delete Video"
                        }
                    }
                }
            }
        } else {
            call.respond(HttpStatusCode.Unauthorized)
        }
    }*/}