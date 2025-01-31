package website.back.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import kotlinx.html.body
import kotlinx.html.id
import kotlinx.html.script
import website.back.db.getRandom20Videos
import website.back.db.getVideoById
import website.back.plugins.UserSession
import website.front.components.video.VideoNotFound
import website.front.components.video.VideoView
import website.front.links.imports
import website.syntax_extensions.classes

fun Routing.VideoController(){

    get("/video/{id}") {
        val videoID = call.parameters["id"]?.toIntOrNull()
        val userSession = call.sessions.get<UserSession>()
        val videos = getRandom20Videos()

        if(videoID == null){ //TODO : Create a case when db fails to query for that
            call.respondHtml(status = HttpStatusCode.NoContent) {
                imports()

                body(classes = classes("overflow-hidden")) {
                    id = "home"
                    VideoNotFound()
                    script { src = "/static/global_scripts.js" }
                }
            }
        }else {
            call.respondHtml(status = HttpStatusCode.OK) {
                val currentVideo = getVideoById(videoID)
                imports()
                body(classes = classes("overflow-hidden h-full")) {
                    id = "home"
                    VideoView(videos,userSession, currentVideo)
                    script { src = "/static/global_scripts.js" }
                }
            }
        }

    }
}