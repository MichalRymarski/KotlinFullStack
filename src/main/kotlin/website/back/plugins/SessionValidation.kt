package website.back.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.sessions.*
import io.ktor.util.date.*
import website.front.ANSI_GREEN
import website.front.ANSI_RED
import website.front.ANSI_RESET
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours

fun Application.configureSessionValidation() {
    intercept(ApplicationCallPipeline.Call) {
        println("$ANSI_RED INTERCEPTED CALL $ANSI_RESET")
        val userSession = call.sessions.get<UserSession>()
        if (userSession != null) {
            val rememberMeCookie = call.request.cookies["REMEMBER_ME"]
            val isRemembered = rememberMeCookie == "true"

            val sessionDuration = if (isRemembered) 30.days.inWholeMilliseconds else 1.hours.inWholeMilliseconds
            val sessionExpiration = userSession.creationTime + sessionDuration

            println("$ANSI_GREEN Session duration: ${sessionDuration} $ANSI_RESET")
            if (System.currentTimeMillis() > sessionExpiration) {
                call.sessions.clear<UserSession>()
                call.response.cookies.append(
                    Cookie(
                    name = "REMEMBER_ME",
                    value = isRemembered.toString(),
                    maxAge = sessionExpiration.toInt(),
                    expires = GMTDate(sessionExpiration)
                )
                )
            }
        }
    }
}
