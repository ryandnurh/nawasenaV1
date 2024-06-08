package com.example.nawasena_company

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nawasena_company.page.History
import com.example.nawasena_company.page.LogIn
import com.example.nawasena_company.ui.theme.Nawasena_CompanyTheme
import com.example.nawasena_company.page.MainMenu
import com.example.nawasena_company.page.Profile
import com.example.nawasena_company.page.Registered
import com.example.nawasena_company.page.ResultMenu
import com.example.nawasena_company.page.SignUp
import com.example.nawasena_company.scrapFun.toLogin
import com.example.nawasena_company.scrapFun.toSignUp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nawasena_CompanyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation(){
    val nav = rememberNavController()
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }




    NavHost(
        navController = nav,
        startDestination = "MainMenu",
        builder = {
            composable("MainMenu"){
                MainMenu(
                    navController = nav,

                )
            }
            composable("LoginPage"){
                LogIn(
                    navController = nav,
                    input1 = email, input1Change = { email = it },
                    input2 = password, input2Change = { password = it },
                    holder1 = stringResource(R.string.emailHolder),
                    holder2 = stringResource(R.string.passHolder),
                    fieldTitle1 = stringResource(R.string.email),
                    fieldTitle2 = stringResource(R.string.password),
                    proceed1 = stringResource(R.string.login),
                    proceed2 = stringResource(R.string.signUp),
                    route = toSignUp
                )
            }
            composable("SignUp"){
                SignUp(
                    navController = nav,
                    input1 = phoneNumber, input1Change = { phoneNumber = it },
                    input2 = email, input2Change = { email = it },
                    holder1 = stringResource(R.string.phoneHolder),
                    holder2 = stringResource(R.string.emailHolder),
                    fieldTitle1 = stringResource(R.string.handpone),
                    fieldTitle2 = stringResource(R.string.email),
                    proceed1 = stringResource(R.string.signUp),
                    proceed2 = stringResource(R.string.login),
                    route = toLogin
                )
            }
            composable("ResultMenu"+"/{nominalInput}"+"/{personInput}"){navBackStack->
                val nominalInput = navBackStack.arguments?.getString("nominalInput")
                val personInput = navBackStack.arguments?.getString("personInput")
                ResultMenu(
                    nominalResult = nominalInput!!,
                    personResult = personInput!!,
                    navController = nav
                )
            }
            composable("Registered"){
                Registered(nav)

            }
            composable("Profile"){
                Profile(nav)
            }
            composable("History"){
                History(nav)
            }
        }
    )
}



