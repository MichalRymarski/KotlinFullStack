package website.back.db

import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import website.VideoObject

private const val MAX_VARCHAR_LENGTH = 512

object Videos : Table("videos") {
    val id = integer("id").autoIncrement()
    val userEmail = varchar("user_email", MAX_VARCHAR_LENGTH).references(Users.email)
    val videoUrl = varchar("video_url", MAX_VARCHAR_LENGTH)
    val thumbnailUrl = varchar("thumbnail_url", MAX_VARCHAR_LENGTH)
    val title = varchar("title", MAX_VARCHAR_LENGTH)

    override val primaryKey = PrimaryKey(id)
}

fun migrateVideos() = transaction {
    SchemaUtils.createMissingTablesAndColumns(Videos)
}

fun handleVideoSave(
    sessionEmail: String,
    videoURL: String,
    thumbnailURL: String,
    videoTitle: String,
): Boolean {
    return try {
        transaction {
            Videos.insert {
                it[userEmail] = sessionEmail
                it[videoUrl] = videoURL
                it[thumbnailUrl] = thumbnailURL
                it[title] = videoTitle
            }
        }

        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}

fun getVideosForUser(sessionEmail: String): List<VideoObject> {
    return transaction {
        Videos.select(Videos.id, Videos.userEmail, Videos.videoUrl, Videos.thumbnailUrl, Videos.title)
            .where(Videos.userEmail eq sessionEmail)
            .map {
                VideoObject(
                    id = it[Videos.id].toString(),
                    thumbnailUrl = it[Videos.thumbnailUrl],
                    title = it[Videos.title],
                    videoUrl = it[Videos.videoUrl], // Ensure this column is selected
                    ownerEmail = it[Videos.userEmail]
                )
            }
    }
}

fun getRandom30Videos() : List<VideoObject>{
    return transaction {
        Videos.selectAll().limit(30).map {
            VideoObject(
                id = it[Videos.id].toString(),
                thumbnailUrl = it[Videos.thumbnailUrl],
                title = it[Videos.title],
                videoUrl = it[Videos.videoUrl], // Ensure this column is selected
                ownerEmail = it[Videos.userEmail]
            )
        }
    }
}

fun getVideoById(id : Int) : VideoObject{
    return transaction {
        Videos.select(Videos.id, Videos.userEmail, Videos.videoUrl, Videos.thumbnailUrl, Videos.title)
            .where(Videos.id eq id)
            .map {
                VideoObject(
                    id = it[Videos.id].toString(),
                    thumbnailUrl = it[Videos.thumbnailUrl],
                    title = it[Videos.title],
                    videoUrl = it[Videos.videoUrl], // Ensure this column is selected
                    ownerEmail = it[Videos.userEmail]
                )
            }.first()
    }
}

fun getRandom20Videos() : List<VideoObject>{
    return transaction {
        Videos.selectAll().limit(20).map {
            VideoObject(
                id = it[Videos.id].toString(),
                thumbnailUrl = it[Videos.thumbnailUrl],
                title = it[Videos.title],
                videoUrl = it[Videos.videoUrl], // Ensure this column is selected
                ownerEmail = it[Videos.userEmail]
            )
        }
    }
}