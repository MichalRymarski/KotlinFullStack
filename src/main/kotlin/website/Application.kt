package website

import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import website.back.db.Users
import website.back.db.Videos
import website.back.db.migrateUsers
import website.back.db.migrateVideos
import website.back.plugins.Cors
import website.back.plugins.configureRouting
import website.back.plugins.configureSecurity
import website.back.plugins.configureSessionValidation
import java.util.*

fun main(args : Array<String>) {
    KtorClient.init()

    setupDb()
    migrateUsers()
    migrateVideos()

    EngineMain.main(args)
}
//  ./gradlew run -t RUN THIS IN SECOND TERMINAL
// ./gradlew installDist -t RUN THIS IN FIRST TERMINAL

@Suppress("unused")
fun Application.module() {
    val storageService = GoogleCloudStorageService()
    setupGoogleCloudStorage()
    Cors()
    configureRouting(storageService)
    configureSecurity()
    configureSessionValidation()
}

class GoogleCloudStorageService(
    private val projectId: String = "youtubeclone-436411",
    private val bucketName: String = "clone_video",
) {
    private val storage: Storage = StorageOptions.newBuilder()
        .setProjectId(projectId)
        .build()
        .service

    fun deleteVideo(fileName: String) {
        // Make sure the fileName starts with "videos/" if that's your folder structure
        val blobId = BlobId.of(bucketName, if (fileName.startsWith("videos/")) fileName else "videos/$fileName")
        val deleted = storage.delete(blobId)

        if (!deleted) {
            throw IllegalStateException("Failed to delete video: $fileName")
        }
    }


     fun uploadVideo(part: PartData.FileItem): String {
        val fileName = generateUniqueFileName(part.originalFileName ?: "video")
        val blobId = BlobId.of(bucketName, "videos/$fileName")
        val blobInfo = BlobInfo.newBuilder(blobId)
            .setContentType(part.contentType?.toString())
            .build()

        part.streamProvider().use { inputStream ->
            storage.create(blobInfo, inputStream.readBytes())
        }

        return "https://storage.googleapis.com/$bucketName/videos/$fileName"
    }

    fun uploadImage(part : PartData.FileItem) : String{
        val fileName = generateUniqueFileName(part.originalFileName ?: "image")
        val blobId = BlobId.of(bucketName, "images/$fileName")
        val blobInfo = BlobInfo.newBuilder(blobId)
            .setContentType(part.contentType?.toString())
            .build()

        part.streamProvider().use { inputStream ->
            storage.create(blobInfo, inputStream.readBytes())
        }

        return "https://storage.googleapis.com/$bucketName/images/$fileName"
    }

    fun getUrl(fileName: String): String {
        return "https://storage.googleapis.com/$bucketName/${fileName}"
    }


    fun listVideos(): List<String> {
        return storage.list(bucketName, Storage.BlobListOption.prefix("videos/"))
            .iterateAll()
            .filter { blob -> !blob.name.endsWith("/") }
            .map { blob -> getUrl(blob.name) }
    }

    private fun generateUniqueFileName(originalFileName: String): String {
        val extension = originalFileName?.substringAfterLast(".", "mp4") ?: "mp4"
        return "${UUID.randomUUID()}.${extension}"
    }
}

data class VideoObject(
    val id : String,
    val ownerEmail : String,
    val title: String,
    val videoUrl: String,
    val thumbnailUrl: String
)


fun setupDb(){
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/postgres-db",
        driver = "org.postgresql.Driver",
        user = "admin",
        password = "admin"
    )
    transaction {
        SchemaUtils.create(Users)
        SchemaUtils.create(Videos)
    }
}

fun Application.setupGoogleCloudStorage(){
    val projectId = "youtubeclone-436411"
    val bucket = "clone_video"
    val storage = StorageOptions.newBuilder().setProjectId(projectId).build().service

}



