package com.example.nawasena_company.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.scrapFun.LandingPageLayout
import com.example.nawasena_company.scrapFun.TopBarCustom
import com.example.nawasena_company.scrapFun.toMain



@Composable
fun LogIn(
    navController:NavController,
    input1: String, input1Change: (String) -> Unit,
    input2: String, input2Change: (String) -> Unit,
    holder1: String, holder2: String,
    fieldTitle1: String, fieldTitle2: String,
    proceed1: String, proceed2: String,
    route: String
) {
    Scaffold(
        topBar = {
            TopBarCustom(
                navController = navController,
                title = stringResource(R.string.login),
                route = toMain
            )
        }
    ) {
        LazyColumn(
            contentPadding = it,
        ) {
            item {
                LandingPageLayout(
                    navController = navController,
                    input1 = input1,
                    input1Change = input1Change,
                    input2 = input2,
                    input2Change = input2Change,
                    holder1 = holder1,
                    holder2 = holder2,
                    fieldTitle1 = fieldTitle1,
                    fieldTitle2 = fieldTitle2,
                    proceed1 = proceed1,
                    proceed2 = proceed2,
                    route = route
                )
            }
        }
    }
}



@Composable
fun ExploreLogo(){
    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = null,
        modifier = Modifier.size(200.dp)
    )
}

@Composable
fun LoginField(
    input: String,
    inputChange: (String) -> Unit,
    holder: String,
    fieldTitle: String
){
    val textWipe = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF989898))
    Column {
        Text(
            text = fieldTitle,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.offset(x = 8.dp),

        )
        OutlinedTextField(
            value = input,
            onValueChange = inputChange,
            placeholder = { Text( text = holder, style = textWipe ) },
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color(0xFFEEF0E5),
                focusedIndicatorColor = Color(0xFF789461),
                focusedContainerColor = Color(0xFFEEF0E5)
            )

        )
    }

}

//visualTransformation = PasswordVisualTransformation('*'),
//singleLine = true,
//keyboardOptions = KeyboardOptions(
//keyboardType = KeyboardType.Password,
//imeAction = ImeAction.Done
//)