package LeetCodeHot100.String;

public class Solution14 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     */

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length ==0 || strs == null){
            return "";
        }
        String result = strs[0];
        if(strs.length >1){
            for(int i =1; i<strs.length ;i++){
                int j= 0;
                for(;j<result.length() && j<strs[i].length();j++){
                    if(result.charAt(j) != strs[i].charAt(j)){
                        break;
                    }
                }
                result = result.substring(0,j);
                if(result.equals("")){
                    return result;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        String [] strs = {"flower","flow","flight"};
        System.out.println(Solution14.longestCommonPrefix(strs));;
    }
}
