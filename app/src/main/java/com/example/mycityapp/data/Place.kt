package com.example.mycityapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Place(
    @StringRes val placeName: Int,
    @StringRes val placeDesc: Int,
    @DrawableRes val placeImg: Int,
    val categoryType: CategoryType,
    )
