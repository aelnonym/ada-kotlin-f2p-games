package me.joaovictorsl.adafreetoplaygames.ui

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.joaovictorsl.adafreetoplaygames.model.Screenshot
import me.joaovictorsl.adafreetoplaygames.model.SystemRequirement

class Converters {
    @TypeConverter
    fun fromString(value: String): List<Screenshot> {
        val type = object : TypeToken<List<Screenshot>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toString(list: List<Screenshot>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromSystemRequirement(systemReq: SystemRequirement): String {
        return Gson().toJson(systemReq)
    }

    @TypeConverter
    fun toSystemRequirement(systemReqString: String): SystemRequirement {
        return Gson().fromJson(systemReqString, SystemRequirement::class.java)
    }
}