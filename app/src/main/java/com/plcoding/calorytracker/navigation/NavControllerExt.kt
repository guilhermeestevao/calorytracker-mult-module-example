package com.plcoding.calorytracker.navigation

import androidx.navigation.NavController
import dev.guilhermeestevao.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate){
    this.navigate(event.route)
}