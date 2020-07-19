package LeetCodeHot100.DoublePointer;

public class Solution28 {
    /**
     * 实现 strStr() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     *
     * 示例 2:
     *
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     */
    public static int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if(needle.length()>haystack.length() || haystack.length()==0){
            return -1;
        }
        if(needle.length() == haystack.length()){
            return needle.equals(haystack) ? 0:-1;
        }

        int len = needle.length();
        for(int L=0;L<haystack.length()-len+1;L++){
            int R = L+len;
            if(haystack.substring(L,R).equals(needle)){
                return L;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Solution28.strStr("mississippi","pi"));
    }
}
