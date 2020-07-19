package LeetCodeHot100.ListNode;

public class Solution24 {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例:
     *
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public ListNode swapPairsByIter(ListNode head) {
        //time:O(N)
        //space:O(1)
        if(head ==null){
            return null;
        }
        if(head.next ==null){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;

        while(head != null && head.next != null){
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            cur.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            cur = firstNode;
            head = firstNode.next;
        }
        return pre.next;

    }

    public ListNode swapPairsByReCur(ListNode head) {
        //time:O(N)
        //space:O(1)
        if(head ==null){
            return null;
        }
        if(head.next ==null){
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairsByReCur(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;

    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
