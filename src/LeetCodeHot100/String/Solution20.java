package LeetCodeHot100.String;

import java.util.HashMap;
import java.util.Stack;

public class Solution20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     *     左括号必须用相同类型的右括号闭合。
     *     左括号必须以正确的顺序闭合。
     *
     * 注意空字符串可被认为是有效字符串。
     */
    HashMap<Character,Character> maps;

    public Solution20() {
        maps.put(')','(');
        maps.put('}','{');
        maps.put(']','[');
    }

    public boolean isValid(String s) {//栈
        if(s == null || s.length()==0 || s.length()%2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(maps.containsKey(c)){
                char top = stack.isEmpty() ?'#':stack.pop();
                if(top != maps.get(c)){
                    return  false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String a = "abcd";
        System.out.println(a.substring(0,1));
    }
}
