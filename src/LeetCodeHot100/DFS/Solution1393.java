package LeetCodeHot100.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1393 {
    Set<Integer> set;
    List<Integer>[] edges;
    public int makeConnected(int n, int[][] connections) {
        //通过dfs找连通分量个数K，来确定至少移动次数N，N=K-1
        if(n-1>connections.length){
            return -1;
        }
        edges = new List[n];
        for (int i = 0; i < n; ++i) {
            edges[i] = new ArrayList<Integer>();
        }
        //根据connections建立双向边的列表
        for(int[] con:connections){
            edges[con[0]].add(con[1]);
            edges[con[1]].add(con[0]);
        }
        set = new HashSet<>();
        int result = 0;
        for(int i=0;i<n;i++){
            if(!set.contains(i)){
                dfs(i);
                result++;
            }
        }
        return result-1;
    }
    public void dfs(int num){
        set.add(num);
        for(int i=0;i<edges[num].size();i++){
            if(!set.contains(edges[num].get(i))){
                dfs(edges[num].get(i));
            }
        }
    }
}
