package jianzhi_offer;

import java.util.HashMap;

public class solution7 {
    /**
     *
     输入一棵二叉树，判断该二叉树是否是平衡二叉树。

     在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树

     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if(left == -1 || right == -1 ){
            return -1;
        }
        return Math.abs(left-right)>1 ? -1:Math.max(left,right)+1;
    }

    /**
     * Definition for binary tree
     */

    static class TreeNode {
        int val =0;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
