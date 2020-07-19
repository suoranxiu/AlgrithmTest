package LeetCodeHot100.BackTrack;

import java.util.*;

public class Solution39 {
    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     *
     *     所有数字（包括 target）都是正整数。
     *     解集不能包含重复的组合。
     *
     * 示例 1:
     *
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     *
     * 示例 2:
     *
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {//回溯+剪枝 //DFS
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        if(target<candidates[0] || target<=0 || candidates[0]<=0){
            return result;
        }
        DFS(candidates,target,0,new ArrayDeque<>(),result);
        return result;

    }
    public void DFS(int[] candidates, int residue, int begin, Deque<Integer> path,List<List<Integer>> result){
        if(residue == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i =begin;i<candidates.length;i++){
            if(residue - candidates[i]<0){
                break;
            }
            path.addLast(candidates[i]);
            DFS(candidates,residue - candidates[i],i,path,result);
            path.removeLast();
        }


    }

}
