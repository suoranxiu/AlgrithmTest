package jianzhi_offer;

import java.util.Arrays;

public class Solution3 {
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{1,2,4,7,3,5,6,8}，则重建二叉树并返回。
     * (二叉树的推导遍历问题)
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if(pre.length != 0 && in.length != 0){
            TreeNode root = new TreeNode(pre[0]);
            for (int idx = 0; idx < pre.length; idx ++){
                if(in[idx] == pre[0]){
                    root.leftChild = reConstructBinaryTree(Arrays.copyOfRange(pre,1,idx+1),
                            Arrays.copyOfRange(in,0,idx));
                    root.rightChild = reConstructBinaryTree(Arrays.copyOfRange(pre,idx+1,pre.length),
                            Arrays.copyOfRange(in,idx + 1 ,in.length));
                    break;
                }
            }
            return root;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {

        Solution3 solution3 = new Solution3();
        TreeNode T = solution3.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{1,2,4,7,3,5,6,8});
    }

}

/**
 * Definition for binary tree
 */

class TreeNode {
    int val;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int val) {
        this.val = val;
    }
}
