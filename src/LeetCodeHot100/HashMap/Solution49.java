package LeetCodeHot100.HashMap;

import java.util.*;

public class Solution49 {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     * 说明：
     *
     *     所有输入均为小写字母。
     *     不考虑答案输出的顺序。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        if(strs.length == 0){
            return result;
        }
        for(int i =0; i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str_ = String.valueOf(chars);
            if(!map.containsKey(str_)){
                List<String> array = new ArrayList<>();
                array.add(strs[i]);
                map.put(str_,array);
            }else {
                map.get(str_).add(strs[i]);
            }
        }

        return new ArrayList(map.values());

    }
}
