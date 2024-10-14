import kotlin.math.max
import kotlin.math.min

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    if (nums1.size > nums2.size) return findMedianSortedArrays(nums2, nums1)

    val totalSize = nums1.size + nums2.size
    val desiredSize = (totalSize + 1) / 2

    var low = 0
    var high = nums1.size

    while (low <= high) {
        val highMidIndex1 = (low + high) / 2
        val highMidIndex2 = desiredSize - highMidIndex1
        val lowMidIndex1 = highMidIndex1 - 1
        val lowMidIndex2 = highMidIndex2 - 1

        var highPartition1 = Int.MAX_VALUE
        var highPartition2 = Int.MAX_VALUE

        var lowPartition1 = Int.MIN_VALUE
        var lowPartition2 = Int.MIN_VALUE

        if (highMidIndex1 < nums1.size) highPartition1 = nums1[highMidIndex1]
        if (highMidIndex2 < nums2.size) highPartition2 = nums2[highMidIndex2]

        if (lowMidIndex1 >= 0) lowPartition1 = nums1[lowMidIndex1]
        if (lowMidIndex2 >= 0) lowPartition2 = nums2[lowMidIndex2]

        if (highPartition1 >= lowPartition2 && highPartition2 >= lowPartition1) {

            val leftPartition = max(lowPartition1, lowPartition2).toDouble()
            if (totalSize % 2 == 1) {
                return leftPartition
            }

            val rightPartition = min(highPartition1, highPartition2).toDouble()
            return (leftPartition + rightPartition) / 2
        }

        if (lowPartition1 > highPartition2) {
            high = highMidIndex1 - 1
        } else {
            low = highMidIndex1 + 1
        }
    }

    return 0.0
}
