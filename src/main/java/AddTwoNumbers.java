import datastructure.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode prev = node;
        int sum;
        boolean flag = false;
        while (l1 != null && l2 != null) {
            if (flag) {
                sum = l1.val + l2.val + 1;
                flag = false;
            } else {
                sum = l1.val + l2.val;
            }
            if (sum > 9) {
                flag = true;
                node.next = new ListNode(sum - 10);
            } else {
                node.next = new ListNode(sum);
            }
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        while (l1 != null) {
            if (flag) {
                sum = l1.val + 1;
            } else {
                sum = l1.val;
            }
            if (sum > 9) {
                flag = true;
                node.next = new ListNode(sum - 10);
            } else {
                node.next = new ListNode(sum);
            }
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null) {
            if (flag) {
                sum = l2.val + 1;
            } else {
                sum = l2.val;
            }
            if (sum > 9) {
                flag = true;
                node.next = new ListNode(sum - 10);
            } else {
                node.next = new ListNode(sum);
            }
            l2 = l2.next;
            node = node.next;
        }
        if (flag) {
            node.next = new ListNode(1);
        }
        return prev.next;
    }
}
