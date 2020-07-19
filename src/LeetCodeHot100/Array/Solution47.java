package LeetCodeHot100.Array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution47 {
    /**
     * 给定一个 n × n 的二维矩阵表示一个图像。
     *
     * 将图像顺时针旋转 90 度。
     *
     * 说明：
     *
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 示例 1:
     *
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     */
    public void rotate(int[][] matrix) {
        if(matrix[0].length==0){
            return ;
        }
        //先对数组进行转置
        for(int i=0;i<matrix[0].length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //对转置后的数组每一行进行翻转
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix[0].length/2;j++){
                int temp = matrix[i][matrix[1].length-j-1];
                matrix[i][matrix[1].length-j-1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }



}
