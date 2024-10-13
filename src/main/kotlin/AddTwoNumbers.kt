import data.structures.ListNode

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var node1 = l1
    var node2 = l2

    val head = ListNode(0)
    var tail = head
    var carry = 0

    while (node1 != null || node2 != null || carry != 0) {
        val d1 = node1?.`val` ?: 0
        val d2 = node2?.`val` ?: 0

        val sum = d1 + d2 + carry
        val sumDigit = sum % 10
        carry = sum / 10

        val node = ListNode(sumDigit)
        tail.next = node
        tail = node

        node1 = node1?.next
        node2 = node2?.next
    }

    return head.next
}
