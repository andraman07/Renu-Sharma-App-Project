package com.renuSh.renusharmaappproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.renuSh.renusharmaappproject.ui.theme.RenuSharmaAppProjectTheme
import com.renush.auth.presentation.nav_graph.NavGraph
import com.renush.auth.presentation.screens.OpenAppScreen
import com.renush.auth.presentation.screens.RegisterScreen
import com.renush.auth.presentation.screens.SignInScreen
import com.renush.auth.presentation.screens.tab_screens.InternshipDetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            RenuSharmaAppProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//    InternshipDetailsScreen()
//    RegisterScreen()
//    SignInScreen()
//    OpenAppScreen()
    NavGraph()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RenuSharmaAppProjectTheme {
        Greeting("Android")
    }
}