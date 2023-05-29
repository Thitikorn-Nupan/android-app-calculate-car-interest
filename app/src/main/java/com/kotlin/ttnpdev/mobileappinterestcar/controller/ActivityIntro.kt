package com.kotlin.ttnpdev.mobileappinterestcar.controller
import android.content.Intent
import android.content.res.ColorStateList
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.kotlin.ttnpdev.mobileappinterestcar.R
import com.kotlin.ttnpdev.mobileappinterestcar.SecondActivity


open class ActivityIntro : AppCompatActivity() , View.OnClickListener {

    private lateinit var buttonLogin : AppCompatButton
    private lateinit var inputLayoutName : TextInputLayout
    private lateinit var inputEditName : TextInputEditText
    private lateinit var intentIntro: Intent

    init {

        println("ActivityIntro is working")

    }
    private fun startWidget() {
        buttonLogin = findViewById(R.id.buttonLogin)
        inputLayoutName = findViewById(R.id.inputLayoutName)
        inputEditName = findViewById(R.id.inputEditName)
    }
    internal fun activityIntro() {
        startWidget()
        buttonLogin.setOnClickListener(this@ActivityIntro)
    }

    private fun validateName(name:String) : Boolean {
        // (have a lots way to set color) this is the easiest way to fix
        // try to understand , how colorStateList work
        // set color on input layout
        val colorInt : Int
        val csl : ColorStateList
        if (name.trim().isNotEmpty()) {
            colorInt = getColor(R.color.ok_input)
            csl = ColorStateList.valueOf(colorInt)
            inputLayoutName.hintTextColor = csl
            inputLayoutName.hint = getString(R.string.after_put_on_good)
            return true
        }
        else {
            colorInt = getColor(R.color.bad_input)
            csl = ColorStateList.valueOf(colorInt)
            inputLayoutName.hintTextColor = csl
            inputLayoutName.hint = getString(R.string.after_put_on_bad)
            return false
        }
    }

    private fun condition(trueOrFalse:Boolean) {
        if (trueOrFalse) {
            intentIntro = Intent(this@ActivityIntro,SecondActivity::class.java)
            intentIntro.putExtra("nameUser",inputEditName.text.toString())
            startActivity(intentIntro)
        }
    }


    override fun onClick(v: View?) {
        /* remember : val/var <> = validateName( inputEditName.text.toString()) the method it'll also work ! */
        condition(validateName( inputEditName.text.toString()) )
    }
}