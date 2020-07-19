package LeetCodeHot100.BinaryTree;



import java.util.*;

public class Solution1 {

    /**
     * 给定一个二叉树，返回它的中序 遍历。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();

        resultList = getInorderTraversalVal(root,resultList);

        return resultList;
    }

    public List<Integer> getInorderTraversalVal(TreeNode treeNode,List<Integer> traversalList){
        if(treeNode == null){
            return traversalList;
        }
        if(treeNode.left != null ){
            traversalList = getInorderTraversalVal(treeNode.left,traversalList);
        }
        traversalList.add(treeNode.val);
        if(treeNode.right != null){
            traversalList = getInorderTraversalVal(treeNode.right,traversalList);
        }

        return traversalList;
    }

    public List < Integer > inorderTraversalByStack(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
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
