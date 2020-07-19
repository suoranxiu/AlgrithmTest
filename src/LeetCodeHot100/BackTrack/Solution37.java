package LeetCodeHot100.BackTrack;

import java.util.HashMap;

public class Solution37 {
    /**
     * 编写一个程序，通过已填充的空格来解决数独问题。
     *
     * 一个数独的解法需遵循如下规则：
     *
     *     数字 1-9 在每一行只能出现一次。
     *     数字 1-9 在每一列只能出现一次。
     *     数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     *
     * 空白格用 '.' 表示。
     */
    char[][] board;
    HashMap<Integer, Integer>[] columns = new HashMap[9];
    HashMap<Integer, Integer>[] rows = new HashMap[9];
    HashMap<Integer, Integer>[] boxes = new HashMap[9];
    boolean solved;

    public Solution37() {
        for (int i = 0; i < 9; i++) {
            columns[i] = new HashMap<>();
            rows[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
    }
    public void placeNumber(int d,int row,int col ){
        int box_idx = (row/3)*3+(row/3);

        rows[row].put(d,rows[row].getOrDefault(d,0)+1);
        columns[col].put(d,columns[col].getOrDefault(d,0)+1);
        boxes[box_idx].put(d,boxes[box_idx].getOrDefault(d,0)+1);
        board[row][col] = (char)(d+'0');
    }
    public void removeNumber(int d,int row,int col){
        int box_idx = (row/3)*3+(row/3);

        rows[row].put(d,rows[row].get(d)-1);
        columns[col].put(d,columns[col].get(d)-1);
        boxes[box_idx].put(d,boxes[box_idx].get(d)-1);
        board[row][col] = '.';
    }
    public boolean couldPlace(int d,int row,int col){
        int box_idx = (row/3)*3+(row/3);
        return rows[row].getOrDefault(d,0)+columns[col].getOrDefault(d,0)+boxes[box_idx].getOrDefault(d,0) == 0;
    }
    public void solveSudoku(char[][] board) {//回溯+HashMap
        this.board = board;
        for(int i = 0;i<9;i++){
            for(int j=0;j<9;j++){
                char c =board[i][j];
                if(c != '.'){
                    int d = Character.getNumericValue(c);
                    placeNumber(d,i,j);
                }
            }
        }
        backTrack(0,0);
    }
    public void placeNext(int row, int col){
        if(row == 8 && col == 8){
            solved = true;
        }else {
            if(col == 8){
                backTrack(row+1,0);
            }else {
                backTrack(row,col+1);
            }
        }
    }
    public void backTrack(int row,int col){
        if(board[row][col] == '.'){
            for(int d=1;d<10;d++){
                if(couldPlace(d,row,col)){
                    placeNumber(d,row,col);
                    placeNext(row,col);
                    if(!solved){
                        removeNumber(d,row,col);
                    }
                }
            }
        }else {
            placeNext(row,col);
        }
    }
}
