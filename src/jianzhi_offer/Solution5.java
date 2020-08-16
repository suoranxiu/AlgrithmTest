package jianzhi_offer;

public class Solution5 {
    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     */
    public void Mirror(TreeNode root) {
        if(root != null){
            TreeNode temp;
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
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
