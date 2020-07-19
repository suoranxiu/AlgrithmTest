package LeetCodeHot100.BinarySearch;

public class Solution33 {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     */
    public int search(int[] nums, int target) {//二分法
        //time:O(logn)
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return target == nums[0] ? 0:-1;
        }
        int L = 0;
        int R = nums.length-1;
        while(L<=R){
            int mid = (L+R)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[0]<=nums[mid]){
                if(nums[0]<=target && target<nums[mid]){
                    R = mid-1;
                }else {
                    L = mid+1;
                }
            }else {
                if(nums[mid]<target && target<= nums[nums.length-1]){
                    L = mid+1;
                }else {
                    R = mid-1;
                }
            }
        }
        return -1;
    }
}
