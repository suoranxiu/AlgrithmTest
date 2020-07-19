package LeetCodeHot100.ListNode;

public class Solution23 {
    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * 示例:
     *
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     */
    public ListNode mergeKListsByIter(ListNode[] lists) {//顺序法
        //time:O(k^2n)
        //space:O(1)
        ListNode ans = null;
        for(int i =0;i<lists.length;i++){
            ans = mergeTwoListsByIter(ans,lists[i]);
        }
        return ans;
    }

    public ListNode mergeKListsByDivideConquer(ListNode[] lists) {//分治法
        //time:O(kn x logk)
        //space:O(logk)
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int l, int r){
        if(l==r){
            return lists[0];
        }
        if(l>r){
            return null;
        }
        int mid = (l+r)/2;
        return mergeTwoListsByIter(merge(lists,l,mid),merge(lists,mid+1,r));
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
