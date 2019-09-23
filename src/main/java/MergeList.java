import datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

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
     * 选择排序
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        List<ListNode> nodeArrList = new ArrayList<ListNode>();
        while (l1 != null) {
            nodeArrList.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            nodeArrList.add(l2);
            l2 = l2.next;
        }
        ListNode temp;
        for (int i = 0; i < nodeArrList.size(); i++) {
            for (int j = i + 1; j < nodeArrList.size(); j++) {
                if (nodeArrList.get(i).val > nodeArrList.get(j).val) {
                    temp = nodeArrList.get(i);
                    nodeArrList.set(i, nodeArrList.get(j));
                    nodeArrList.set(j, temp);
                }
            }
        }
        for (int i = 0; i < nodeArrList.size() - 1; i++) {
            nodeArrList.get(i).next = nodeArrList.get(i + 1);
            if (i == nodeArrList.size() - 2) {
                nodeArrList.get(i + 1).next = null;
            }
        }
        return nodeArrList.size() == 0 ? null : nodeArrList.get(0);
    }

    /**
     * 标准答案 递归 todo
     * 时间复杂度:
     * 空间复杂度:  1->2->4, 3->4->5
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l1;
        }
        if (l2 == null) {
            return l2;
        }
        if (l1.val < l2.val) {
            return mergeTwoLists2(l1, mergeTwoLists2(l1.next, l2));
        } else {
            return mergeTwoLists2(l2, mergeTwoLists2(l2.next, l1));
        }
    }

    /**
     * 标准答案 迭代
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n) 1->2->4, 3->4->5
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null || l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        return pre;  //todo
    }

}