package com.example.mycityapp.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycityapp.data.Place
import com.example.mycityapp.data.PlaceRepository

private const val TAG = "ThirdScreen"

@Composable
fun ThirdScreen(descRes: String?,imageRes: String?,modifier: Modifier = Modifier){
    Scaffold(
        topBar = { TopBarMenu() }
    ) {
        Log.d(TAG, "third screen got a $descRes as descRes, and $imageRes as imageRes ")
        val desc = descRes?.toInt()
        val img = imageRes?.toInt()

        PlaceCard(desc!!, img!!)
    }


}

@Composable
fun PlaceCard(descRes:Int, imageRes: Int, modifier: Modifier = Modifier){
    Card(
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = stringResource(id = descRes),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()

            )
            Text(
                text = stringResource(id = descRes),
                modifier = Modifier
                    .weight(3f)
                    .padding(8.dp),
            )
        }
    }
}

@Composable
fun TopBarMenu(modifier: Modifier = Modifier){
    Text(text = "Cinema")
}