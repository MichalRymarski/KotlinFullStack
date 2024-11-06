package website.back.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import kotlinx.html.body
import kotlinx.html.h5
import website.back.plugins.UserSession
import website.front.links.imports

fun Routing.ChannelController() {

    get("/channel") {
        val profileEmail = call.request.queryParameters["email"]
        val userSession = call.sessions.get<UserSession>()

        when (profileEmail) {
            null -> {
                call.respondHtml(status = HttpStatusCode.NotFound) {
                    imports()

                    body {
                        h5 { +"Hello, DOESNT CHANNEL DOESNT EXIST!" }
                    }
                }
            }
            userSession?.email -> {
                call.respondHtml(status = HttpStatusCode.OK) {
                    imports()

                    body {
                        h5 { +"Hello, YOUR CHANNEL!" }
                    }
                }
            }
            else -> {
                call.respondHtml(status = HttpStatusCode.BadRequest) {
                    imports()

                    body {
                        h5 { +"Hello, SOMEONE ELSES CHANNEL!" }
                    }
                }
            }
        }
    }
}