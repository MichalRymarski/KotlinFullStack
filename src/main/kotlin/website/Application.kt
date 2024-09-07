package website

import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import website.back.db.Users
import website.back.plugins.configureRouting

fun main(args : Array<String>) {
    KtorClient.init()
    setupDb()

    EngineMain.main(args)
}

@Suppress("unused")
fun Application.module() {
    configureRouting()
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

