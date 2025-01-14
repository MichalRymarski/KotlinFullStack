package website.back.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import kotlinx.html.*
import website.GoogleCloudStorageService
import website.back.db.changeUserNick
import website.back.plugins.UserSession
import website.front.components.profile.ProfileView
import website.front.links.imports
import website.syntax_extensions.classes

fun Routing.ProfileController(storageService: GoogleCloudStorageService) {

    get("/profile") {
        val profileEmail = call.request.queryParameters["email"]
        val userSession = call.sessions.get<UserSession>()

        when (profileEmail) {
            null -> {
                call.respondHtml(status = HttpStatusCode.NotFound) {
                    imports()

                    body(classes = classes("overflow-hidden ")) {
                        id = "home"
                        attributes["hx-ext"] = "alpine-morph"
                        h5 { +"Hello, NULL!" }
                    }
                }
            }

            userSession?.email -> {
                call.respondHtml(status = HttpStatusCode.OK) {
                    imports()

                    body(classes = classes("overflow-hidden ")) {
                        id = "home"
                        attributes["hx-ext"] = "alpine-morph"
                        ProfileView(userSession)
                    }
                }
            }

            else -> {
                call.respondHtml(status = HttpStatusCode.BadRequest) {
                    imports()

                    body(classes = classes("overflow-hidden ")) {
                        id = "home"
                        attributes["hx-ext"] = "alpine-morph"
                        h5 { +"Hello, BAD EMAIL!" }
                    }
                }
            }
        }
    }

    post("/profile") {
        val userSession = call.sessions.get<UserSession>()
        val newNick = call.receiveParameters()["nickname"]

        if (userSession != null && newNick != null) {
            val userEmail = userSession.email

            userSession.nick = newNick
            call.sessions.set(userSession)
            changeUserNick(userEmail,newNick)

            call.respondHtml(status = HttpStatusCode.OK) {
                body {
                    input(classes = "mt-1 block w-full rounded-md bg-gray-700 border-gray-600 shadow-base focus:border-blue-500 focus:ring focus:ring-blue-500 focus:ring-opacity-50 text-gray-200 py-3") {
                        type = InputType.text
                        id = "nickname"
                        name = "nickname"
                        value = newNick
                    }
                }
            }
        } else {
            call.respond(HttpStatusCode.BadRequest, "Invalid request")
        }
    }

}