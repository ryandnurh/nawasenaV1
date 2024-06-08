package com.example.nawasena_company.page

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.scrapFun.BottomBar
import com.example.nawasena_company.scrapFun.TopBar
import com.example.nawasena_company.scrapFun.toMain

@Composable
fun MainMenu(navController: NavController){
    Scaffold (
        topBar = { TopBar(navController = navController, notRegister = true) },
        bottomBar = {
            BottomBar(
                navController = navController,
                buttonColor1 = Color.Transparent,
                buttonColor2 = MaterialTheme.colorScheme.onPrimaryContainer,
                buttonColor3 = Color.Transparent,
                mainChoice = toMain,
                historyChoice = toMain,
                profileChoice = toMain,
                navigate = false
                )
        }
    ) { ip ->
        LazyColumn(contentPadding = ip){
            item {
                Spacer(modifier = Modifier.height(40.dp))
                
                AppSearch(
                    navController = navController
                )
            }

        }

    }
}

@Composable
fun AppSearch(navController: NavController){
    var nominalInput by remember { mutableStateOf("") }
    var personInput by remember { mutableStateOf("") }



    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        )
    ){

        Card (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(150.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onTertiary
            )
        ) {
            Box (
                contentAlignment = Alignment.TopStart,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp)
            ){
                SearchField(
                    label = R.string.nominal,
                    fieldTitle = R.string.fieldTitle1,
                    value = nominalInput,
                    onValueChanged = { nominalInput = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    )
                )
            }

        }

        Card (

            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(150.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onTertiary
            )

        ) {
            Box (
                contentAlignment = Alignment.TopStart,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp)
            ) {
                SearchField(
                    label = R.string.personal,
                    fieldTitle = R.string.fieldTitle2,
                    value = personInput,
                    onValueChanged = { personInput = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    )
                )
            }


        }

        Spacer(modifier = Modifier.height(40.dp))

        Box (
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.fillMaxWidth()
        ){
            Button(
                onClick = {
                    navController.navigate("ResultMenu/$nominalInput/$personInput"
                    )
                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onTertiary),
                modifier = Modifier
                    .width(200.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = stringResource(R.string.search),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun SearchField(
    @StringRes label: Int,
    @StringRes fieldTitle: Int,
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
) {
    val textWipe = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF989898))
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(fieldTitle),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer

        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            placeholder = { Text(stringResource(label), style = textWipe) },
            keyboardOptions = keyboardOptions,
            modifier = modifier
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 11.dp)),


            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White
            ),
        )
    }

}