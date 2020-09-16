package LeetCodeHot100.Array;

public class Solution59 {

    private int [][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] generateMatrix(int n) {
        int [][] result = new int[n][n];
        boolean [][] visited = new boolean[n][n];

        int index_r= 0;
        int index_c = 0;
        int direct_index = 0;
        for(int i=0;i<n*n; i++){
            visited[index_r][index_c] = true;
            result[index_r][index_c] = i+1;
            int next_row = index_r + direction[direct_index][0];
            int next_column = index_c + direction[direct_index][1];
            if(next_row<0 || next_column<0 || next_row>=n || next_column>=n || visited[next_row][next_column]){
                direct_index = (direct_index + 1)%4;
            }
            index_r += direction[direct_index][0];
            index_c += direction[direct_index][1];
        }
        return result;
    }
}
