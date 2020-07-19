package jianzhi_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution9 {
    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return  resultList;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode firstNode = queue.poll();
            resultList.add(firstNode.val);
            if(firstNode.left != null){
                queue.offer(firstNode.left);
            }
            if(firstNode.right != null){
                queue.offer(firstNode.right);
            }
        }
        return resultList;
    }


    static class TreeNode {
        int val =0;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
