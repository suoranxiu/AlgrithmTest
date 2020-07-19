package LeetCodeHot100.BackTrack;

import java.util.*;

public class Solution46 {
    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        List<Integer> out = new ArrayList<>();
        for(Integer num:nums){
            out.add(num);
        }
        backtrack(nums,0,out,result);
        return result;
    }

    public void backtrack(int [] nums,int idx, List<Integer> out,  List<List<Integer>> result){
        if(idx == nums.length){
            result.add(new ArrayList<>(out));
            return;
        }
        for(int i = idx;i<nums.length;i++){
            Collections.swap(out,idx,i);
            backtrack(nums,idx+1,out,result);
            Collections.swap(out,idx,i);
        }
    }
}
