package LeetCodeHot100.BackTrack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    /**
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     *
     * 示例:
     *
     * 输入: [1,1,2]
     * 输出:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
      */
    private  int len;
    private boolean[] flag;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> totalList = new ArrayList<>();
        len = nums.length;
        flag = new boolean[len];
        List<Integer> list = new ArrayList<>();
        backtrack(nums,list,totalList);
        return totalList;
    }

    private void backtrack(int[] nums,List<Integer> list, List<List<Integer>> totalList){
        if(list.size() == len){
            totalList.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<len;i++){
            if(flag[i] || (i>0 && nums[i] == nums[i-1] && !flag[i-1])){
                continue;
            }
            list.add(nums[i]);
            flag[i] = true;
            backtrack(nums,list,totalList);
            list.remove(list.size()-1);
            flag[i] = false;

        }
    }

    public static void main(String[] args) {
        Solution47 s = new Solution47();
        System.out.println(s.permuteUnique(new int[]{1,2,1}).toString());
    }
}
