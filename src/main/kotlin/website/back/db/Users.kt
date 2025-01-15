package website.back.db

import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction

private const val MAX_VARCHAR_LENGTH = 255

object Users : Table("users") {
    val nick = varchar(name = "nick", length = MAX_VARCHAR_LENGTH)
    val id = integer("id").autoIncrement()
    val email = varchar(name = "email", length = MAX_VARCHAR_LENGTH).uniqueIndex()
    val user_password = varchar(name = "user_password", length = MAX_VARCHAR_LENGTH)
    override val primaryKey = PrimaryKey(id)
}

fun migrateUsers() = transaction {
    exec(stmt = "ALTER TABLE users ADD COLUMN IF NOT EXISTS nick VARCHAR($MAX_VARCHAR_LENGTH)")
    exec("UPDATE users SET nick = 'default_nick' WHERE nick IS NULL")
}

fun addUser(usersNick: String, usersEmail: String, usersPassword: String): Boolean {
    try {
        transaction {
            Users.insert {
                it[nick] = usersNick
                it[email] = usersEmail
                it[user_password] = usersPassword
            } get Users.id
        }

    } catch (e: ExposedSQLException) {
        return false //Email already exists
    }

    return true //Email doesn't exist
}

fun getUserNickname(usersEmail: String, usersPassword: String): String?{
    val user = transaction {
        val query = Users.selectAll().where(
            Users.user_password eq usersPassword
                    and (Users.email eq usersEmail)
        )

        println("SQL Query: ${query.prepareSQL(TransactionManager.current())}")
        query.singleOrNull()
    }

    return user?.get(Users.nick) //it means found ROW get nick COLUMN
}

fun changeUserNick(userEmail: String, newNick : String){
    transaction {
        Users.update({Users.email eq userEmail}) {
            it[nick] = newNick
        }
    }
}