package com.example.nawasena_company.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.scrapFun.BottomBar
import com.example.nawasena_company.scrapFun.TopBarCustom
import com.example.nawasena_company.scrapFun.toHistory
import com.example.nawasena_company.scrapFun.toProfile
import com.example.nawasena_company.scrapFun.toRegistered

@Composable
fun Profile(navController: NavController){
    Scaffold (
        topBar = { TopBarCustom(navController = navController, title = stringResource(R.string.profile), route = toRegistered) },
        bottomBar = { BottomBar(
            navController = navController,
            buttonColor1 = Color.Transparent,
            buttonColor2 = Color.Transparent,
            buttonColor3 = MaterialTheme.colorScheme.onPrimaryContainer,
            mainChoice = toRegistered,
            historyChoice = toHistory,
            profileChoice = toProfile,
            navigate = true
            )

        }

    ) {ip ->
        LazyColumn(contentPadding = ip){
            item {
                Spacer(modifier = Modifier.height(40.dp))
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    ProfileLogo()
                }
                Spacer(modifier = Modifier.height(20.dp))
                Divider(thickness = 4.dp)
                ProfileCard()

            }
        }
    }
}



@Composable
fun ProfileLogo(){
    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = null,
        modifier = Modifier.size(120.dp)
    )
}

@Composable
fun ProfileCard(){
    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        ProfileDetail(
            image = painterResource(R.drawable.nama),
            title = stringResource(R.string.profileTitle1),
            value = stringResource(R.string.profileValue1)
        )
    }
    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        ProfileDetail(
            image = painterResource(R.drawable.email),
            title = stringResource(R.string.profileTitle2),
            value = stringResource(R.string.profileValue2)
        )
    }
    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        ProfileDetail(
            image = painterResource(R.drawable.telpon),
            title = stringResource(R.string.profileTitle3),
            value = stringResource(R.string.profileValue3)
        )
    }

}

@Composable
fun ProfileDetail(image: Painter, title: String, value: String){

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
    ) {


        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.padding(end = 8.dp))

        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
            Text(
                text = value,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }



}