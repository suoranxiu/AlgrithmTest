package jianzhi_offer;

public class
Solution4 {
    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 ==null || root2== null){
            return false;
        }else {
            return recur(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }

    }

    boolean recur(TreeNode A, TreeNode B) {
        if(B == null){
            return true;
        }
        if(A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
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
