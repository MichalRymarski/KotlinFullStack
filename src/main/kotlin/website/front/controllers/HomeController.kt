package website.front.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.script
import website.front.attributes.Color
import website.front.attributes.backgroundColor
import website.front.attributes.classesToString
import website.front.components.dashboard
import website.front.links.imports

fun Routing.HomeController() {
    get("/") {
        call.respondHtml(status = HttpStatusCode.OK) {
            imports()

            body(classes = classesToString(backgroundColor(Color.GRAY_700))) {
                dashboard()
                script { src = "/static/test.js" }
            }
        }
    }
}