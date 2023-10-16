package ru.netology.task02

const val discountLimit = 75_000.0
const val dayLimit = 150_000.0
const val monthLimit = 600_000.0

fun commissionCalculate(
    cardType: String = "VK Pay", pastTransfers: Double = 0.0, currentTransfer: Double
): Double {
    return when (cardType) {
        "Mastercard", "Maestro" -> {
            if ((pastTransfers + currentTransfer <= monthLimit) && (currentTransfer <= dayLimit)) {
                if (pastTransfers <= discountLimit) 0.0
                else currentTransfer * 0.006 + 20
            } else -1.0
        }

        "Visa", "Мир" -> {
            val tax = currentTransfer * 0.0075
            if (currentTransfer >= 35.0) {
                if (tax < 35.0) 35.0 else tax
            } else -1.0
        }

        else -> 0.0 // VK Pay default
    }
}

fun main() {
    val cards = arrayOf("Mastercard", "Visa", "VK Pay")
    for (item in cards) println(
        "Комиссия для $item составит: ${
            String.format(
                "%.2f", commissionCalculate(item, 499_999.0, 75_001.0)
            )
        } руб."
    )
}