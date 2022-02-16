package dev.guilhermeestevao.onboarding_domain.use_case

import dev.guilhermeestevao.core.util.UiText
import dev.guilhermeestevao.onboarding_domain.R

class ValidateNutrients {
    operator fun invoke(
        carbsRatioText: String,
        proteinRatioText: String,
        fatRatioText: String
    ): Result {
        val carbsRatio = carbsRatioText.toFloatOrNull()
        val proteinRatio = proteinRatioText.toFloatOrNull()
        val fatRatio = fatRatioText.toFloatOrNull()
        if(carbsRatio == null || proteinRatio == null || fatRatio == null){
            return Result.Error(
                message = UiText.StringResoruce(R.string.error_invalid_values)
            )
        }
        if(carbsRatio+proteinRatio+fatRatio != 100f){
            return Result.Error(
                message = UiText.StringResoruce(R.string.error_not_100_percent)
            )
        }

        return Result.Success(carbsRatio, proteinRatio, fatRatio)
    }

    sealed class Result{
        data class Success(
            val carbsRatio: Float,
            val proteinRatio: Float,
            val fatRatio: Float
        ): Result()
        data class Error(val message: UiText): Result()
    }
}