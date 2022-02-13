package com.plcoding.calorytracker.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.guilhermeestevao.core.data.preferences.DefaultPreferences
import dev.guilhermeestevao.core.domain.preferences.Preferences
import dev.guilhermeestevao.core.domain.use_case.FilterOutDigits
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreference(app: Application): SharedPreferences{
        return app.getSharedPreferences("shared_pref", MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPref: SharedPreferences): Preferences {
        return DefaultPreferences(sharedPref)
    }

    @Provides
    @Singleton
    fun provideFilterOutDigits(): FilterOutDigits{
        return FilterOutDigits()
    }

}