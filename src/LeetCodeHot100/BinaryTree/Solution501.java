package LeetCodeHot100.BinaryTree;

import java.util.*;

public class Solution501 {
    public int[] findMode(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<>();
        List<Map.Entry<TreeNode,Integer>> entryList = new ArrayList<>();
        Collections.sort(entryList, new Comparator<Map.Entry<TreeNode, Integer>>() {
            @Override
            public int compare(Map.Entry<TreeNode, Integer> o1, Map.Entry<TreeNode, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        List<Integer> l = new ArrayList<>();
        for(int i=1;i<entryList.size();i++){
            if(entryList.get(i).getValue() == entryList.get(0).getValue()){
                l.add(entryList.get(i).getKey().val);
            }
        }
        Integer[] array =new Integer[l.size()];
        l.toArray(array);
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }
}
