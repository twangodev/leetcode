fun twoSum(num: IntArray, targetInt: Int): IntArray {
    val set = HashSet<Int>()

    for (i in num.indices) {
        val complement = targetInt - num[i]
        if (set.contains(complement)) {
            return intArrayOf(num.indexOf(complement), i)
        }
        set.add(num[i])
    }

    return intArrayOf()
}
