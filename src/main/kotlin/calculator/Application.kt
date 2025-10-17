package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val input = Console.readLine()
    validateInput(input)
    val result = addNumbers(input)
    println("결과 : $result")
}

fun validateInput(input: String?) {
    if (input.isNullOrBlank()) return
    if (input.startsWith("//")) {
        val splitIndex = input.indexOf("\\n")
        if (splitIndex < 3) throw IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.")
        val customDelimiter = input.substring(2, splitIndex)
        if (customDelimiter.isEmpty()) throw IllegalArgumentException("구분자가 지정되지 않았습니다.")
    } else {
        if (!input.contains(",") && !input.contains(":")) {
            throw IllegalArgumentException("구분자가 포함되어야 합니다.")
        }
    }

    val allowedPattern = Regex("""^([0-9,:\-\s]|//.*\\n[0-9,:\-;]*)+$""")
    if (!allowedPattern.matches(input)) {
        throw IllegalArgumentException("잘못된 문자 또는 형식이 포함되어 있습니다.")
    }
}

fun addNumbers(input: String?): Int {
    if (input.isNullOrBlank()) return 0

    var numbers = input
    var delimiter = "[,:]"

    if (input.startsWith("//")) {
        val splitIndex = input.indexOf("\\n")
        val customDelimiter = input.substring(2, splitIndex)
        delimiter = Regex.escape(customDelimiter)
        numbers = input.substring(splitIndex + 2)
    }

    val numberList = numbers
        .split(delimiter.toRegex())
        .map { it.toInt() }

    if (numberList.any { it < 0 }) {
        throw IllegalArgumentException("음수는 허용되지 않습니다.")
    }

    return numberList.sum()
}