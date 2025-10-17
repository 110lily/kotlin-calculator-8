package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val input = Console.readLine()
    val result = addNumbers(input)
    println("결과: $result")
}

fun addNumbers(input: String?): Int {
    if (input.isNullOrBlank()) return 0
    val numbers = input.split(",", ":")
    var sum = 0

    for (number in numbers) {
        sum += number.toInt()
    }

    return sum
}