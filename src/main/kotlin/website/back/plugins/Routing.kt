package website.back.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.h1
import website.back.controllers.CharactersController
import website.back.controllers.HomeController
import website.back.controllers.LoginController
import website.back.controllers.RegistrationController


fun Application.configureRouting() {
    routing {
        staticResources("/static", "static")

        post("/test") {
            val checkboxValue = call.receiveParameters()
            println(checkboxValue)
            call.respondHtml(status = HttpStatusCode.OK){
                body {
                    h1 { +"Hello, World!" }
                }
            }
        }

        RegistrationController()
        LoginController()
        HomeController()
        CharactersController()
    }
}






