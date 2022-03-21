package ru.netology

fun formatRange(value: Int): Int {
    return when {
        value == 1 || (value % 10 == 1 && value != 11) -> 1
        value % 10 in 2..4 && value !in 12..14 -> 2
        value % 10 in 5..20 -> 3
        else -> 4
    }
}

fun minuteFormat(second: Int): String {
    val minute: Int = second / 60
    return when (formatRange(minute)) {
        1 -> "минуту"
        2 -> "минуты"
        3 -> "минут"
        else -> "минут"
    }
}

fun hourFormat(second: Int): String {
    val hour: Int = second / 60 / 60
    return when (formatRange(hour)) {
        1 -> "час"
        2 -> "часа"
        3 -> "часов"
        else -> "часов"
    }
}

fun agoToText(second: Int): String {
    return when (second) {
        in 0..60 -> "был(а) только что"
        in 61..60 * 60 -> "был(а) в сети ${second / 60} ${minuteFormat(second)} назад"
        in (60 * 60 + 1)..(24 * 60 * 60) -> "был(а) в сети ${second / (60 * 60)} ${hourFormat(second)} назад"
        in (24 * 60 * 60 + 1)..(24 * 60 * 60 * 2) -> "был(а) в сети сегодня"
        in (24 * 60 * 60 * 2 + 1)..(24 * 60 * 60 * 3) -> "был(а) в сети вчера"
        in (24 * 60 * 60 * 3 + 1)..Int.MAX_VALUE -> "был(а) в сети давно"
        else -> "Давно"
    }
}

fun main() {
    println(agoToText(1))
    println(agoToText(61))
    println(agoToText(60 * 60 + 1))
    println(agoToText(60 * 60 * 24 + 1))
    println(agoToText(60 * 60 * 24 * 2 + 1))
    println(agoToText(60 * 60 * 24 * 3 + 1))
}