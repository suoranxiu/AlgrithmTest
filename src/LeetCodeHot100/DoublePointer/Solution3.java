package LeetCodeHot100.DoublePointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    public int lengthOfLongestSubstring(String s) {
        Set<Character> slideSet = new HashSet<>();
        int len = s.length();

        int ans =0;
        int right = -1;
        for(int left = 0;left<len;left++){
            if(left>0){
                slideSet.remove(s.charAt(left-1));
            }
            while ( right+1<len && !slideSet.contains(s.charAt(right+1))){
                slideSet.add(s.charAt(right+1));
                right++;
            }
            ans = Math.max(ans,slideSet.size());
        }

        return ans;
    }
}
