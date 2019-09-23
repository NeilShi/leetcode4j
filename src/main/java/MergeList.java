/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeList {
    /**
     * 时间复杂度:
     * 空间复杂度:
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        boolean head = true;
        while (l1.next != null || l2.next != null) {
            if (l1.val < l2.val) {
                if (head) {
                    result = l1;
                } else {
                    result = l1.next;
                }
                l1 = l1.next;
            } else {
                if (head) {
                    result = l2;
                } else {
                    result = l2.next;
                }
                l2 = l2.next;
            }
        }
        return result;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}