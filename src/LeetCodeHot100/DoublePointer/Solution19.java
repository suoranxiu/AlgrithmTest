package LeetCodeHot100.DoublePointer;


public class Solution19 {
    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     */
    public ListNode removeNthFromEndByTwoTraverse(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        int length = 0;
        ListNode cur = head;
        while(pre.next != null){
            length++;
            cur = cur.next;
        }
        length -=n;
        cur = head;
        while(length >0){
            length--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return pre.next;
    }

    //采用双指针 实现一次遍历
    public ListNode removeNthFromEndByOneTraverse(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        int length = 0;
        ListNode cur1 = head;
        ListNode cur2 = head;
        while(cur1 != null){
            if(length > n){
                cur2 = cur2.next;
            }
            cur1 = cur1.next;
            if(cur1.next == null){
                cur2.next = cur2.next.next;
            }
            length++;
        }
        return pre.next;
    }

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

}
