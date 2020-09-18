package LeetCodeHot100.BinaryTree;

import java.util.Arrays;

public class SolutionJZ4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length*in.length == 0){
            return null;
        }
        TreeNode root = null ;
        for(int i=0;i<pre.length;i++){
            for(int j=0;j<in.length;j++){
                if(pre[i] == in[j]){
                    root = new TreeNode(in[j]);
                    root.left = reConstructBinaryTree(pre, Arrays.copyOfRange(in,0,j));
                    root.right = reConstructBinaryTree(pre, Arrays.copyOfRange(in,j+1>in.length-1?in.length:j+1,in.length));
                    return root;
                }
            }

        }
        return root;
    }

    public static void main(String[] args) {
        SolutionJZ4 s = new SolutionJZ4();
        TreeNode root = s.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});
        System.out.println(root);
    }
}
