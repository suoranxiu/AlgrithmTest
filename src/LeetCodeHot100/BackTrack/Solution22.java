package LeetCodeHot100.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 示例：
     *
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     *
     */
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return result;
        }
        backTrack(new StringBuilder(),0,0,n);
        return result;
    }
    public void backTrack(StringBuilder cur,int open, int close,int max){
        if(cur.length() == max*2){
            result.add(cur.toString());
            return;
        }
        if(open<max){
            cur.append('(');
            backTrack(cur,open+1,close,max);
            cur.deleteCharAt(cur.length()-1);
        }
        if(close < open){
            cur.append(')');
            backTrack(cur,open,close+1,max);
            cur.deleteCharAt(cur.length()-1);
        }
    }

}
