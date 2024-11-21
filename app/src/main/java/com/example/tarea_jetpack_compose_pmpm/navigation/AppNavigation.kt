package com.example.tarea_jetpack_compose_pmpm.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tarea_jetpack_compose_pmpm.screen.FirstScreen
import com.example.tarea_jetpack_compose_pmpm.screen.SecondScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(modifier: Modifier) {
    val navControlador = rememberNavController()
    NavHost(navController = navControlador, startDestination = AppScreen.FirstScreen.route){
        composable(AppScreen.FirstScreen.route){
            FirstScreen(modifier, navControlador)
        }
        composable(AppScreen.SecondScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text") {
                type = NavType.StringType
            })
        ){
            SecondScreen(modifier, navControlador, it.arguments?.getString("text"))
        }
    }
}