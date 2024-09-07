package website.back.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*
import kotlinx.html.body
import kotlinx.html.id
import kotlinx.html.script
import website.back.db.addUser
import website.front.components.register
import website.front.links.imports
import website.syntax_extensions.classes

fun Routing.RegistrationController() {
    get("/register") {
        call.respondHtml(status = HttpStatusCode.OK) {
            id = "home"
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
        val email = parameters["register-email"]
        val password = parameters["register-password"]

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            call.respondText("Invalid email or password", status = HttpStatusCode.Unauthorized)
        } else {
            handleRegister(email, password)
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.handleRegister(
    email: String,
    password: String
) {
    val success = addUser(email, password)
    if (success) {
        call.response.headers.append("HX-Redirect", "/")
    } else {
        call.respondText("Email is already in use", status = HttpStatusCode.Unauthorized)
    }
}