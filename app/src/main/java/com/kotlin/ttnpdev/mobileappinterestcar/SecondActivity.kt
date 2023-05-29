package com.kotlin.ttnpdev.mobileappinterestcar

import android.os.Bundle
import com.kotlin.ttnpdev.mobileappinterestcar.controller.ActivityCalculateInterestCar

class SecondActivity : ActivityCalculateInterestCar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interest_car)

        activityCalculateInterestCar()

    }

}