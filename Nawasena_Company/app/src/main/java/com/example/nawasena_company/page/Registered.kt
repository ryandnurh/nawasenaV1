package com.example.nawasena_company.page

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.nawasena_company.scrapFun.BottomBar
import com.example.nawasena_company.scrapFun.TopBar
import com.example.nawasena_company.scrapFun.toHistory
import com.example.nawasena_company.scrapFun.toProfile
import com.example.nawasena_company.scrapFun.toRegistered


@Composable
fun Registered(navController: NavController){

    Scaffold (
        topBar = { TopBar(navController = navController, notRegister = false) },
        bottomBar = {
            BottomBar(
                navController = navController,
                buttonColor1 = Color.Transparent,
                buttonColor2 = MaterialTheme.colorScheme.onPrimaryContainer,
                buttonColor3 = Color.Transparent,
                mainChoice = toRegistered,
                historyChoice = toHistory,
                profileChoice = toProfile,
                navigate = true
            ) }
    ) { ip ->
        LazyColumn(contentPadding = ip){
            item {
                AppSearch(
                    navController = navController
                )
            }

        }

    }
}
