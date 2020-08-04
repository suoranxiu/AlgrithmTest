package LeetCodeHot100.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Solution200 {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 示例 1:
     *
     * 输入:
     * [
     * ['1','1','1','1','0'],
     * ['1','1','0','1','0'],
     * ['1','1','0','0','0'],
     * ['0','0','0','0','0']
     * ]
     * 输出: 1
     *
     * 示例 2:
     *
     * 输入:
     * [
     * ['1','1','0','0','0'],
     * ['1','1','0','0','0'],
     * ['0','0','1','0','0'],
     * ['0','0','0','1','1']
     * ]
     * 输出: 3
     * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     */
    class Pos{
        int i,j;
        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    private int row;
    private int column;
    boolean[][] isSearched;
    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid[0].length == 0){
            return 0;
        }
        row = grid.length;
        column = grid[0].length;
        isSearched = new boolean[row][column];//用于记录是否被搜索过
        int count =0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j] =='1' && !isSearched[i][j]){//若没有被搜索过，切还是1（岛屿）
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid,int i,int j){
        Queue<Pos> queue = new LinkedList<>();
        isSearched[i][j] = true;//把当前点标记为搜索过，且是岛屿部分
        queue.add(new Pos(i,j));//把当前点放入队列，由于是BFS，队列保证了先进先出
        while (!queue.isEmpty()){
            Pos cur = queue.poll();
            if(cur.i-1 >=0 && !isSearched[cur.i-1][cur.j] && grid[cur.i-1][cur.j] == '1'){
                queue.add(new Pos(cur.i-1,cur.j));
                isSearched[cur.i-1][cur.j] = true;
            }
            if(cur.i+1 <row && !isSearched[cur.i+1][cur.j] && grid[cur.i+1][cur.j] == '1'){
                queue.add(new Pos(cur.i+1,cur.j));
                isSearched[cur.i+1][cur.j] = true;
            }
            if(cur.j-1 >=0 && !isSearched[cur.i][cur.j-1] && grid[cur.i][cur.j-1] == '1'){
                queue.add(new Pos(cur.i,cur.j-1));
                isSearched[cur.i][cur.j-1] = true;
            }
            if(cur.j+1 <column && !isSearched[cur.i][cur.j+1] && grid[cur.i][cur.j+1] == '1'){
                queue.add(new Pos(cur.i,cur.j+1));
                isSearched[cur.i][cur.j+1] = true;
            }
        }
    }
}
