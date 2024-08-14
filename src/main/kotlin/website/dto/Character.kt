package website.dto

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

@Serializable
data class Location(
    val name: String,
    val url: String
)

@Serializable
data class Origin(
    val name: String,
    val url: String
)
