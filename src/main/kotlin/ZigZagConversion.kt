fun convert(s: String, numRows: Int): String {
    val arrays = Array(numRows) { CharArray(s.length) }

    var column = 0
    var row = 0
    var carry = 0

    for (c in s) {
        if (row >= numRows) {
            row = 0
            column++
        }

        arrays[row][column] = c
        row++
    }

}
