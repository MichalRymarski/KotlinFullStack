package website.back.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.id
import kotlinx.html.script
import website.front.components.dashboard
import website.front.links.imports
import website.syntax_extensions.classes

fun Routing.HomeController() {
    get("/") {
        call.respondHtml(status = HttpStatusCode.OK) {
            imports()

            body(classes = classes("my-background","overflow-hidden")) {
                id = "home"
                dashboard()
                script { src = "/static/test.js" }
            }
        }
    }
}