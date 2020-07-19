package LeetCodeHot100.DoublePointer;

import java.util.ArrayList;
import java.util.List;

public class Solution42 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     */
    public int trap(int[] height) {
        //time:O(n)
        //space:O(n)
        int len = height.length;
        if(len ==0){
            return 0;
        }
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        for(int i=1;i<len;i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        rightMax[len-1] = height[len-1];
        for(int i =len-2;i>=0;i--){
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }
        int ans = 0;
        for(int i=0;i<len;i++){
            ans +=(Math.min(leftMax[i],rightMax[i])-height[i]);
        }
        return ans;
    }
    public int trap2(int[] height) {//双指针
        //time:O(n)
        //space:O(1)
        int len = height.length;
        if(len ==0){
            return 0;
        }
        int L = 0;
        int R = len-1;
        int L_max = height[L];
        int R_max= height[R];
        int ans = 0;
        while(L<R){
            if(height[L]<height[R]){
                if(height[L]>=L_max){
                    L_max = height[L];
                }else {
                    ans += (L_max - height[L]);
                }
                L++;
            }else {
                if(height[R]>=R_max){
                    R_max = height[R];
                }else {
                    ans += (R_max - height[R]);
                }
                R--;
            }
        }
        return ans;
    }
}
