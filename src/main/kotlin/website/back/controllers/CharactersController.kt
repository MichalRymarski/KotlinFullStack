package website.back.controllers

import charactersGrid
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.id
import kotlinx.html.script
import website.front.links.imports
import website.syntax_extensions.classes


fun Routing.CharactersController() {
    get("/characters") {
        call.respondHtml(status = HttpStatusCode.OK) {
            imports()

            body(classes = classes("bg-gray-700")) {
                id = "home"

                charactersGrid()
                script { src = "/static/global_scripts.js" }
            }
        }
    }
}
