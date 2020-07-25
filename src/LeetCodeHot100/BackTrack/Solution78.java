package LeetCodeHot100.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     *
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    private List<List<Integer>> result = new ArrayList<>();
    private int [] nums;
    private int k;//每个cur列表的长度
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0){
            return result;
        }
        this.nums = nums;
        for(int i =0;i<nums.length+1;i++){
            k=i;
            backTrack(0,new ArrayList<>());
        }
        return result;
    }
    private void backTrack(int index,List<Integer> cur){
        if(cur.size() == k){
            result.add(cur);
            return;
        }
        for(int i = index;i<nums.length;i++){
            cur.add(nums[i]);
            backTrack(index+1,cur);
            cur.remove(cur.size()-1);
        }
    }
}
