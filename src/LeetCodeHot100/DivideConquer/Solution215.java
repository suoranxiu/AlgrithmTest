package LeetCodeHot100.DivideConquer;

import java.util.Random;

public class Solution215 {
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     *
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     *
     * 说明:
     *
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     */

    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }
    private int partition(int[] array,int left,int rightBorder){
        int ref = left;
        int index = ref+1;
        for(int i = index;i<rightBorder;i++){
            if(array[ref]>array[i]){
                swapArray(array,i,index);
                index++;
            }
        }
        swapArray(array,ref,index-1);
        return index-1;
    }
    private int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swapArray(a, i, r);
        return partition(a, l, r);
    }
    private int quickSelect(int [] a,int l,int r,int index){
        int q = randomPartition(a,l,r);
        if(q == index){
            return a[q];
        }else {
            return q<index ? quickSelect(a,q+1,r,index):quickSelect(a,l,q-1,index);
        }
    }
    public void swapArray(int[] array,int idx1,int idx2){
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }


}
