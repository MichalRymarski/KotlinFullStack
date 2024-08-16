
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import website.controllers.CharactersController
import website.controllers.HomeController


fun Application.configureRouting() {
    routing {
        staticResources("/static", "static")


        HomeController()
        CharactersController()
    }
}







