package LeetCodeHot100.DynamicpProgramming;

public class Solution5 {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     *
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     */

    public String longestPalindrome(String s) {//动态规划
        if(s.length() <=1){
            return s;
        }
        if(s.length() ==2){
            return s.charAt(0)==s.charAt(1)?s:s.substring(0,1);
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i =0 ;i<s.length();i++){
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        for(int j = 1;j<s.length();j++){
            for (int i=0;i<j;i++){ //i<j
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if(j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j]  && j-i+1>maxLen){
                    maxLen = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}

