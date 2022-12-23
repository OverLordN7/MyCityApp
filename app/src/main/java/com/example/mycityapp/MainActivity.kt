package com.example.mycityapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mycityapp.data.Screen
import com.example.mycityapp.ui.theme.MyCityAppTheme
import com.example.mycityapp.ui.theme.screens.FirstScreen
import com.example.mycityapp.ui.theme.screens.SecondScreen
import com.example.mycityapp.ui.theme.screens.ThirdScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyCityApp()
                }
            }
        }
    }
}

@Composable
fun MyCityApp(){
    //Nav host

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.FirstScreen.route){
        composable(route = Screen.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(
            route = Screen.SecondScreen.route + "/{category_type}",
            arguments = listOf(
                navArgument("category_type"){
                    type = NavType.StringType
                    defaultValue = "Cinema"
                    nullable = true
                }

            )
        ){ entry ->
            SecondScreen(
                categoryTypeString = entry.arguments?.getString("category_type"),
                navController = navController
            )
        }
        composable(
            route = Screen.ThirdScreen.route + "/{place_desc}/{place_img}",
            arguments = listOf(
                navArgument("place_desc"){
                    type = NavType.StringType
                    defaultValue = "None"
                    nullable = false
                },
                navArgument("place_img"){
                    type = NavType.StringType
                    defaultValue = "None"
                    nullable = false
                }
            )
        ){
            ThirdScreen(
                descRes = it.arguments?.getString("place_desc"),
                imageRes = it.arguments?.getString("place_img")
            )
        }
    }

}





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCityAppTheme {
        MyCityApp()
    }
}