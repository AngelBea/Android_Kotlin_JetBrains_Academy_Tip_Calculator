package org.hyperskill.calculator.tip

import java.math.BigDecimal
import java.math.RoundingMode

fun tipCalculation(price: BigDecimal, tipPercentage: BigDecimal) : String {
    return "Tip amount: ${(price * (tipPercentage / BigDecimal("100.00"))).setScale(2, RoundingMode.HALF_EVEN)}"
}