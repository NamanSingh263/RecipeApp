package com.example.RecipeApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.RecipeApp.ui.theme.MyRecipeAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(modifier = Modifier.safeDrawingPadding()) {
                MyRecipeAppTheme {
                    val navController = rememberNavController()
                    RecipeApp(navController = navController)
                }
            }
        }
    }
}



