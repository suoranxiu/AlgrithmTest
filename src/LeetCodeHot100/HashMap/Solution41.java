package LeetCodeHot100.HashMap;

import java.util.Arrays;

public class Solution41 {
    /**
     * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [1,2,0]
     * 输出: 3
     *
     * 示例 2:
     *
     * 输入: [3,4,-1,1]
     * 输出: 2
     *
     * 示例 3:
     *
     * 输入: [7,8,9,11,12]
     * 输出: 1
     *
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
     *
     * 解答：
     * 检查 1 是否存在于数组中。如果没有，则已经完成，1 即为答案。
     * 如果 nums = [1]，答案即为 2 。
     * 将负数，零，和大于 n 的数替换为 1 。
     * 遍历数组。当读到数字 a 时，替换第 a 个元素的符号。
     * 注意重复元素：只能改变一次符号。由于没有下标 n ，使用下标 0 的元素保存是否存在数字 n。
     * 再次遍历数组。返回第一个正数元素的下标。
     * 如果 nums[0] > 0，则返回 n 。
     * 如果之前的步骤中没有发现 nums 中有正数元素，则返回n + 1。
     */
    public static int firstMissingPositive(int[] nums) {//模仿HashMap
        int len = nums.length;
        boolean contain=false;
        for(int i=0;i<len;i++){
            if(nums[i]==1){
                contain=true;
                break;
            }
        }
        if(!contain){
            return 1;
        }
        if(len==1){
            return 2;
        }

        for(int i=0;i<len;i++){
            if(nums[i]<=0 || nums[i]>len){
                nums[i]=1;
            }
        }

        for(int i=0;i<len;i++){
            int a = Math.abs(nums[i]);
            if(a == len){
                nums[0] = -Math.abs(nums[0]);
            }else {
                nums[a] = -Math.abs(nums[a]);
            }
        }

        for(int i=1;i<len;i++){
            if(nums[i]>0){
                return i;
            }
        }
        if(nums[0]>0){
            return len;
        }
        return len+1;
    }

    public static void main(String[] args) {
        System.out.println(Solution41.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
