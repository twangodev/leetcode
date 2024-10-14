fun reverse(x: Int): Int {
    var n = x
    var result = 0
    while (n != 0) {
        if (result > Int.MAX_VALUE / 10 || result < Int.MIN_VALUE / 10) return 0
        result *= 10
        result += n % 10
        n /= 10
    }

    return result
}
