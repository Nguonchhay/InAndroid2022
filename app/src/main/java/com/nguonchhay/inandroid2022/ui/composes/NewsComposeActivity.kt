package com.nguonchhay.inandroid2022.ui.composes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nguonchhay.inandroid2022.R
import com.nguonchhay.inandroid2022.ui.composes.ui.theme.InAndroid2022Theme

class NewsComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InAndroid2022Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NewsContent()
                }
            }
        }
    }
}

sealed class BottomNavItems (
    val title: String,
    val icon: Int,
    val route: String
) {
    object Home: BottomNavItems("Home", R.drawable.icon_home, "home_content")
    object News: BottomNavItems("News", R.drawable.icon_news, "news_content")
    object Setting: BottomNavItems("Setting", R.drawable.icon_setting, "setting_content")
}

val navItems = listOf(
    BottomNavItems.Home,
    BottomNavItems.News,
    BottomNavItems.Setting
)

@Composable
fun HomeContent() {
    Text(text = "Home content")
}

@Composable
fun NewsScreenContent() {
    Text(text = "News content")
}

@Composable
fun SettingContent() {
    Text(text = "Setting content")
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewsContent() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Green,
                content = { Text(text = "Flash News") }
            )
        },
        bottomBar = { BottomNavBar(navController = navController) },
        content = {
            NavigationHost(navController)
        }
    )
}

@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItems.Home.route,
        builder = {
            composable(BottomNavItems.Home.route) {
                HomeContent()
            }
            composable(BottomNavItems.News.route) {
                NewsScreenContent()
            }
            composable(BottomNavItems.Setting.route) {
                SettingContent()
            }
        }
    )
}

@Composable
fun BottomNavBar(
    navController: NavController,
    items: List<BottomNavItems> = navItems
) {
    BottomNavigation {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { navItem ->
            BottomNavigationItem(
                label = { Text(text = navItem.title) },
                alwaysShowLabel = true,
                selected = currentRoute == navItem.route,
                icon = {
                    Icon(
                        painterResource(id = navItem.icon),
                        contentDescription = navItem.title
                    )
                },
                onClick = {
                    navController.navigate(navItem.route)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    InAndroid2022Theme {
        NewsContent()
    }
}