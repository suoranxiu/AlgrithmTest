package LeetCodeHot100.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
     * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     *注意：
     *
     * 答案中不可以包含重复的四元组。
     *
     * 示例：
     *
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     *
     * 满足要求的四元组集合为：
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {//By Self
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length <4){
            return result;
        }
        Arrays.sort(nums);
        List<Integer> numList;
        for(int i =0;i< nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1;j<nums.length;j++){
                if(j-1 != i && nums[j] == nums[j-1]){
                    continue;
                }
                int L = j+1;
                int R = nums.length-1;
                while(L<R){
                    int sum = nums[i]+nums[j]+nums[L]+nums[R];
                    if(sum == target){
                        numList = new ArrayList<>();
                        numList.add(nums[i]);
                        numList.add(nums[j]);
                        numList.add(nums[L]);
                        numList.add(nums[R]);
                        result.add(numList);
                        while(L<R && nums[L] == nums[L+1]){
                            L++;
                        }
                        while(L<R && nums[R] == nums[R-1]){
                            R--;
                        }
                        L++;
                        R--;
                    }else if(sum < target){
                        L++;
                    }else if(sum > target){
                        R--;
                    }
                }
            }

        }
        return result;
    }
    public static List<List<Integer>> fourSumByLeetCode(int[] nums, int target) {//双指针
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if(len <4){
            return result;
        }
        Arrays.sort(nums);
        List<Integer> numList;
        for(int i =0;i< len;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int minSum = nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(minSum > target){
                break;
            }
            int maxSum = nums[i]+nums[len-3]+nums[len-2]+nums[len-1];
            if(maxSum < target){
                break;
            }
            for (int j = i+1;j<len;j++){
                if(j-1 != i && nums[j] == nums[j-1]){
                    continue;
                }
                int L = j+1;
                int R = len-1;
                int minSum2 = nums[i]+nums[j]+nums[L]+nums[L+1];
                if(minSum2 > target){
                    break;
                }
                int maxSum2 = nums[i]+nums[j]+nums[R]+nums[R-1];
                if(maxSum2 < target){
                    break;
                }
                while(L<R){
                    int sum = nums[i]+nums[j]+nums[L]+nums[R];
                    if(sum == target){
                        numList = new ArrayList<>();
                        numList.add(nums[i]);
                        numList.add(nums[j]);
                        numList.add(nums[L]);
                        numList.add(nums[R]);
                        result.add(numList);
                        while(L<R && nums[L] == nums[L+1]){
                            L++;
                        }
                        while(L<R && nums[R] == nums[R-1]){
                            R--;
                        }
                        L++;
                        R--;
                    }else if(sum < target){
                        L++;
                    }else if(sum > target){
                        R--;
                    }
                }
            }

        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Solution18.fourSum(new int[]{0,0,0,0},0));;
    }
}
