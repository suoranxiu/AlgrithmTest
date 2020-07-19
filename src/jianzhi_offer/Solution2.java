package jianzhi_offer;

import java.util.ArrayList;
import java.util.Collections;

public class Solution2 {
    public static void main(String[] args) {

    }

    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resultList = new ArrayList<>();
        while (true) {
            if (listNode.next == null) {
                resultList.add(listNode.val);
                break;
            } else {
                resultList.add(listNode.val);
            }
        }
        Collections.reverse(resultList);
        return resultList;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}