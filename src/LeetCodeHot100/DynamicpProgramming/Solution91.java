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
    HashMap<Integer,Character> map = new HashMap<>();

    {
        map.put(1,'A');
        map.put(2,'B');
        map.put(3,'C');
        map.put(4,'D');
        map.put(5,'E');
        map.put(6,'F');
        map.put(7,'G');
        map.put(8,'H');
        map.put(9,'I');
        map.put(10,'J');
        map.put(11,'K');
        map.put(12,'L');
        map.put(13,'M');
        map.put(14,'N');
        map.put(15,'O');
        map.put(16,'P');
        map.put(17,'Q');
        map.put(18,'R');
        map.put(19,'S');
        map.put(20,'T');
        map.put(21,'U');
        map.put(22,'V');
        map.put(23,'W');
        map.put(24,'X');
        map.put(25,'Y');
        map.put(26,'Z');
    }
    public int numDecodings(String s) {
        if(s.length()==1){
            return 1;
        }
        int len = s.length();
        int[] ansArray = new int[len];

        int L=0;
        int R;
        ansArray[0] = 1;
        if(check(s.substring(0,2))){
            ansArray[1] = 2;
        }else {
            ansArray[1] = 1;
        }
        for(R = 2;R<len;R++){
            if(check(s.substring(L,R+1))){
                ansArray[R] = ansArray[R-2];
            }
        }
        return 0;
    }

    private boolean check(String s){
        int i = Integer.parseInt(s);
        return 1<=i&&i<=26;
    }
}
