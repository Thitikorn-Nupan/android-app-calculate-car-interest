package com.kotlin.ttnpdev.mobileappinterestcar.controller

import android.content.Intent
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kotlin.ttnpdev.mobileappinterestcar.MainActivity
import com.kotlin.ttnpdev.mobileappinterestcar.R
import com.kotlin.ttnpdev.mobileappinterestcar.entity.User
import com.kotlin.ttnpdev.mobileappinterestcar.service.CalculateAutoPrice

open class ActivityCalculateInterestCar : AppCompatActivity() , View.OnClickListener {

    private lateinit var user : User
    private lateinit var getIntentIntro : Intent
    private lateinit var intentToIntro : Intent
    private lateinit var buttonInput : AppCompatButton
    private lateinit var floatingHome : FloatingActionButton
    private lateinit var editTotalPrice: EditText
    private lateinit var editDownPayment: EditText
    private lateinit var editInterestPerYear: EditText
    private lateinit var editInstallment: EditText


     private fun getUser() {
        val imageIconUser: ImageView = findViewById(R.id.imageIconUser)
        val textName: TextView = findViewById(R.id.textName)
        /* get intent from first activity */
        getIntentIntro = intent
        /*
            receive the value by getStringExtra() method and key must be same
            getStringExtra() method is for getting the data(key) that is sent
            by the above method. According to the data type of value,
            there are other methods like getIntExtra(), getFloatExtra()
        * */
        user = User(getIntentIntro.getStringExtra("nameUser").toString())
        imageIconUser.setImageResource(user.getImage()) // set image to tag ImageView
        textName.text = "You're ${user.getName().trim()} , I'm glad to help you."
    }

    private fun startWidget() {
        editTotalPrice = findViewById(R.id.editTotalPrice)
        editInstallment = findViewById(R.id.editInstallment)
        editDownPayment = findViewById(R.id.editDownPayment)
        editInterestPerYear = findViewById(R.id.editInterestPerYear)
        buttonInput = findViewById(R.id.buttonInput)
        floatingHome = findViewById(R.id.floatingHome)
    }

    private fun getCalculateInterest() {


            val autoPrice = editTotalPrice.text.toString() // ราคารถ
            val downPayment = editDownPayment.text.toString() // เงินดาวน์
            val interestPerYear = editInterestPerYear.text.toString() // ดอกเบี้ยต่อปี
            val loadTerm = editInstallment.text.toString() // จำนวนปี (ผ่อน)
            /* we convert to string before to float because we need to check them input should not be empty */
            validateInput(autoPrice, downPayment, interestPerYear, loadTerm)

    }

    private fun validateInput(autoPrice:String,downPayment:String,interestPerYear:String,loadTerm:String) {
        if ((autoPrice.trim().isNotEmpty()) && (downPayment.trim().isNotEmpty()) && (interestPerYear.trim().isNotEmpty()) && (loadTerm.trim().isNotEmpty())) {
            // println ("auto price $autoPrice , down payment $downPayment , interest per years $interestPerYear , load term $loadTerm")
            setWidgetResult(autoPrice.toFloat(),downPayment.toFloat(),interestPerYear.toFloat(),loadTerm.toInt())
        }
    }
    private fun setWidgetResult (autoPrice:Float,downPayment:Float,interestPerYear:Float,loadTerm:Int) {

        /* text view for result */
        val resultTextTotalLoan = findViewById<TextView>(R.id.resultTextTotalLoan)
        val resultTextInterest = findViewById<TextView>(R.id.resultTextInterest)
        val resultTextTotalInterestCost = findViewById<TextView>(R.id.resultTextTotalInterest)
        val resultTextTotalCost = findViewById<TextView>(R.id.resultTextTotalCost)
        val resultTextInstallmentPerMonth = findViewById<TextView>(R.id.resultTextInstallmentPerMonth)
        /* text view for result */

        if ((autoPrice > 0) && (downPayment > 0) && (interestPerYear > 0) && (loadTerm > 0)) {

            resultTextTotalLoan.text = CalculateAutoPrice.totalLoanAmount(autoPrice, downPayment)
            resultTextInterest.text = CalculateAutoPrice.interestPerYear(interestPerYear)
            resultTextTotalInterestCost.text = CalculateAutoPrice.interestXLoanTerm(autoPrice,downPayment,loadTerm,interestPerYear)
            resultTextTotalCost.text = CalculateAutoPrice.totalCost(autoPrice,downPayment,loadTerm,interestPerYear)
            resultTextInstallmentPerMonth.text = CalculateAutoPrice.installmentPerMonth(autoPrice, downPayment, loadTerm, interestPerYear)

        }

    }
    private fun getIntro() {
        intentToIntro = Intent(this@ActivityCalculateInterestCar , MainActivity::class.java)
        startActivity(intentToIntro)
    }

    internal fun activityCalculateInterestCar() {
        getUser()
        startWidget()
        buttonInput.setOnClickListener(this@ActivityCalculateInterestCar)
        floatingHome.setOnClickListener(this@ActivityCalculateInterestCar)
    }

    override fun onClick(v: View?) {
        when(v?.id) {

            buttonInput.id -> {

                getCalculateInterest()

            }

            floatingHome.id -> {

                getIntro()

            }
        }
    }

}