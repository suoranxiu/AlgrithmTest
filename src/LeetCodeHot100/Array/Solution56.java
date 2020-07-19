package LeetCodeHot100.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {
    /**
     *给出一个区间的集合，请合并所有重叠的区间。
     * 示例 1:
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * 示例 2:
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[][]{};
        }
        List<int[]> res = new ArrayList<>();
        //按每行的第一个元素排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        res.add(intervals[0]);
        for(int idx =1 ;idx<intervals.length;idx++){
            if(intervals[idx][0]<=res.get(res.size()-1)[1]){
                res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1],intervals[idx][1]);
            }else {
                res.add(intervals[idx]);
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Solution56.merge(new int[][]{{1,2},{0,2},{3,4},{2,5}}));
    }
}
