package ru.netology.task01

const val minute = 60
const val hour = 60 * 60
const val day = hour * 24

fun minutes(second: Int): String {
    val minutesCalculate: Int = (second / minute)
    return if (minutesCalculate % 10 == 1 && minutesCalculate != 11) "$minutesCalculate минуту"
    else if ((minutesCalculate % 10 == 2
                || minutesCalculate % 10 == 3
                || minutesCalculate % 10 == 4)
        && (minutesCalculate !in 12..14)
    ) "$minutesCalculate минуты"
    else "$minutesCalculate минут"
}

fun hours(second: Int): String {
    return when (val hoursCalculate: Int = (second / hour)) {
        in 2..4, in 22..23 -> "$hoursCalculate часа"
        in 5..20 -> "$hoursCalculate часов"
        else -> "$hoursCalculate час"
    }
}

fun agoToText(second: Int): String {
    val timeAgo: String = when (second) {
        in 0..minute -> "только что"
        in minute + 1..hour -> "${minutes(second)} назад"
        in hour + 1..day -> "${hours(second)} назад"
        in day + 1..day * 2 -> "вчера"
        in day * 2 + 1..day * 3 -> "позавчера"
        else -> "давно"
    }
    return "был(а) $timeAgo"
}

fun main() {
    println("Введите количество секунд: ")
    val secondAgo = readln().toInt()
    println("Пользователь ${agoToText(secondAgo)}")
}
