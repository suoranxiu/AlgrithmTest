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
        if(strs.length == 1){
            return strs[0];
        }
        StringBuffer stringBuffer = new StringBuffer();
        String ref = strs[0];
        for(int i =0;i<ref.length();i++){
            String cur = ref.substring(i,i+1);
            for(int j=1;j<strs.length;j++){
                if(i<strs[j].length() ){
                    if(!strs[j].substring(i,i+1).equals(cur)){
                        return stringBuffer.toString();
                    }
                }else {
                    return stringBuffer.toString();
                }
            }
            stringBuffer.append(cur);
        }
        return stringBuffer.toString();
    }
    public static String longestCommonPrefix2(String[] strs) {
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
