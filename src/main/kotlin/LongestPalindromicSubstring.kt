fun longestPalindrome(s: String): String {
    var largest = ""

    for (i in s.indices) {
        val same = expandFromCenter(s, i, i)
        val next = expandFromCenter(s, i, i + 1)

        if (same.length > largest.length) largest = same
        if (next.length > largest.length) largest = next
    }

    return largest
}

fun expandFromCenter(s: String, left: Int, right: Int): String {
    var leftPointer = left
    var rightPointer = right
    while (leftPointer >= 0 && rightPointer < s.length && s[leftPointer] == s[rightPointer]) {
        leftPointer--
        rightPointer++
    }
    return s.substring(leftPointer + 1, rightPointer)
}
