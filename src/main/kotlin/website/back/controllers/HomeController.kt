package website.back.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import kotlinx.html.body
import kotlinx.html.id
import kotlinx.html.script
import website.back.plugins.UserSession
import website.front.components.Home
import website.front.links.imports
import website.syntax_extensions.classes

fun Routing.HomeController() {
    get("/") {
        val userSession = call.sessions.get<UserSession>()

        call.respondHtml(status = HttpStatusCode.OK) {
            imports()

            body(classes = classes("my-background","overflow-hidden")) {
                id = "home"
                Home(userSession)
                script { src = "/static/test.js" }
            }
        }
    }
}