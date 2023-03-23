package me.joaovictorsl.adafreetoplaygames.model

import com.google.gson.annotations.SerializedName

data class Game(
    val id: Int = 540,
    val title: String = "Overwatch 2",
    val thumbnail: String = "https://www.freetogame.com/g/540/thumbnail.jpg",
    @SerializedName("short_description")
    val shortDescription: String = "A hero-focused first-person team shooter from Blizzard Entertainment.",
    @SerializedName("game_url")
    val gameUrl: String = "https://www.freetogame.com/open/overwatch-2",
    val genre: String = "Shooter",
    val platform: String = "PC (Windows)",
    val publisher: String = "Activision Blizzard",
    val developer: String = "Blizzard Entertainment",
    @SerializedName("releaseDate")
    val releaseDate: String = "2022-10-04",
    @SerializedName("freetogame_profile_url")
    val freetogameProfileUrl: String = "https://www.freetogame.com/overwatch-2") {
}