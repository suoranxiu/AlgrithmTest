package LeetCodeHot100.DFS;

import java.util.*;

public class Pdd11 {
    private static Map<Integer,Integer> treeMap;
    private static int N,M=0;//N为树的分类数， M为数的总数
    private static List<String> ans;

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        while (scanner.hasNext()){
            N = scanner.nextInt();
            treeMap = new HashMap<>();
            for(int i=1;i<=N;i++){
                treeMap.put(i,scanner.nextInt());
                M += treeMap.get(i);
            }
        }

        ans = new ArrayList<>();
        if(dfs(0)){
            System.out.println(String.join(" ",ans));
        }else {
            System.out.println("-");
        }

    }
    private static boolean dfs(int index){
        if (index==M){
            return true;
        }
        for(int i = 1; i<=N; i++){
            if(index == 0 || (treeMap.get(i) !=0 && i != Integer.valueOf(ans.get(index-1)))){
                int stock = treeMap.get(i);
                treeMap.put(i,stock--);
                ans.add(""+i);
                if(dfs(index+1)){
                    return true;
                }else {
                    int stock_ = treeMap.get(i);
                    treeMap.put(i,stock_++);
                    ans.remove(ans.size()-1);
                }
            }
        }
        return false;
    }
}
