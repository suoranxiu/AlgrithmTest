package LeetCodeHot100.DynamicpProgramming;

import sun.awt.geom.AreaOp;

public class Solution300 {

    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        //dp[i] 代表以第i个数字(从0开始)结尾的最长上升子序列
        int [] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = Integer.MIN_VALUE;
        for(int i=1; i<nums.length; i++){
            int max_local = 0;//初始化最小值，切记一定要是0！！！
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    max_local = Math.max(max_local,dp[j]);
                }
            }
            dp[i] = max_local+1;
            maxAns = Math.max(dp[i],maxAns);
        }
        return maxAns;
    }

    public static void main(String[] args) {
//        System.out.println((11+3*8)/4%3);
//        Integer[] a = new Integer[10];
//        Integer i = new Integer(42);
//        Double d  = new Double(42.0);
//        Long l = new Long(42);
//        System.out.println(i.equals(d));
       System.out.println(3*0.1==0.3); ;


    }
}
