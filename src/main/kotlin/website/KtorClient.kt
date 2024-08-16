package website

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import website.front.dto.Character

const val API_CHARACTER_URL = "https://rickandmortyapi.com/api/character/"

object KtorClient {

    private lateinit var client: HttpClient
    private lateinit var nonLoggingClient : HttpClient

    fun init() {
        client = HttpClient(CIO) {
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
        }

        nonLoggingClient = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
        }
    }

    suspend fun fetchCharacter(index: Int): Character = client.get("$API_CHARACTER_URL$index").body<Character>()
    suspend fun fetchCharacterWithoutLogging(index: Int): Character = nonLoggingClient.get("$API_CHARACTER_URL$index").body<Character>()

}
