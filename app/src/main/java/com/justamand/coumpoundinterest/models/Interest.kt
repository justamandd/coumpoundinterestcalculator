package com.justamand.coumpoundinterest.models

data class Interest(
    var presentValue: Double?,
    var futureValue: Double?,
    val interestRate: Double,
    val months: UShort,
    val operation: Operation
)