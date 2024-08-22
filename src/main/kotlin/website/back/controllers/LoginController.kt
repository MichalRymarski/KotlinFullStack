package website.back.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.id
import kotlinx.html.script
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
        val username = parameters["login-username"]
        val password = parameters["login-password"]

        println(parameters.toString())
        println(username)
        println(password)

        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            call.respondText("Invalid username or password", status = HttpStatusCode.Unauthorized)
        } else {
            call.response.headers.append("HX-Redirect", "/")
        }
    }
}



