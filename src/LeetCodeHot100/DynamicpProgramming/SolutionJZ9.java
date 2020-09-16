package LeetCodeHot100.DynamicpProgramming;

public class SolutionJZ9 {
    public int JumpFloorII(int target) {
        if(target<=2){
            return target;
        }
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=target;i++){
            for(int j=i-1;j>0;j--){
                dp[i] += dp[j];
            }
            dp[i]+=1;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        String s1 = "hello";
        System.out.println(s1 == "hello");
        System.out.println("s1 = \"hello\"");
    }
}
