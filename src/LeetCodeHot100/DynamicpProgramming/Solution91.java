package LeetCodeHot100.DynamicpProgramming;

import java.util.HashMap;

public class Solution91 {

    /**
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     *
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     *
     * 示例 1:
     *
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     *
     * 示例 2:
     *
     * 输入: "226"
     * 输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     */

    public static int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int len = s.length();
        int[] ansArray = new int[len];
        ansArray[0] = 1;

        if(len >2){
            for(int R = 2;R<len;R++){
                char cur = s.charAt(R);
                if(cur == '0'){
                    if(s.charAt(R-1) == '1' || s.charAt(R-1) == '2'){
                        ansArray[R] = ansArray[R-2];
                    }else {
                        return 0;
                    }
                }else if(s.charAt(R-1) == '1'){
                    ansArray[R] = ansArray[R-1]+ansArray[R-2];
                }else if(s.charAt(R-1) == '2' && '1'<=cur && cur<='6'){
                    ansArray[R] = ansArray[R-1]+ansArray[R-2];
                }
            }
        }
        return ansArray[len-1];
    }


    public static void main(String[] args) {
        String a = "10";
        System.out.println( Solution91.numDecodings(a));

    }
}
