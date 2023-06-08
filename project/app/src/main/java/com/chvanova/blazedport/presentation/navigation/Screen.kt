package com.chvanova.blazedport.presentation.navigation

sealed class Screen(val route : String) {
    object StartGame: Screen("blazed_game/start_game")
    object StartPvpGame: Screen("blazed_game/start_pvp_game")

    object RuleScreen: Screen(route = "blazed_game/rule_screen")
    object GameZoneScreen: Screen(route = "blazed_game/game_zone_screen")

    object ChooseGameModel: Screen(route = "blazed_game/choose_game_zone")

    object PVEScreen: Screen(route = "blazed_game/pve_screen")
}
