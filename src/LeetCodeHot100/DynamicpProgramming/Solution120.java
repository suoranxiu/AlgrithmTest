package LeetCodeHot100.DynamicpProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution120 {
    public static int minimumTotal(List<List<Integer>> triangle) {

        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        dp[0][0] = triangle.get(0).get(0);
        dp[1][0] = dp[0][0]+triangle.get(1).get(0);
        dp[1][1] = dp[0][0]+triangle.get(1).get(1);
        int minAns =Integer.MAX_VALUE;
        for(int i=2;i<triangle.size();i++){
            List<Integer> l = triangle.get(i);
            for(int j=0;j<l.size();j++){
                if(j!=l.size()-1){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1])+l.get(j);
                }else {
                    dp[i][j] = dp[i-1][j-1]+l.get(j);
                }
                minAns = Math.min(minAns,dp[i][j]);
            }
        }
        return minAns;

    }

    public static void main(String[] args) {
//        List<List<Integer>> tr = new ArrayList<>();
//        List<Integer> l1 = new ArrayList<>();
//        l1.add(-1);
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(2);
//        l2.add(3);
//        List<Integer> l3 = new ArrayList<>();
//        l3.add(1);
//        l3.add(-1);
//        l3.add(-3);
//        tr.add(l1);
//        tr.add(l2);
//        tr.add(l3);
//        System.out.println(minimumTotal(tr));

    }
}
