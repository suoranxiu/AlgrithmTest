package LeetCodeHot100.BinarySearch;

public class Solution34 {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     *
     * 示例 2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     */
    public int[] searchRangeByBinarySearch(int[] nums, int target) {//二分法
        //time:O(log n)
        //space:O(1)
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        if(nums[0] > target){
            return new int[]{-1,-1};
        }
        if(nums.length == 1){
            return nums[0] == target ? new int[]{0,0}:new int[]{-1,-1};
        }
        int start = -1;
        int end = -1;

        int leftIndex = searchBorderIndex(nums,target,true);
        if(leftIndex == nums.length || nums[leftIndex] != target){
            return new int[]{start,end};
        }
        start = leftIndex;
        end = searchBorderIndex(nums,target,false)-1;
        return new int[]{start,end};
    }
    public int searchBorderIndex(int [] nums,int target,boolean left){
        int low = 0;
        int high=nums.length;
        while(low<high){
            int mid = (low+high)/2;
            if(nums[mid]>target || (left && nums[mid]==target)){
                high = mid;
            }else {
                low = mid +1;
            }
        }
        return low;
    }
    public int[] searchRangeByLinearSort(int[] nums, int target) {//线性排序
        //time:O(n)
        //space:O(1)
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums[0] > target) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }
        int start = -1;
        int end = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                start = i;
                break;
            }
        }
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j]== target){
                end = j;
                break;
            }
        }
        return new int[]{start,end};
    }
}
