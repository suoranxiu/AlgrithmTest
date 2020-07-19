package LeetCodeHot100.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution5 {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     */
    public String longestPalindrome(String s) {
        if(s.length() <1 || s == null){
            return "";
        }
        Map<Integer,String> subStringMap = new HashMap();
        int len = 0;
        StringBuffer reversed;
        for(int i=0; i< s.length();i++){
            for (int j = i+1; j< s.length()-i+1; j++ ){
                String subString = s.substring(i,i+j);
                reversed = new StringBuffer(subString).reverse();
                if(reversed.toString().equals(subString)){
                    subStringMap.put(subString.length(),subString);
                    if(subString.length() > len){
                        len = subString.length();
                    }
                }
            }
        }
        return subStringMap.get(len);
    }

    public String longestPalindrome2(String s){

        return null;
    }


    public static void main(String[] args) {
        String str = "a";
        Map<Integer,String> subStringMap = new HashMap();
        int len = 0;
//        StringBuffer reversed;
        for(int i=0; i< str.length();i++){
            for (int j = i+1; j< str.length(); j++ ){
                String subString = str.substring(i,j);
                StringBuffer reversed = new StringBuffer(subString).reverse();
                if(reversed.toString().equals(subString)){
                    subStringMap.put(subString.length(),subString);
                    if(subString.length() > len){
                        len = subString.length();
                    }
                }
            }
        }
        System.out.println(subStringMap.get(len));

//        StringBuffer s = new StringBuffer(str);
//        StringBuffer c = new StringBuffer(str);
//        System.out.println(c.reverse());
//        System.out.println(s);
//        System.out.println(c.toString().equals(s.toString()));
    }

}
