package ru.netology.task02

const val oneOffTransfer = 75_000.0
const val dayLimit = 150_000.0
const val monthLimit = 600_000.0

fun commissionCalculate(
    cardType: String = "VK Pay", pastTransfers: Double = 0.0, currentTransfer: Double
): Double {
    return when (cardType) {
        "Mastercard", "Maestro" -> {
            if ((pastTransfers + currentTransfer <= monthLimit) && (currentTransfer <= dayLimit)) {
                if (currentTransfer <= oneOffTransfer) 0.0
                else currentTransfer * .6 / 100 + 20
            } else -1.0
        }

        else -> 0.0 // VK Pay default
    }
}

fun main() {
    println(
        "Комиссия составит: ${
            String.format(
                "%.2f", commissionCalculate("Maestro", 499_999.0, 75_001.0)
            )
        } руб."
    )
}