package LeetCodeHot100.DynamicpProgramming;

public class Solution64 {
    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     */
    public static int minPathSum(int[][] grid) {
        int m = grid[0].length;

        int n = grid.length;

        int[][] minAnsArray = new int[n][m];
        minAnsArray[0][0] = grid[0][0];
        for (int i = 1;i<n;i++){
            minAnsArray[i][0] = minAnsArray[i-1][0]+ grid[i][0];
        }
        for (int i = 1;i<m;i++){
            minAnsArray[0][i] = minAnsArray[0][i-1]+ grid[0][i];
        }
        for(int i = 1;i<n;i++){
            for(int j=1;j<m;j++){
                minAnsArray[i][j] = Math.min(minAnsArray[i-1][j]+grid[i][j],minAnsArray[i][j-1]+grid[i][j]);
            }
        }
        return minAnsArray[n-1][m-1];
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{1,2,5},{3,2,1}};
//        Solution64.minPathSum(grid);
        int[][] grid = new int[3][2];
        System.out.println();
    }
}
