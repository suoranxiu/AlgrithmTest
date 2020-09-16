package LeetCodeHot100.DynamicpProgramming;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        if(word1.length() * word2.length() == 0){
            return word1.length() + word2.length();
        }
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //代表word1 前i个字符 到 word2 前j个字符的距离

        //任意一个字符串长度为0，那么距离就为
        for(int i=0;i<=word1.length();i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=word2.length();j++){
            dp[0][j] = j;
        }
        for(int i = 1;i <= word1.length();i++){
            for(int j = 1;j <= word2.length();j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]));
                }else {
                    dp[i][j] = 1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];

    }
}
