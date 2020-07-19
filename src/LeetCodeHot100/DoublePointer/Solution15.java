package LeetCodeHot100.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     */

    //排序 + 双指针
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <3){
            return result;
        }
        Arrays.sort(nums);
        for (int i =0; i<nums.length;i++){
            if(nums[i] >0){
                return result;
            }
            if(i >0 && nums[i] == nums[i-1]){
                continue;
            }
            int L = i+1, R= nums.length-1;
            while(L < R){
                int sum = nums[i]+nums[L]+nums[R];
                if(sum == 0){
                    List<Integer> list  = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    result.add(list);
                    while(L < R && nums[L+1] == nums[L]){
                        L++;
                    }
                    while(L < R && nums[R-1] == nums[R]){
                        R--;
                    }
                    R++;
                    L++;
                }else if(sum > 0){
                    R--;
                }else if(sum < 0){
                    L++;
                }
            }
        }
        return result;
    }
}
