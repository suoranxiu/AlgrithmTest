package jianzhi_offer;

public class Solution6 {
    /**
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
     * 最长路径的长度为树的深度。
     */

    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else {
            return Math.max(TreeDepth(root.right),TreeDepth(root.left))+1;
        }

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
