package LeetCodeHot100.Array;

import java.util.Arrays;

public class Solution4 {
    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     *
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 你可以假设 nums1 和 nums2 不会同时为空。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length >0 || nums2.length >0){
            int [] total = new int[nums1.length + nums2.length];
            System.arraycopy(nums1, 0, total, 0, nums1.length);
            System.arraycopy(nums2, 0, total, nums1.length, nums2.length);

            Arrays.sort(total);
            if(total.length%2 != 0){
                return total[total.length/2];
            }else {
                return (double) (total[total.length/2-1]+ total[total.length/2])/2;
            }
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.findMedianSortedArrays(new int[]{1,3},new int[]{2,6}));
    }
}
