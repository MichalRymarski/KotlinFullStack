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
import website.back.db.getUser
import website.front.components.login
import website.front.links.imports
import website.syntax_extensions.classes

fun Routing.LoginController() {
    get("/login") {
        call.respondHtml(status = HttpStatusCode.OK) {
            id = "home"
            imports()

            body(classes = classes(
                "bg-gradient-to-br",
                "from-gray-900",
                "min-h-screen",
                "to-gray-500",
                "flex",
                "items-center",
                "justify-center"
            )) {
                id = "login"
                login()
                script { src = "/static/test.js" }
            }
        }
    }

    post("/login") {
        val parameters = call.receiveParameters()
        val email = parameters["login-email"]
        val password = parameters["login-password"]

        println(parameters.toString())
        println(email)
        println(password)

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            call.respondText("Invalid username or password", status = HttpStatusCode.Unauthorized)
        } else {
           handleLogin(email, password)
        }
    }
}

private suspend  fun PipelineContext<Unit, ApplicationCall>.handleLogin(
    email: String,
    password: String
) {
    println(email)
    print(password)

    val success = getUser(email, password)
    if (success) {
        call.response.headers.append("HX-Redirect", "/")
    } else {
        call.respondText("Incorrect email or password", status = HttpStatusCode.Unauthorized)
    }
}



