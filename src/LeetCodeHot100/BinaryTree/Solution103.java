package LeetCodeHot100.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {
    /**
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 返回锯齿形层次遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> levelList = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        boolean is_leftToRight = true;

        while (!queue.isEmpty()){
            TreeNode curNode = queue.pollFirst();
            if(curNode != null){
                if(is_leftToRight){
                    levelList.addLast(curNode.val);
                }else {
                    levelList.addFirst(curNode.val);
                }

                if(curNode.left != null){
                    queue.addLast(curNode.left);
                }
                if(curNode.right != null){
                    queue.addLast(curNode.right);
                }
            }else {
                result.add(levelList);
                levelList = new LinkedList<>();
                if(!queue.isEmpty()){
                    queue.addLast(null);
                }
                is_leftToRight  = !is_leftToRight;
            }
        }
        return result;

    }

}
