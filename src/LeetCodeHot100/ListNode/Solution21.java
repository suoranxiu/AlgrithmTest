package LeetCodeHot100.ListNode;

import java.util.List;

public class Solution21 {
    /**
     *将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoListsByRecur(ListNode l1, ListNode l2) {
        //time: O(m+n)
        //space: O(m+n)
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        else if(l1.val <l2.val){
            l1.next = mergeTwoListsByRecur(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoListsByRecur(l1,l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsByIter(ListNode l1, ListNode l2) {
        //time: O(m+n)
        //space: O(1)
        ListNode preHead = new ListNode(0);
        ListNode cur = preHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1;
        }else if(l2 != null){
            cur.next = l2;
        }
        return preHead.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
