package website.front.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.id
import kotlinx.html.script
import website.front.components.register
import website.front.links.imports
import website.syntax_extensions.classes

fun Routing.RegistrationController() {
    get("/register") {
        call.respondHtml(status = HttpStatusCode.OK) {
            imports()

            body(
                classes = classes(
                    "bg-gradient-to-br",
                    "from-gray-900",
                    "min-h-screen",
                    "to-gray-500",
                    "flex",
                    "items-center",
                    "justify-center"
                )
            ) {
                id = "register"
                register()
                script { src = "/static/test.js" }
            }
        }
    }
    post("/register") {
        val parameters = call.receiveParameters()
        val username = parameters["register-username"]
        val password = parameters["register-password"]

        println(parameters.toString())
        println(username)
        println(password)

        if (username == null || password == null) {
            call.respondText("Invalid username or password", status = HttpStatusCode.Unauthorized)
        } else {
            call.response.headers.append("HX-Redirect", "/")
        }
    }
}