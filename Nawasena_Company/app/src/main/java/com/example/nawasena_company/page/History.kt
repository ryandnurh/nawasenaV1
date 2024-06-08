package com.example.nawasena_company.page

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.scrapFun.BottomBar
import com.example.nawasena_company.scrapFun.TopBarCustom
import com.example.nawasena_company.scrapFun.toHistory
import com.example.nawasena_company.scrapFun.toProfile
import com.example.nawasena_company.scrapFun.toRegistered

@Composable
fun History(navController: NavController){
    Scaffold (
        topBar = {
            TopBarCustom(
                navController = navController,
                title = stringResource(R.string.history),
                route = toRegistered
            )
        },
        bottomBar = {
            BottomBar(navController = navController,
                buttonColor1 = MaterialTheme.colorScheme.onPrimaryContainer,
                buttonColor2 = Color.Transparent,
                buttonColor3 = Color.Transparent,
                mainChoice = toRegistered,
                historyChoice = toHistory,
                profileChoice = toProfile,
                navigate = true
            )
        }
    ) {ip ->
        LazyColumn(contentPadding = ip){

        }
    }
}
