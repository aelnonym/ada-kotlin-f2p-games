package me.joaovictorsl.adafreetoplaygames.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SystemRequirement(
    val os: String = "Windows 7 64-Bit (SP1) or Windows 10 64-Bit",
    val processor: String = "Intel Core i3-4340 or AMD FX-6300",
    val memory: String = "8GB RAM",
    val graphics: String = "NVIDIA GeForce GTX 670 / GeForce GTX 1650 or Radeon HD 7950",
    val storage: String = "175GB HD space"
) : Parcelable {
    override fun toString(): String {
        return """
            os = $os
            processor = $processor
            memory = $memory
            graphics = $graphics
            storage = $storage
        """.trimIndent()
    }
}
