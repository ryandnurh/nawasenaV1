package com.example.nawasena_company.scrapFun

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.page.ExploreLogo
import com.example.nawasena_company.page.LoginField

@Composable
fun LandingPageLayout(
    navController: NavController,
    input1: String, input2: String,
    holder1: String, holder2: String,
    fieldTitle1: String, fieldTitle2: String,
    proceed1: String, proceed2: String,

    input1Change: (String) -> Unit, input2Change: (String) -> Unit,
    route: String
){


    Column {

        Spacer(modifier = Modifier.height(30.dp))

        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ){
            ExploreLogo()
        }

        Spacer(modifier = Modifier.height(30.dp))

        Box  (
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ){
            Column {
                LoginField(
                    input = input1,
                    inputChange = input1Change,
                    holder = holder1,
                    fieldTitle = fieldTitle1
                )

                Spacer(modifier = Modifier.height(30.dp))

                LoginField(
                    input = input2,
                    inputChange = input2Change,
                    holder = holder2,
                    fieldTitle = fieldTitle2
                )
            }

        }
        Spacer(modifier = Modifier.height(60.dp))

        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Button(
                onClick = {
                    navController.navigate(toRegistered)


                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onTertiary),
                modifier = Modifier
                    .width(150.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(
                    text = proceed1,
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.or),
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSecondary
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = proceed2,
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.clickable { navController.navigate(route) }
                )
            }
        }

    }

}