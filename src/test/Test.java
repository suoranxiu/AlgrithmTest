package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{};
        }
        int [] new_nums = Arrays.copyOf(nums,nums.length);
        Arrays.sort(new_nums);
        int [] result = new int[2];
        int m,n=0;
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            if(new_nums[left]+new_nums[right]>target){
                right --;
            }else if(new_nums[left]+new_nums[right]<target){
                left++;
            }else if(new_nums[left]+new_nums[right] == target){
                m = left;
                n = right;
                break;
            }
        }
        return result;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode cur0 = head;

        ListNode cur1= l1;
        ListNode cur2 = l2;

        int in = 0;
        while(cur1 != null || cur2 != null){
            int tmp=0;
            if(cur1 != null){
                tmp+=cur1.val;
                cur1 = cur1.next;
            }
            if(cur2 != null){
                tmp+=cur2.val;
                cur2 = cur2.next;
            }
            tmp += in;
            in = tmp/10;
            cur0.next = new ListNode(tmp%10);
            cur0 = cur0.next;
        }
        if(in > 0){
            cur0.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        List<Integer> result = addToArrayForm(new int[]{2,7,4},181);
        int a =1;
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int i = A.length-1;
        int offset = 0;
        while(K>0 && i>=0){
            int ans = K%10 + A[i] + offset;
            if(ans>=10){
                list.add(ans%10);
                offset = 1;
            }else {
                list.add(ans);
                offset = 0;
            }
            i--;
            K = K/10;
        }
        while(i>=0){
            int ans = A[i] + offset;
            if(ans>=10){
                list.add(ans%10);
                offset = 1;
            }else {
                list.add(ans);
                offset = 0;
            }
            i--;
        }
        while(K>0){
            int ans = K%10 + offset;
            if(ans>=10){
                list.add(ans%10);
                offset = 1;
            }else {
                list.add(ans);
                offset = 0;
            }
            K = K/10;
        }
        if(offset>0){
            list.add(1);
        }
        Collections.reverse(list);
        return list;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}