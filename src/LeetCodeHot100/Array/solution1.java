package LeetCodeHot100.Array;

import java.util.*;

public class solution1 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    public int[] twoSum(int[] nums, int target) {
        int [] idxList = new int[2];
        if(nums.length == 0){
            return idxList;
        }
        for(int idx = 0;idx < nums.length;idx ++){
            for(int idx2= idx + 1;idx2<nums.length;idx2++){
                if(nums[idx] + nums[idx2] == target){
                    idxList[0] = idx;
                    idxList[1] = idx2;
                    return idxList;
                }
            }
        }
        return idxList;
    }

    public int[] towSumByOneHashMap(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public int[] twoSumByHashMap(int[] nums, int target){
        //key为数字，value为index
        Map<Integer,Integer> unOrderedMap = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            unOrderedMap.put(nums[i],i);
        }
        for (int i = 0; i<nums.length; i++){
            int complement = target - nums[i];
            if(unOrderedMap.containsKey(complement) && unOrderedMap.get(complement) != i){
                return new int[]{i,unOrderedMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Integer[] strs = new Integer[6];
//        int idx = 0;
//        while(scanner.hasNext()){
//            strs[idx] = scanner.nextInt();
////            System.out.println(scanner.next());
//            idx++;
//        }
//        for(int i = 0;i<strs.length;i++){
//            System.out.println(strs[i]);
//        }
        List<Integer> list = new ArrayList<>();
        while(scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        Integer[] array = new Integer[list.size()];
        for(int i = 0;i<array.length;i++){
            array[i] = list.get(i);
            System.out.println(array[i]);
        }

    }
}
