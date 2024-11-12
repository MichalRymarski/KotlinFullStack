package website.back.plugins

import io.ktor.server.application.*
import io.ktor.server.sessions.*
import kotlin.collections.set

data class UserSession(
    var nick: String,
    val email: String,
    val creationTime: Long = System.currentTimeMillis(),
    var profilePictureUrl : String = "",
    var color : String = ""
){
    init {
        profilePictureUrl = if (nick == "Bazinga") "https://fastly.picsum.photos/id/511/200/300.jpg?hmac=3pjxomHmNfWivxE47hYNY3VdnJTTJtcRJmQ3ihqJcBA" else ""
        color = generateColorFromEmail(email)
    }

    private fun generateColorFromEmail(email: String): String {
        val hash = email.hashCode()
        // Convert to hex and take the last 6 digits
        val color = "#" + Integer.toHexString(hash).takeLast(6)
        return color
    }

    fun getInitial(): Char {
        return email.first().uppercaseChar()
    }
}


fun Application.configureSecurity() {
    install(Sessions) {
        cookie<UserSession>("USER_SESSION") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 3600 // 1 hour
            cookie.extensions["SameSite"] = "lax"
            cookie.secure = false
        }
    }
}

    /*
        authentication {
            oauth("auth-oauth-google") {
                urlProvider = { "http://localhost:8080/callback" }
                providerLookup = {
                    OAuthServerSettings.OAuth2ServerSettings(
                        name = "google",
                        authorizeUrl = "https://accounts.google.com/o/oauth2/auth",
                        accessTokenUrl = "https://accounts.google.com/o/oauth2/token",
                        requestMethod = HttpMethod.Post,
                        clientId = System.getenv("GOOGLE_CLIENT_ID"),
                        clientSecret = System.getenv("GOOGLE_CLIENT_SECRET"),
                        defaultScopes = listOf("https://www.googleapis.com/auth/userinfo.profile")
                    )
                }
                client = HttpClient(Apache)
            }
        }
    */

    /*   authenticate("auth-oauth-google") {
           get("/login") {
               call.respondRedirect("/callback")
           }

           get("/callback") {
               val principal: OAuthAccessTokenResponse.OAuth2? = call.authentication.principal()
               call.sessions.set(UserSession(principal?.accessToken.toString()))
               call.respondRedirect("/hello")
           }
       }*/

