package LeetCodeHot100.DoublePointer;

import java.util.Arrays;

public class Solution16 {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
     * 返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     *
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     *
     */
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length <3){
            return 0;
        }
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];;
        for(int i =0; i<nums.length; i++){
            int L = i+1;
            int R = nums.length-1;
            while (L<R){
                int sum = nums[i]+nums[L]+nums[R];
                ans = distance(sum,target) <= distance(ans,target) ? sum:ans;
                if(sum <target) {
                    L++;
                }else if(sum >target){
                    R--;
                }else {
                    return ans;
                }
            }
        }
        return ans;
    }
    public static int distance(int x, int y){
        return Math.abs((x-y));
    }

    public static void main(String[] args) {
        System.out.println(Solution16.threeSumClosest(new int [] {-1,0,1,1,55},3));
    }
}
