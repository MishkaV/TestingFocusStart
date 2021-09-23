package ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import model.DailyData
import utils.Screens

@Composable
fun Navigation(dailyData: DailyData){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.CurrencyList.route) {
        composable(route = Screens.CurrencyList.route) {
            CurrencyList(dailyData.valuteList, navController)
        }
        composable(
            route = Screens.CurrencyConverter.route + "/{charCode}/{name}/{value}",
            arguments = listOf(
                navArgument("charCode") {
                    type = NavType.StringType
                },
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("value") {
                    type = NavType.FloatType
                },
            )
        ) { input ->
            val charCode = input.arguments?.getString("charCode")
            val name = input.arguments?.getString("name")
            val value = input.arguments?.getFloat("value")
            if (charCode != null && name != null && value != null) {
                CurrencyConverter(
                    charCode = charCode,
                    name = name,
                    value = value
                )
            }
        }


    }

}