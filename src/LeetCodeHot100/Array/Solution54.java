package LeetCodeHot100.Array;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     *
     * 示例 1:
     *
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     *
     * 示例 2:
     *
     * 输入:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     */

    private int [][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return result;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean [][] visited = new boolean[rows][columns];

        int direct_index = 0;
        int total = rows*columns;

        int index_r= 0;
        int index_c = 0;

        for(int i = 0;i<total;i++){
            result.add(matrix[index_r][index_c]);
            visited[index_r][index_c] = true;
            int next_row = index_r + direction[direct_index][0];
            int next_column = index_c + direction[direct_index][1];

            if(next_row<0 || next_column<0 || next_row>=rows || next_column>=columns || visited[next_row][next_column]){
                direct_index = (direct_index + 1)%4;
            }
            index_r += direction[direct_index][0];
            index_c += direction[direct_index][1];
        }
        return result;
    }
}
