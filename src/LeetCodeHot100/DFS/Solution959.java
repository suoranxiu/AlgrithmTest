package LeetCodeHot100.DFS;

public class Solution959 {

    /**
     * 用DFS方式做
     */
    int[][] nine_grid ;
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        nine_grid = new int[N*3][N*3];
        //将每个1x1的grid转化成每个网格由0或1填充的3x3的grid
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(grid[i].charAt(j) == '/'){
                    nine_grid[i*3][j*3+2] = 1;
                    nine_grid[i*3+1][j*3+1] = 1;
                    nine_grid[i*3+2][j*3] = 1;
                }else if(grid[i].charAt(j) == '\\'){
                    nine_grid[i*3][j*3] = 1;
                    nine_grid[i*3+1][j*3+1] = 1;
                    nine_grid[i*3+2][j*3+2] = 1;
                }
            }
        }
        int count = 0;
        for(int i = 0; i<nine_grid.length; i++){
            for(int j = 0; j<nine_grid.length; j++){
                if(nine_grid[i][j] == 0){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j){
        if(i>=0 && j<nine_grid.length && j>=0 && i<nine_grid.length){
            if(nine_grid[i][j] == 0){
                nine_grid[i][j] = 1;
                dfs(i,j-1);
                dfs(i,j+1);
                dfs(i+1,j);
                dfs(i-1,j);
            }
        }
    }
}
