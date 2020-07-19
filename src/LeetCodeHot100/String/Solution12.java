package LeetCodeHot100.String;

import java.util.HashMap;
import java.util.Map;

public class Solution12 {
    /**
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     *     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     *     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     *     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     *
     * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     */
    public Map<Integer,String> translateMap = new HashMap<>();
    public void init(){
        translateMap.put(1,"I");
        translateMap.put(4,"IV");
        translateMap.put(5,"V");
        translateMap.put(9,"IX");
        translateMap.put(10,"X");
        translateMap.put(40,"XL");
        translateMap.put(50,"L");
        translateMap.put(90,"XC");
        translateMap.put(100,"C");
        translateMap.put(400,"CD");
        translateMap.put(500,"D");
        translateMap.put(900,"CM");
        translateMap.put(1000,"M");
    }

    //贪心算法：为了表示一个给定的整数，我们寻找适合它的最大符号。我们减去它，然后寻找适合余数的最大符号，
    // 依此类推，直到余数为0。我们取出的每个符号都附加到输出的罗马数字字符串上。
    public String intToRoman(int num) {
        init();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder string = new StringBuilder();
        if (1<=num && num <= 3999){
            for(int i = 0; i<values.length;i++){
                while(values[i] <= num){
                    num -= values[i];
                    string.append(translateMap.get(values[i]));
                }
            }
        }else {
            return "";
        }
        return string.toString();
    }
}
