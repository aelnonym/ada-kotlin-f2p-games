package me.joaovictorsl.adafreetoplaygames.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: Int = 540,
    val title: String = "Overwatch 2",
    val thumbnail: String = "https://www.freetogame.com/g/540/thumbnail.jpg",
    val status: String = "Live",
    @SerializedName("short_description")
    val shortDescription: String = "A hero-focused first-person team shooter from Blizzard Entertainment.",
    val description: String = "A hero-focused first-person team shooter from Blizzard Entertainment.",
    @SerializedName("game_url")
    val gameUrl: String = "https://www.freetogame.com/open/overwatch-2",
    val genre: String = "Shooter",
    val platform: String = "PC (Windows)",
    val publisher: String = "Activision Blizzard",
    val developer: String = "Blizzard Entertainment",
    @SerializedName("release_date")
    val releaseDate: String = "2022-10-04",
    @SerializedName("freetogame_profile_url")
    val freetogameProfileUrl: String = "https://www.freetogame.com/overwatch-2",
    @SerializedName("minimum_system_requirements")
    val minSystemReq: SystemRequirement = SystemRequirement(),
    val screenshots: List<Screenshot> = listOf()
    ) : Parcelable {
    override fun toString(): String {
        return """
            id = $id
            title = $title
            thumbnail = $thumbnail
            status = $status
            shortDescription = $shortDescription
            description = $description
            gameUrl = $gameUrl
            genre = $genre
            platform = $platform
            publisher = $publisher
            developer = $developer
            releaseDate = $releaseDate
            freetogameProfileUrl = $freetogameProfileUrl
            minSystemReq = $minSystemReq
            screenshots = $screenshots
        """.trimIndent()
    }
}
