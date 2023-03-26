package me.joaovictorsl.adafreetoplaygames.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Screenshot(
    val id: Int = 999999,
    val image: String = "https://www.freetogame.com/g/452/Call-of-Duty-Warzone-1.jpg"
) : Parcelable
