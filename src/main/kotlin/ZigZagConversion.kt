fun convert(s: String, numRows: Int): String {
    if (numRows == 1) return s

    val arrays = Array(numRows) { CharArray(s.length) }

    var column = 0
    var row = -1
    var reversing = false

    for (c in s) {
        if (row >= numRows) {
            reversing = true
            row--
        }
        if (row <= 0) {
            reversing = false
            row++
        }
        if (!reversing) {
            arrays[row++][column] = c
        } else {
            arrays[--row][++column] = c
        }
    }

    val sb = StringBuilder()
    for (ca in arrays) {
        for (c in ca) {
            if (c == '\u0000') continue
            sb.append(c)
        }
    }

    return sb.toString()
}
