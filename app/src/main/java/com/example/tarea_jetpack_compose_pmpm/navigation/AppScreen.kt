package com.example.tarea_jetpack_compose_pmpm.navigation

sealed class AppScreen(val route: String) {
    object FirstScreen: AppScreen("FirstScreen")
    object SecondScreen: AppScreen("SecondScreen")
}