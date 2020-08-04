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
        if(nums.length <3){
            return result;
        }
        Arrays.sort(nums);
        if(nums[0] >0){
            return result;
        }
        //三指针
        int cur =0;
        int left;
        int right;
        List<Integer> list;
        for(;cur<nums.length;cur++){
            if(cur!=0 && nums[cur]==nums[cur-1]){
                continue;
            }
            int diff = -nums[cur];
            left = cur+1;
            right = nums.length-1;
            while(left<right){
                if(nums[left] + nums[right]<diff){
                    left++;
                }else if(nums[left]+nums[right] >diff){
                    right--;
                }else {
                    list = new ArrayList<>();
                    list.add(nums[cur]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left<right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left<right && nums[right-1] == nums[right]){
                        right--;
                    }
                    right--;
                    left++;

                }
            }
        }
        return result;
    }
}
