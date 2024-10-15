fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false

    var temp = x
    var reconstruct = 0
    while (temp > 0) {
        val digit = temp % 10
        temp /= 10

        reconstruct *= 10
        reconstruct += digit
    }

    return x == reconstruct
}
