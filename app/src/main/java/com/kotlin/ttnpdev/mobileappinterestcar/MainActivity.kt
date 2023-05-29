package com.kotlin.ttnpdev.mobileappinterestcar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.ttnpdev.mobileappinterestcar.controller.ActivityIntro

class MainActivity : ActivityIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        activityIntro()

    }
}