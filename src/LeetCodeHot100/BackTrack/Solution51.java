package LeetCodeHot100.BackTrack;

import java.util.*;

public class Solution51 {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        Set<Integer> columns;
        Set<Integer> diagonal1;
        Set<Integer> diagonal2;
        List<String> arr;
        boolean[][] flag;
        for(int column_idx=0;column_idx<n;column_idx++){//第一行，从0~(n-1)遍历，然后递归,并将列索引加入到set中
            columns = new HashSet<>();
            diagonal1 = new HashSet<>();
            diagonal2 = new HashSet<>();

            arr = new ArrayList<>();

            String row = String.join("", Collections.nCopies(n,"."));

            columns.add(column_idx);
            diagonal1.add(0+column_idx);//之和
            diagonal2.add(column_idx-0);//之差

            row = repalceAt(row,column_idx,"Q");

            arr.add(row);
            dfs(arr,columns,diagonal1,diagonal2,n,result,1);
        }
        return result;
    }
    private void dfs(List<String> arr,Set<Integer> columns,Set<Integer> diagonal1,Set<Integer> diagonal2,
                     int n,List<List<String>> result,
                     int row_index){
        if(arr.size()==n){
            result.add(new ArrayList<>(arr));
            return;
        }
        for(int column_idx=0;column_idx<n;column_idx++){
            if(!columns.contains(column_idx) && !diagonal1.contains(row_index+column_idx) &&!diagonal2.contains(column_idx-row_index)){

                String row = String.join("", Collections.nCopies(n,"."));
                row = repalceAt(row,column_idx,"Q");
                columns.add(column_idx);
                diagonal1.add(row_index+column_idx);//之和
                diagonal2.add(column_idx-row_index);//之差
                arr.add(row);

                dfs(arr,columns,diagonal1,diagonal2,n,result,row_index+1);

                //backtrack
                columns.remove(column_idx);
                arr.remove(arr.size()-1);
                diagonal1.remove(row_index+column_idx);//之和
                diagonal2.remove(column_idx-row_index);//之差
            }

        }
    }
    private String repalceAt(String str,int i,String target){
        StringBuilder sb = new StringBuilder(str);
        sb.replace(i,i+1,target);
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(String.join("", Collections.nCopies(8,".")));
    }
}
