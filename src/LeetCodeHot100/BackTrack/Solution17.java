package LeetCodeHot100.BackTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */
    Map<String,String> numberMap = new HashMap<>();
    List<String> result = new ArrayList<>();
    //回溯算法
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits ==null){
            return result;
        }
        initMap();
        backTrack("",digits);

        return result;
    }
    public void backTrack(String combination,String nextDigits){
        if(nextDigits.length() == 0){
            result.add(combination);
        }else {
            String digit = nextDigits.substring(0,1);
            String letters = numberMap.get(digit);
            for(int i =0;i<letters.length();i++){
                String letter = letters.substring(i,i+1);
                backTrack(combination+letter,nextDigits.substring(1));
            }
        }
    }
    public void initMap(){
        numberMap.put("2","abc");
        numberMap.put("3","def");
        numberMap.put("4","ghi");
        numberMap.put("5","jkl");
        numberMap.put("6","mno");
        numberMap.put("7","pqrs");
        numberMap.put("8","tuv");
        numberMap.put("9","wxyz");
    }

}
