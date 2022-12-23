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
import com.example.mycityapp.data.Category
import com.example.mycityapp.data.CategoryType
import com.example.mycityapp.data.PlaceRepository
import com.example.mycityapp.data.Screen

private const val TAG = "CategoryList"

@Composable
fun FirstScreen(navController: NavController,modifier: Modifier = Modifier){
    Scaffold() {
        val categories = PlaceRepository.categories


        LazyColumn(){
            items(categories){
                CategoryCardType(category = it, navController = navController)
            }
        }
    }
}

@Composable
fun CategoryCardType(category: Category,navController: NavController,modifier: Modifier = Modifier){
    Card(
        elevation = 4.dp,
        modifier = modifier
            .padding(16.dp)
            .clickable {
                when(category.categoryType){
                    CategoryType.Cinema ->{
                        navController.navigate(Screen.SecondScreen.withArgs("Cinema"))
                    }
                    CategoryType.Park ->{
                        navController.navigate(Screen.SecondScreen.withArgs("Park"))
                    }
                    CategoryType.Mall ->{
                        navController.navigate(Screen.SecondScreen.withArgs("Mall"))
                    }
                    CategoryType.Museum ->{
                        navController.navigate(Screen.SecondScreen.withArgs("Museum"))
                    }
                }
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = category.categoryImg),
                contentDescription = stringResource(id = category.categoryName),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(1f)
                    .size(100.dp, 150.dp),

                )
            Spacer(modifier = Modifier.width(24.dp))
            Text(text = stringResource(id = category.categoryName),
                modifier = Modifier.weight(1f)
            )
        }
    }
}