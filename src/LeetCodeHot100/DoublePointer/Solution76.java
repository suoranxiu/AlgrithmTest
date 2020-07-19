package LeetCodeHot100.DoublePointer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution76 {
    /**
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
     *
     * 示例：
     *
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     *
     * 说明：
     *
     *     如果 S 中不存这样的子串，则返回空字符串 ""。
     *     如果 S 中存在这样的子串，我们保证它是唯一的答案。
     */
    HashMap<Character,Integer> window_map = new HashMap<>();
    HashMap<Character,Integer> t_map = new HashMap<>();

    public String minWindow(String s, String t) {//双指针滑窗+HashMap

        char[] c_array = t.toCharArray();
        for(Character c:c_array){
            t_map.put(c,t_map.getOrDefault(c,0)+1);
        }
        int l = 0;
        int r = -1;
        int ansL = -1;
        int ansR = -1;
        int window_length = Integer.MAX_VALUE;
        while(r<s.length()){
            r++;
            if(r<s.length()&&t_map.containsKey(s.charAt(r))){
                window_map.put(s.charAt(r),window_map.getOrDefault(s.charAt(r),0)+1);
            }
            while(check()&& l<=r){//window中的的包含t中的字母，其数量并大于等于
                if(r-l+1<window_length){
                    window_length = r-l+1;
                    ansL = l;
                    ansR = l+window_length;
                }
                if(t_map.containsKey(s.charAt(l))){
                    window_map.put(s.charAt(l),window_map.getOrDefault(s.charAt(l),0)-1);

                }
                l++;
            }
        }
        return ansL==-1?"":s.substring(ansL,ansR);
    }
    private boolean check(){
        Iterator iterator = t_map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            Character key = (Character)entry.getKey();
            Integer val = (Integer)entry.getValue();
            if(window_map.getOrDefault(key,0)<val){
                return false;
            }
        }
        return true;
    }




}
