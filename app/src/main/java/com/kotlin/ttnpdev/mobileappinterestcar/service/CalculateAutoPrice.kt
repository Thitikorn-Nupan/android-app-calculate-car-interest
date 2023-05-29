package com.kotlin.ttnpdev.mobileappinterestcar.service

object CalculateAutoPrice {

    internal fun totalLoanAmount(autoPrice:Float,downPayment:Float) : String = "Total Loan amount $autoPrice - $downPayment = ${String.format("%.1f",autoPrice-downPayment)} ฿"
    internal fun interestPerYear(interest:Float) : String = "Interest (Per Year) $interest %"
    internal fun interestXLoanTerm(autoPrice:Float,downPayment:Float,loanTerm:Int,interestPerYear:Float) : String {
        val interestCost = (autoPrice-downPayment) * (interestPerYear/100)
        val resultCostPerYear = interestCost * loanTerm
        return "Interest x Loan Term $interestCost x $loanTerm = $resultCostPerYear ฿"
    }
    internal fun totalCost(autoPrice:Float,downPayment:Float,loadTerm:Int,interestPerYear:Float) : String {
        val totalCost = (autoPrice-downPayment) + (((autoPrice-downPayment)*(interestPerYear/100)) * loadTerm)
        return "Total Cost = $totalCost ฿"
    }
    internal fun installmentPerMonth(autoPrice:Float,downPayment:Float,loadTerm:Int,interestPerYear:Float) : String {
        val installment = ((autoPrice-downPayment) + ( ((autoPrice-downPayment)*(interestPerYear/100)) * loadTerm) )
        println(installment)
        val vat = (installment * 0.07).toFloat()
        println(vat)
        val installmentPerMonth = ((installment + vat) / (loadTerm*12))
        return "Installment (Per month) $installmentPerMonth ฿"
    }
}