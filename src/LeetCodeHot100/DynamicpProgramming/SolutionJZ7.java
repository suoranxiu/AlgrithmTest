package LeetCodeHot100.DynamicpProgramming;

public class SolutionJZ7 {
    /**
     * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
     *
     * n<=39
     */
    public int Fibonacci(int n) {
        if(n <= 1){
            return n;
        }
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
