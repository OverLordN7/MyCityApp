package com.example.mycityapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @StringRes val categoryName: Int,
    @DrawableRes val categoryImg: Int,
    val categoryType: CategoryType,
)
