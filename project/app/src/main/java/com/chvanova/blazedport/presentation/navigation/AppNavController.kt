package com.chvanova.blazedport.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chvanova.blazedport.presentation.fr.ChooseGameMode
import com.chvanova.blazedport.presentation.fr.PVE_Screen
import com.chvanova.blazedport.presentation.fr.PVP_Screen
import com.chvanova.blazedport.presentation.fr.RuleScreen
import com.chvanova.blazedport.presentation.fr.StartGameScreen
import com.chvanova.blazedport.presentation.view_models.GameZoneViewModel

@Composable
fun AppNavController(
    navController: NavHostController
) {
    val gameZoneViewModel: GameZoneViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.StartGame.route,
        builder = {
            this.composable(Screen.StartGame.route) { StartGameScreen(navController = navController) }
            this.composable(Screen.GameZoneScreen.route) { PVP_Screen(navController = navController, gameZoneViewModel = gameZoneViewModel) }
            this.composable(Screen.RuleScreen.route) { RuleScreen(navController = navController) }
            this.composable(Screen.StartPvpGame.route) {  }
            this.composable(Screen.ChooseGameModel.route) { ChooseGameMode(navController = navController) }
            this.composable(Screen.PVEScreen.route) { PVE_Screen(navController = navController, gameZoneViewModel = gameZoneViewModel) }
        }
    )

}