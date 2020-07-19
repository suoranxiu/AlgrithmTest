package LeetCodeHot100.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution25 {
    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 示例：
     *
     * 给你这个链表：1->2->3->4->5
     *
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     *
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     * 说明：
     *
     *     你的算法只能使用常数的额外空间。
     *     你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while(head != null){
            ListNode tail = pre;
            for(int i=0;i<k;i++){
                tail=tail.next;
                if(tail == null){
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] result = reverse(head,tail);
            head = result[0];
            tail = result[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
        }
        return hair.next;
    }
    public ListNode[] reverse(ListNode head,ListNode tail){
        ListNode pre = tail.next;
        ListNode p = head;
        while(pre != tail){
            ListNode  nex = p.next;
            p.next = pre;
            pre = p;
            p = nex;
        }
        return new ListNode[]{tail,head};
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
