package com.example.nawasena_company.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.nawasena_company.R

data class TourPackage(
    @DrawableRes val tourImage: Int,
    @StringRes val tourName: Int,
    @DrawableRes val tourStar: Int,
    @StringRes val tourRating: Int,
    @StringRes val tourAmount: Int,
    val tourPrice: Int,
)


val tours = listOf(
    TourPackage(
        R.drawable.tour1, R.string.Tours1, R.drawable.five_star, R.string.rating1,R.string.ratingAmount1,850000
    ),
    TourPackage(
        R.drawable.tour2, R.string.Tours2, R.drawable.five_star, R.string.rating2,R.string.ratingAmount2,900000
    ),
    TourPackage(
        R.drawable.tour3, R.string.Tours3, R.drawable.four_star, R.string.rating3,R.string.ratingAmount3,600000
    ),
    TourPackage(
        R.drawable.tour4, R.string.Tours4, R.drawable.four_star, R.string.rating4,R.string.ratingAmount4,799000
    ),
    TourPackage(
        R.drawable.tour5, R.string.Tours5, R.drawable.three_star, R.string.rating5,R.string.ratingAmount5,950000
    )

)