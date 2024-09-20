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
import website.front.components.Register
import website.front.links.imports
import website.syntax_extensions.classes

fun Routing.RegistrationController() {
    get("/register") {
        call.respondHtml(status = HttpStatusCode.OK) {
            imports()

            body(classes = classes("overflow-hidden")) {
                id = "home"
                Register()
                script { src = "/static/global_scripts.js" }
            }
        }
    }
    post("/register") {
        val parameters = call.receiveParameters()
        val email = parameters["register-email"]
        val password = parameters["register-password"]

        println("Email: $email")
        println("Password: $password")


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
    if(!emailValid(email)){
        call.respondText("Invalid email", status = HttpStatusCode.Unauthorized)
        return
    }

    val success = addUser(email, password)
    if (success) {
        call.response.headers.append("HX-Redirect", "/login")
    } else {
        call.respondText("Email is already in use", status = HttpStatusCode.Unauthorized)
    }
}

private suspend fun emailValid(email:String): Boolean {
    val regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex()
    return email.matches(regex)
}