package website.back.db

import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction

const val MAX_VARCHAR_LENGTH = 255

object Users : Table("users") {
    val id = integer("id").autoIncrement()
    val email = varchar(name = "email", length = MAX_VARCHAR_LENGTH).uniqueIndex()
    val user_password = varchar(name = "user_password", length = MAX_VARCHAR_LENGTH)
    override val primaryKey = PrimaryKey(id)
}

fun addUser(usersEmail: String, usersPassword: String): Boolean {
    try {
        transaction {
            Users.insert {
                it[email] = usersEmail
                it[user_password] = usersPassword
            } get Users.id
        }

    } catch (e: ExposedSQLException) {
        return false //Email already exists
    }

    return true //Email doesn't exist
}

fun getUser(usersEmail: String, usersPassword: String): Boolean {
    val user = transaction {
        val query = Users.selectAll().where(Users.user_password eq usersPassword and (Users.email eq usersEmail))
        println("SQL Query: ${query.prepareSQL(TransactionManager.current())}")
        query.singleOrNull()
    }

    val exists = user != null
    if (exists) {
        val usersEmail = user!![Users.email]
        val password = user!![Users.user_password]
        println("User: $usersEmail, $password")
    }


    return exists
}