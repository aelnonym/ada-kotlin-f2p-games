package me.joaovictorsl.adafreetoplaygames.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "games")
@Parcelize
data class Game(
    @PrimaryKey
    val id: Int = 540,
    val title: String = "DEFAULT | Overwatch 2",
    val thumbnail: String = "https://www.freetogame.com/g/540/thumbnail.jpg",
    val status: String = "DEFAULT | Live",
    @SerializedName("short_description")
    val shortDescription: String = "DEFAULT | A hero-focused first-person team shooter from Blizzard Entertainment.",
    val description: String = "DEFAULT | A hero-focused first-person team shooter from Blizzard Entertainment.",
    @SerializedName("game_url")
    val gameUrl: String = "https://www.freetogame.com/open/overwatch-2",
    val genre: String = "DEFAULT | Shooter",
    val platform: String = "DEFAULT | PC (Windows)",
    val publisher: String = "DEFAULT | Activision Blizzard",
    val developer: String = "DEFAULT | Blizzard Entertainment",
    @SerializedName("release_date")
    val releaseDate: String = "DEFAULT | 2022-10-04",
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
