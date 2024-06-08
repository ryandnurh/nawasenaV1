package com.example.nawasena_company.page

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.scrapFun.LandingPageLayout
import com.example.nawasena_company.scrapFun.TopBarCustom
import com.example.nawasena_company.scrapFun.toLogin


@Composable
fun SignUp(
    navController: NavController,
    input1: String, input2: String,
    holder1: String, holder2: String,
    fieldTitle1: String, fieldTitle2: String,
    proceed1: String, proceed2: String,

    input1Change: (String) -> Unit, input2Change: (String) -> Unit,
    route: String
){
    Scaffold (
        topBar = {
            TopBarCustom(
                navController = navController,
                title = stringResource(R.string.signUp),
                route = toLogin
            )
        }
    ) {ip ->
        LazyColumn(contentPadding =ip ){
            item {
                LandingPageLayout(
                    navController = navController,
                    input1 = input1,
                    input2 = input2,
                    holder1 = holder1,
                    holder2 = holder2,
                    fieldTitle1 = fieldTitle1,
                    fieldTitle2 = fieldTitle2,
                    proceed1 = proceed1,
                    proceed2 = proceed2,
                    input1Change = input1Change,
                    input2Change = input2Change,
                    route = route
                )
            }
        }
    }
}

