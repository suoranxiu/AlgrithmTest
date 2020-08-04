package LeetCodeHot100.DoublePointer;

public class Solution11 {
    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     */
    //利用双指针法
    public int maxArea(int[] height) {
        if(height.length <2){
            return 0;
        }
        int max = 0;
        int i=0,j = height.length-1;
        while(i<j){
            int area = calArea(i,j,height);
            max = Math.max(area,max);
            if(height[i]<=height[j]){//比较两边，哪边小，移动哪边
                i++;
            }else {
                j--;
            }
        }
        return max;
    }
    public int calArea(int x, int y, int[] height){
        return Math.abs(x-y)*Math.min(height[x],height[y]);
    }
}
