fun parseDigit(c: Char): Int? {
    return when(c) {
        '0' -> 0
        '1' -> 1
        '2' -> 2
        '3' -> 3
        '4' -> 4
        '5' -> 5
        '6' -> 6
        '7' -> 7
        '8' -> 8
        '9' -> 9
        else -> null
    }
}

fun myAtoi(s: String): Int {
    var result: Int? = null
    var multiplier: Int? = null

    for (c in s) {
        if (result == null && multiplier == null) {
            if (c == ' ') continue
            if (c == '+') {
                multiplier = 1
                continue
            }
            if (c == '-') {
                multiplier = -1
                continue
            }
        }

        val d = parseDigit(c) ?: break
        multiplier = multiplier ?: 1
        result = result ?: 0

        if (result * multiplier > (Int.MAX_VALUE - d) / 10) return Int.MAX_VALUE
        if (result * multiplier < (Int.MIN_VALUE + d) / 10) return Int.MIN_VALUE

        result *= 10
        result += d
    }

    return (result ?: 0) * (multiplier ?: 1)
}
