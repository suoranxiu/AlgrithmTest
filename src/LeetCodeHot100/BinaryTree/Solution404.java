package LeetCodeHot100.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(isLeafNode(root)){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if(isLeafNode(curNode)){
                sum+=curNode.val;
            }
            if(curNode.left != null){
                queue.add(curNode.left);
            }
            if(curNode.right != null){
                if(!isLeafNode(curNode.right)){
                    queue.add(curNode.right);
                }
            }
        }
        return sum;
    }
    private boolean isLeafNode(TreeNode node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }
}
