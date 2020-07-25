package LeetCodeHot100.BinaryTree;

public class Solution98 {
    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     *     节点的左子树只包含小于当前节点的数。
     *     节点的右子树只包含大于当前节点的数。
     *     所有左子树和右子树自身必须也是二叉搜索树
     */
  public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return digui(root,null,null);
    }
    public boolean digui(TreeNode node,Integer up,Integer low){
      if(node == null){
          return true;
      }
      if(up  !=null &&  node.val >= up ){
          return false;
      }
      if(low != null && node.val <= low) {
          return false;
      }
      if(!digui(node.left,node.val,low)){
          return false;
      }
      if(!digui(node.right,up,node.val)){
          return false;
      }
      return true;
    }
}
