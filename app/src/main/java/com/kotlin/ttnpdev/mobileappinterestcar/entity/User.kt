package com.kotlin.ttnpdev.mobileappinterestcar.entity

import com.kotlin.ttnpdev.mobileappinterestcar.R
import kotlin.random.Random

class User (private var name:String) {

    private var image:Int = 0

    init {
        setImage()
    }

    private fun setImage() {
        val random = Random.nextInt(3)
        image = when (random) {
            1 -> {
                R.drawable.user1
            }
            2 -> {
                R.drawable.user2
            }
            else -> {
                R.drawable.user3
            }
        }
    }

    internal fun getImage ()  : Int {
        return image

    }
    internal fun setName(name:String) {
        this.name = name

    }

    internal fun getName ()  : String {
        return name
    }

    override fun toString(): String {
        return "User(name='$name', image=$image)"
    }


}