package website.front.controllers

import charactersGrid
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.script
import website.front.links.imports
import website.syntax_extensions.classesToString


fun Routing.CharactersController() {
    get("/characters") {
        call.respondHtml(status = HttpStatusCode.OK) {
            imports()

            body(classes = classesToString("bg-gray-700")) {
                charactersGrid()
                script { src = "/static/test.js" }
            }
        }
    }
}
