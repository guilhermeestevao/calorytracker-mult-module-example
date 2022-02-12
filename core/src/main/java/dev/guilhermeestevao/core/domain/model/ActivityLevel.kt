package dev.guilhermeestevao.core.domain.model

sealed class ActivityLevel(val name: String) {
    object Low: ActivityLevel("low")
    object Medim: ActivityLevel("midium")
    object High: ActivityLevel("high")

    companion object{
        fun fromString(name: String): ActivityLevel {
            return when(name) {
                "low" -> Low
                "midium"-> Medim
                "high"-> High
                else -> Medim
            }
        }
    }
}