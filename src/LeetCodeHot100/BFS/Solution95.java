package LeetCodeHot100.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution95 {
    /***
     * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
     *
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
     *
     * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     *
     *
     *
     * 示例 1:
     *
     * 输入: 2, [[1,0]]
     * 输出: true
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
     *
     * 示例 2:
     *
     * 输入: 2, [[1,0],[0,1]]
     * 输出: false
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
     *
     * 提示：
     *
     *     输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
     *     你可以假定输入的先决条件中没有重复的边。
     *     1 <= numCourses <= 10^5
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] inDegrees = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        for (int [] cur:prerequisites){
            int in_node = cur[0];
            inDegrees[in_node]++;
            adjacency.get(cur[1]).add(in_node);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegrees[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int out_node = queue.poll();
            List<Integer> in_node_list = adjacency.get(out_node);
            numCourses--;
            for(int cur_in_node:in_node_list){
                inDegrees[cur_in_node]--;
                if(inDegrees[cur_in_node]==0){
                    queue.add(cur_in_node);
                }
            }
        }
        return numCourses == 0;
    }
}
