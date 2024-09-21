package website.back.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.id
import kotlinx.html.script
import website.front.components.video.VideoNotFound
import website.front.components.video.VideoView
import website.front.links.imports
import website.syntax_extensions.classes

fun Routing.VideoController(){
    get("/video/{id}") {
        val videoID = call.parameters["id"]?.toIntOrNull()

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
                imports()

                body(classes = classes("overflow-hidden ")) {
                    id = "home"
                    VideoView(videoID)
                    script { src = "/static/global_scripts.js" }
                }
            }
        }

    }
}