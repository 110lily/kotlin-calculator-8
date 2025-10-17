package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val input = Console.readLine()
    val result = addNumbers(input)
}

fun addNumbers(input: String?) {
    if (input.isNullOrBlank()) return
    val numbers = input.split(",", ":")
}