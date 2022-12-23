package com.example.mycityapp.data

import com.example.mycityapp.R

object PlaceRepository {
    val places = listOf(
        Place(R.string.cinema_name_1,R.string.cinema_desc_1,R.drawable.cinema_img_1,CategoryType.Cinema),
        Place(R.string.cinema_name_2,R.string.cinema_desc_2,R.drawable.cinema_img_2,CategoryType.Cinema),
        Place(R.string.cinema_name_3,R.string.cinema_desc_3,R.drawable.cinema_img_3,CategoryType.Cinema),
        Place(R.string.cinema_name_4,R.string.cinema_desc_4,R.drawable.cinema_img_4,CategoryType.Cinema),
        Place(R.string.park_name_1,R.string.park_desc_1,R.drawable.park_img_1,CategoryType.Park),
        Place(R.string.park_name_2,R.string.park_desc_2,R.drawable.park_img_2,CategoryType.Park),
        Place(R.string.park_name_3,R.string.park_desc_3,R.drawable.park_img_3,CategoryType.Park),
        Place(R.string.park_name_4,R.string.park_desc_4,R.drawable.park_img_4,CategoryType.Park),
        Place(R.string.mall_name_1,R.string.mall_desc_1,R.drawable.mall_img_1,CategoryType.Mall),
        Place(R.string.mall_name_2,R.string.mall_desc_2,R.drawable.mall_img_2,CategoryType.Mall),
        Place(R.string.mall_name_3,R.string.mall_desc_3,R.drawable.mall_img_3,CategoryType.Mall),
        Place(R.string.mall_name_4,R.string.mall_desc_4,R.drawable.mall_img_4,CategoryType.Mall),
        Place(R.string.museum_name_1,R.string.museum_desc_1,R.drawable.museum_img_1,CategoryType.Museum),
        Place(R.string.museum_name_2,R.string.museum_desc_2,R.drawable.museum_img_2,CategoryType.Museum),
        Place(R.string.museum_name_3,R.string.museum_desc_3,R.drawable.museum_img_3,CategoryType.Museum),
        Place(R.string.museum_name_4,R.string.museum_desc_4,R.drawable.museum_img_4,CategoryType.Museum),
    )

    val categories = listOf(
        Category(R.string.category_type_1,R.drawable.category_type_img_1,CategoryType.Cinema),
        Category(R.string.category_type_2,R.drawable.category_type_img_2,CategoryType.Park),
        Category(R.string.category_type_3,R.drawable.category_type_img_3,CategoryType.Mall),
        Category(R.string.category_type_4,R.drawable.category_type_img_4,CategoryType.Museum),
    )
}