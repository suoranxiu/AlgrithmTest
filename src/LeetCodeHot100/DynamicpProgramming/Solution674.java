package LeetCodeHot100.DynamicpProgramming;

public class Solution674 {

    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length ==0){
            return 0;
        }
        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i] = dp[i-1]+1;
            }else {
                dp[i] = 1;
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i =0;i<dp.length;i++){
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
