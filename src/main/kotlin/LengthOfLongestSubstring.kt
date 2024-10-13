import kotlin.math.max

fun lengthOfLongestSubstring(s: String): Int {
    var length = 0
    var left = 0
    val map = mutableMapOf<Char, Int>()

    for (right in s.indices) {
        val charRight = s[right]
        if (map.containsKey(charRight)) {
            val i = map[charRight]!! + 1
            if (i > left) left = i
        }
        map[charRight] = right
        length = max(right + 1 - left, length)
    }

    return length
}
