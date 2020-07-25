package LeetCodeHot100.DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution130 {
    /**
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     *
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *
     * 示例:
     *
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     *
     * 运行你的函数后，矩阵变为：
     *
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     *
     * 解释:
     * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，
     * 或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     */

    private int row;
    private int column;
    private char [][] board;
    public void solve1(char[][] board) {//递归方式
        if(board.length==0){
            return;
        }
        this.board = board;
        row = board.length;
        column = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                boolean isEdge = (i==0 || j ==0|| i == row-1 || j == column-1);
                if(isEdge && board[i][j] == 'O'){
                    dfsDigui( i, j);
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(this.board[i][j] == 'O'){
                    this.board[i][j] = 'X';
                }else if(this.board[i][j] == '#'){
                    this.board[i][j] = 'O';
                }
            }
        }

    }
    private void dfsDigui(int i, int j){
        if(i<0 || j<0 || i>row-1 || j>column-1 || board[i][j] == 'X' || board[i][j] == '#'){
            return;
        }
        this.board[i][j] = '#';
        dfsDigui(i-1,j);
        dfsDigui(i+1,j);
        dfsDigui(i,j-1);
        dfsDigui(i,j+1);
    }
    public void solve2(char[][] board) {//循环方式
        if(board.length==0){
            return;
        }
        this.board = board;
        row = board.length;
        column = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                boolean isEdge = (i==0 || j ==0|| i == row-1 || j == column-1);
                if(isEdge && board[i][j] == 'O'){
                    dfsLoop( i, j);
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(this.board[i][j] == 'O'){
                    this.board[i][j] = 'X';
                }else if(this.board[i][j] == '#'){
                    this.board[i][j] = 'O';
                }
            }
        }
    }
    class Pos{
        int i;
        int j;
        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    private void dfsLoop(int i, int j){
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(i,j));
        this.board[i][j] = '#';
        while (!stack.empty()){
            Pos cur = stack.peek();//取出栈顶，不弹出
            if(cur.i -1>=0 && this.board[cur.i -1][cur.j]=='O'){
                stack.push(new Pos(cur.i -1,cur.j));
                this.board[cur.i -1][cur.j] = '#';
                continue;
            }
            if(cur.j -1>=0 && this.board[cur.i][cur.j-1]=='O'){
                stack.push(new Pos(cur.i,cur.j-1));
                this.board[cur.i][cur.j-1] = '#';
                continue;
            }
            if(cur.i +1<=row-1 && this.board[cur.i +1][cur.j]=='O'){
                stack.push(new Pos(cur.i +1,cur.j));
                this.board[cur.i +1][cur.j] = '#';
                continue;
            }
            if(cur.j +1<=column-1 && this.board[cur.i][cur.j +1]=='O'){
                stack.push(new Pos(cur.i,cur.j+1));
                this.board[cur.i][cur.j+1] = '#';
                continue;
            }
            stack.pop();//弹出栈顶
        }
    }

    public void solve3(char[][] board) {//BFS循环方式
        if(board.length==0){
            return;
        }
        this.board = board;
        row = board.length;
        column = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                boolean isEdge = (i==0 || j ==0|| i == row-1 || j == column-1);
                if(isEdge && board[i][j] == 'O'){
                    bfs( i, j);
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(this.board[i][j] == 'O'){
                    this.board[i][j] = 'X';
                }else if(this.board[i][j] == '#'){
                    this.board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(int i, int j) {
        Queue<Pos> queue = new LinkedList<>();
        board[i][j] = '#';
        queue.add(new Pos(i,j));
        while (!queue.isEmpty()){
            Pos cur = queue.poll();

            if(cur.i -1>=0 && this.board[cur.i -1][cur.j]=='O'){
                queue.add(new Pos(cur.i -1,cur.j));
                this.board[cur.i -1][cur.j] = '#';
            }
            if(cur.j -1>=0 && this.board[cur.i][cur.j-1]=='O'){
                queue.add(new Pos(cur.i,cur.j-1));
                this.board[cur.i][cur.j-1] = '#';
            }
            if(cur.i +1<=row-1 && this.board[cur.i +1][cur.j]=='O'){
                queue.add(new Pos(cur.i +1,cur.j));
                this.board[cur.i +1][cur.j] = '#';
            }
            if(cur.j +1<=column-1 && this.board[cur.i][cur.j +1]=='O'){
                queue.add(new Pos(cur.i,cur.j+1));
                this.board[cur.i][cur.j+1] = '#';
            }
        }
    }


}
