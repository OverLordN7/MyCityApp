package com.example.mycityapp.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycityapp.data.CategoryType
import com.example.mycityapp.data.Place
import com.example.mycityapp.data.PlaceRepository
import com.example.mycityapp.data.Screen

private const val TAG = "SecondScreen"

@Composable
fun SecondScreen(
    categoryTypeString:String?,
    navController: NavController,
    modifier: Modifier = Modifier
){
    Scaffold() {
        Log.d(TAG, "$categoryTypeString in second screen")
        val categoryType: CategoryType = when(categoryTypeString){
            "Cinema"->CategoryType.Cinema
            "Park"-> CategoryType.Park
            "Mall"->CategoryType.Mall
            "Museum"->CategoryType.Museum
            else ->CategoryType.Cinema
        }

        LazyColumn(){
            val temp  = PlaceRepository.places.let { it ->
                it.filter { item ->
                    item.categoryType == categoryType
                }
            }
            items(temp){
                CategoryCard(place = it, navController = navController)
            }
        }


    }
}

@Composable
fun CategoryCard(place: Place,navController: NavController, modifier: Modifier = Modifier){
    Card(
        elevation = 4.dp,
        modifier = modifier
            .padding(16.dp)
            .clickable {
                navController.navigate(Screen.ThirdScreen.withArgs("${place.placeDesc}/${place.placeImg}"))
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = place.placeImg),
                contentDescription = stringResource(id = place.placeName),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(1f)
                    .size(100.dp, 150.dp),

                )
            Spacer(modifier = Modifier.width(24.dp))
            Text(text = stringResource(id = place.placeName),
                modifier = Modifier.weight(1f)
            )
        }
    }
}