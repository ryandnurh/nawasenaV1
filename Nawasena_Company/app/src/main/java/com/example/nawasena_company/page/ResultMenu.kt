package com.example.nawasena_company.page

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.data.TourPackage
import com.example.nawasena_company.data.tours
import com.example.nawasena_company.scrapFun.BottomBar
import com.example.nawasena_company.scrapFun.TopBarCustom2
import com.example.nawasena_company.scrapFun.toMain
import com.example.nawasena_company.scrapFun.toRegistered

@Composable
fun ResultMenu(
    navController: NavController,
    nominalResult: String,
    personResult: String
){
    val nominal = nominalResult.toInt()
    val person = personResult.toInt()
    var searchAgain by remember { mutableStateOf(false) }



    Scaffold (
        topBar = {
            TopBarCustom2(
                navController = navController,
                route = toMain,
                onButtonClick = {searchAgain = !searchAgain}
            )
        },
        bottomBar = {
            BottomBar(
                navController = navController,
                buttonColor1 = Color.Transparent,
                buttonColor2 = MaterialTheme.colorScheme.onPrimaryContainer,
                buttonColor3 = Color.Transparent,
                mainChoice = toRegistered,
                historyChoice = toMain,
                profileChoice = toMain,
                navigate = false
            )
        }
    ) { ip ->
        LazyColumn(contentPadding = ip){
            if (searchAgain){
                item {
                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = stringResource(R.string.command),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )

                   AppSearch(navController = navController)
                }
            }else{
                item {
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = stringResource(R.string.recommend),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
                when{
                    nominal < 600000 && person < 4 ->
                        items(tours) {
                            TourLayout(tourPackage = it)
                        }
                }

            }

        }
    }

}




@Composable
fun TourLayout(
    tourPackage: TourPackage,
){
    Card (
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.onTertiary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row {
            TourImage(image = tourPackage.tourImage)

            TourDetails(
                name = tourPackage.tourName,
                star = tourPackage.tourStar,
                rating = tourPackage.tourRating,
                amount = tourPackage.tourAmount,
                price = tourPackage.tourPrice
            )
        }
    }
}

@Composable
fun TourImage(
    @DrawableRes image: Int
){
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = Modifier
            .size(170.dp)
            .padding(8.dp)

    )
}



@Composable
fun TourDetails(
    @StringRes name: Int,
    @DrawableRes star: Int,
    @StringRes rating: Int,
    @StringRes amount: Int,
    price: Int
){
    Column(
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text(
            text = stringResource(name),
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(painter = painterResource(star),
                contentDescription = null,
                modifier = Modifier.offset(y = 3.dp)
            )
            Spacer(modifier = Modifier.padding(end = 5.dp))
            Text(
                text = stringResource(rating),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.padding(end = 5.dp))
            Text(
                text = stringResource(amount),
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(R.string.rupiah, price),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }

}


