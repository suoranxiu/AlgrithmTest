package LeetCodeHot100.BackTrack;

import java.util.*;

public class Solution40 {
    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 说明：
     *
     *     所有数字（包括目标数）都是正整数。
     *     解集不能包含重复的组合。
     *
     * 示例 1:
     *
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     *
     * 示例 2:
     *
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     *   [1,2,2],
     *   [5]
     * ]
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        if(target<candidates[0] || target<=0 || candidates[0]<=0){
            return result;
        }
        DFS(candidates,target,0,new ArrayDeque<>(),result);
        return result;
    }
    public static void DFS(int[] candidates, int residue, int begin, Deque<Integer> path, List<List<Integer>> result){
        if(residue == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i =begin;i<candidates.length;i++){

            if(residue - candidates[i]<0){
                break;
            }
            if(i>begin && candidates[i] == candidates[i-1]){
                continue;

            }
            path.addLast(candidates[i]);
            DFS(candidates,residue - candidates[i],i+1,path,result);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ss = Solution40.combinationSum2(new int []{10,1,2,7,6,1,5},8);
    }
}
