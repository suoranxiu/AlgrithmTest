package LeetCodeHot100.DynamicpProgramming;

public class Solution53 {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    public int maxSubArray(int[] nums) {//用动态规划做 f(i)=max{f(i−1)+ai​,ai​}
        if(nums.length ==0){
            return 0;
        }
        int pre= 0;
        int maxAns = nums[0];
        for(int i =0 ;i<nums.length;i++){
            pre = Math.max(pre+nums[i],nums[i]);
            maxAns = Math.max(pre,maxAns);
        }

        return maxAns;
    }
}
