package LeetCodeHot100.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution226 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curNode =  queue.poll();
            TreeNode tmp = curNode.right;
            curNode.right = curNode.left;
            curNode.left = tmp;
            if(curNode.right != null){
                queue.add(curNode.right);
            }
            if(curNode.left != null){
                queue.add(curNode.left);
            }
        }
        return root;
    }
    public TreeNode invertTree2(TreeNode root) {
        if(root == null){
            return null;
        }
        recur(root);
        return root;
    }
    private void recur(TreeNode root){
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        if(root.right != null){
            recur(root.right);
        }
        if(root.left != null){
            recur(root.left);
        }
    }

}
