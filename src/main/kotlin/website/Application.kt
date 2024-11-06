package website

import com.google.cloud.storage.StorageOptions
import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import website.back.db.Users
import website.back.plugins.Cors
import website.back.plugins.configureRouting
import website.back.plugins.configureSecurity
import website.back.plugins.configureSessionValidation

fun main(args : Array<String>) {
    KtorClient.init()
    setupDb()

    EngineMain.main(args)
}
//  ./gradlew run -t RUN THIS IN SECOND TERMINAL
// ./gradlew installDist -t RUN THIS IN FIRST TERMINAL

@Suppress("unused")
fun Application.module() {
    setupGoogleCloudStorage()
    Cors()
    configureRouting()
    configureSecurity()
    configureSessionValidation()
}


fun setupDb(){
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/postgres-db",
        driver = "org.postgresql.Driver",
        user = "admin",
        password = "admin"
    )
    transaction {
        SchemaUtils.create(Users)
    }
}

fun Application.setupGoogleCloudStorage(){
    val projectId = "youtubeclone-436411"
    val bucket = "clone_video"
    val storage = StorageOptions.newBuilder().setProjectId(projectId).build().service

}



