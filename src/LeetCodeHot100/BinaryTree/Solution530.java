package LeetCodeHot100.BinaryTree;

public class Solution530 {

    int ans = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        LDR(root);
        return ans;
    }
    public void LDR(TreeNode root){
        if(root.left != null){
            LDR(root.left);
        }
        ans = pre==-1?ans:Math.min(Math.abs(pre-root.val),ans);
        pre = root.val;
        if(root.right != null){
            LDR(root.right);
        }
    }

//    public static void main(String[] args) {
//        Solution530 solution530 = new Solution530();
//        solution530.getMinimumDifference()
//    }
}
