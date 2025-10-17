package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val input = Console.readLine()
    val result = addNumbers(input)
    println("결과: $result")
}

fun addNumbers(input: String?): Int {
    if (input.isNullOrBlank()) return 0
    var numbers = input
    var delimiter = "[,:]"

    if (input.startsWith("//")) {
        val splitIndex = input.indexOf("\\n")
        if (splitIndex != -1) {
            delimiter = Regex.escape(input.substring(2, 3))
            numbers = input.substring(splitIndex + 2)
        }
    }

    return numbers
        .split(delimiter.toRegex()).sumOf { it.toInt() }
}