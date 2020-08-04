package LeetCodeHot100.BackTrack;

import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution131 {

    private List<List<String>> result;
    private List<String> path;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s.length()==0){
            return result;
        }
        if(s.length() == 1){
            List<String> path= new ArrayList<>();
            path.add(s);
            result.add(path);
            return result;
        }
        path= new ArrayList<>();
        backtrack(s,0);
        return result;
    }
    private void backtrack(String str,int start){
        if(start ==str.length()){
            //对当前的path做一个拷贝，为了在result中存不同的path
            List<String> temp = new ArrayList<>();
            temp.addAll(path);
            result.add(temp);
            return;
        }
        StringBuilder stringBuilder;
        String tmp;
        for(int i=start;i<str.length();i++){
            tmp = str.substring(start,i+1);//依次选取不同长度的字符串
            stringBuilder = new StringBuilder(tmp).reverse();
            if(stringBuilder.toString().equals(tmp)){//判断是否回文
                path.add(tmp);
                backtrack(str,i+1);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution131 solution = new Solution131();
        solution.partition("aab");

    }
}
