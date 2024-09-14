package website

import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import website.back.db.Users
import website.back.plugins.Cors
import website.back.plugins.configureRouting
import website.back.plugins.configureSecurity

fun main(args : Array<String>) {
    KtorClient.init()
    setupDb()

    EngineMain.main(args)
}
//  ./gradlew run -t
// ./gradlew installDist -t

@Suppress("unused")
fun Application.module() {
    Cors()
    configureRouting()
    configureSecurity()
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

