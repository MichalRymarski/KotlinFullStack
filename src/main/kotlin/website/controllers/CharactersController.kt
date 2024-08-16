package website.controllers

import charactersGrid
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.script
import website.constants.Color
import website.constants.backgroundColor
import website.constants.classesToString
import website.links.imports


fun Routing.CharactersController() {
    get("/characters") {
        call.respondHtml(status = HttpStatusCode.OK) {
            imports()

            body(classes = classesToString(backgroundColor(Color.GRAY_600))) {
                charactersGrid()
                script { src = "/static/test.js" }
            }
        }
    }
}
