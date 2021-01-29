package LeetCodeHot100.UnionFind;

import java.util.Arrays;

public class Solution1579 {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);

        //将节点编号修改为从0开始，方便索引
        for(int[] edge:edges){
            edge[1]--;
            edge[2]--;
        }
        int count = 0;//可删除的边数
        //先遍历公共边
        for(int[] edge:edges){
            if(edge[0] == 3){
                if(!alice.unite(edge[1],edge[2])){
                    count++;
                }else {
                    bob.unite(edge[1],edge[2]);
                }
            }
        }
        //遍历非公共边
        for(int[] edge:edges){
            if(edge[0] == 1){//只能Alice
                if(!alice.unite(edge[1],edge[2])){
                    count++;
                }
            }else if(edge[0] == 2){//只能Bob
                if(!bob.unite(edge[1],edge[2])){
                    count++;
                }
            }
        }
        if(alice.setCount !=1 || bob.setCount != 1){
            return -1;
        }
        return count;
    }

    class UnionFind{
        int setCount;
        int[] parentSet;
        int[] parentSetSize;
        public UnionFind(int setCount) {
            this.setCount = setCount;
            this.parentSet = new int[setCount];
            this.parentSetSize = new int[setCount];
            Arrays.fill(parentSetSize,1);
            for(int i = 0; i < setCount; i++){
                this.parentSet[i] = i;//代表当前代号为i的结点属于父集i
            }
        }
        private int findFatherSet(int x){
            return parentSet[x] == x ? x : findFatherSet(parentSet[x]);
        }
        public boolean unite(int x,int y){
            int father_x = findFatherSet(x);
            int father_y = findFatherSet(y);
            if(father_x == father_y){
                return false;
            }
            if(parentSetSize[father_x] < parentSetSize[father_y]){//比较两个集合中节点的数量，向多数的集合中合并
                int tmp = father_y;
                father_y = father_x;
                father_x = tmp;
            }
            parentSet[father_y] = father_x;
            parentSetSize[father_x] += parentSetSize[father_y];
            setCount--;
            return true;
        }
    }

}
