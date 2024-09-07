package website.back.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*


fun Application.Cors(){
    install(CORS) {
        allowCredentials = true
        allowHost("localhost:8080", schemes = listOf("http", "https"))
        allowHeaders { true }
        anyHost()
    }
}