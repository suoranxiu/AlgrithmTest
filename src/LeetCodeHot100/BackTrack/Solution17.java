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
    private List<String> result;
    private Map<String,String> numberMap = new HashMap<>();
    private StringBuilder stringBuilder;
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
    //回溯算法
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        initMap();
        stringBuilder = new StringBuilder();
        backTrack(digits,0);
        return result;
    }
    private void backTrack(String digits,int start){
        if(start == digits.length()){
            result.add(stringBuilder.toString());
            return;
        }
        String curNum = digits.substring(start,start+1);//当前数字
        String letters = numberMap.get(curNum);//当前数字对应的字符串
        for(int i=0;i<letters.length();i++){//遍历当前数字对应的字符串
            stringBuilder.append(letters.substring(i,i+1));
            backTrack(digits,start+1);//继续找下一个数字
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());//若到头了会删出当前sb最后一个字符，进入下一个循环
        }
    }

}
