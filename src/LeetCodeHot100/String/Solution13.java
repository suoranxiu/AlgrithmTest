package LeetCodeHot100.String;

import java.util.HashMap;

public class Solution13 {
    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     *     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     *     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     *     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     *
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     */
    public static int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder stringBuilder = new StringBuilder(s);
        int ans = 0;
        if(s.length() == 0 ||s == null){
            return ans;
        }
        for(int i = 0; i<symbols.length;i++){
            while(stringBuilder.length() != 0){
                if(symbols[i].equals(stringBuilder.substring(0,1))){
                    ans += values[i];
                    stringBuilder.delete(0,1);
                    continue;
                }else if(symbols[i].equals(stringBuilder.substring(0,2)) && stringBuilder.length()>=2){
                    ans += values[i];
                    stringBuilder.delete(0,2);
                    continue;
                }else {
                    break;
                }
            }
        }
        return ans;
    }
    private static HashMap<String,Integer> map = new HashMap<>();
    static {
        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);
    }
    public static int romanToInt2(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int ans = 0;
        if(s.length() == 0 ||s == null){
            return ans;
        }
        while(stringBuilder.length() != 0){
            if(stringBuilder.length() >=2 && map.containsKey(stringBuilder.substring(0,2))){
                ans+= map.get(stringBuilder.substring(0,2));
                stringBuilder.delete(0,2);
            }else if(map.containsKey(stringBuilder.substring(0,1))){
                ans+=map.get(stringBuilder.substring(0,1));
                stringBuilder.delete(0,1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(Solution13.romanToInt("III"));
//        StringBuilder stringBuilder = new StringBuilder("III");
//        System.out.println("I".equals(stringBuilder.substring(0,1)));
        System.out.println(romanToInt2("MCMXCIV"));

    }
}
