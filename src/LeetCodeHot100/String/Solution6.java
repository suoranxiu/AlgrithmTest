package LeetCodeHot100.String;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"
     */

    public String convert(String s, int numRows) {
        if(s == null || s.length() <1){
            return "";
        }
        if(numRows == 1){
            return s;
        }
        List<StringBuffer> stringRows = new ArrayList<>();
        for (int i = 0; i<Math.min(numRows,s.length()); i++){
            stringRows.add(new StringBuffer());
        }
        int curRow = 0;
        boolean upDown = false; //True 为 down， 反之为up
        for (char c :s.toCharArray()){
            stringRows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows-1){
                upDown = !upDown;
            }
            curRow += upDown ? 1:-1;
        }
        StringBuffer result = new StringBuffer();
        for(StringBuffer row:stringRows){
            result.append(row);
        }
        return result.toString();
    }
}
