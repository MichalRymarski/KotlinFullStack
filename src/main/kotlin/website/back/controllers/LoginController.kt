package website.back.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.pipeline.*
import kotlinx.html.body
import kotlinx.html.id
import kotlinx.html.script
import website.back.db.getUserNickname
import website.back.plugins.UserSession
import website.front.ANSI_RED
import website.front.ANSI_RESET
import website.front.components.Login
import website.front.links.imports
import website.syntax_extensions.classes
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours

fun Routing.LoginController() {
    get("/login") {
        call.request.headers.forEach { key, values ->
            println("Header: $key = ${values.joinToString()}")
        }

        //    call.respondFile(File("D:\\intellij\\PROJEKTY\\KtorWebsite-HTMX-TAILWIND\\src\\main\\kotlin\\tailwind.html"))
        //! THIS FOOKING WORKS !!!
        call.respondHtml(status = HttpStatusCode.OK) {
            imports()

            body(classes = classes("overflow-hidden")) {
                id = "home"
                Login()
                script { src = "/static/global_scripts.js" }
            }
        }
    }

    post("/login") {
        val parameters = call.receiveParameters()
        val email = parameters["login-email"]
        val password = parameters["login-password"]
        val rememberMe = parameters["rememberMe"]
        val rememberUsed = rememberMe == "on"

        println("REMEMBER: ${rememberMe.toString()}")
        println(parameters.toString())
        println(email)
        println(password)

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            call.respondText("Invalid username or password", status = HttpStatusCode.Unauthorized)
        } else {
            handleLogin( email, password, rememberUsed)
        }
    }

    get("/logout") {
        call.sessions.clear<UserSession>()
        call.response.headers.append("HX-Redirect", "/")
        call.respondText("Logged out successfully")
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.handleLogin(
    email: String,
    password: String,
    rememberUsed: Boolean
) {
    println("$ANSI_RED HANDLE LOGIN $ANSI_RESET")

    val nick = getUserNickname(email, password)
    val success = nick != null

    if (success) {
        call.sessions.set(UserSession(nick!!, email))
        call.response.cookies.append(
            Cookie(
                name = "REMEMBER_ME",
                value = rememberUsed.toString(),
                maxAge = if (rememberUsed) 30.days.inWholeMilliseconds.toInt() else 1.hours.inWholeMilliseconds.toInt(),
                secure = false,
                httpOnly = true
            )
        )

        call.response.headers.append("HX-Redirect", "/")
    } else {
        call.respondText("Incorrect email or password", status = HttpStatusCode.Unauthorized)
    }
}




