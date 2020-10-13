package LeetCodeHot100.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution489 {
    /**
     *  merged by DFS
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val+t2.val);
        merged.left = mergeTrees(t1.left,t2.left);
        merged.right = mergeTrees(t1.right,t2.right);

        return merged;
    }

    /**
     *  merged by BFS
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTreesbyBFS(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        TreeNode mergedRoot = new TreeNode(0);
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        Queue<TreeNode> mergedQueue = new LinkedList<>();
        queue1.add(t1);
        queue2.add(t2);
        mergedQueue.add(mergedRoot);
        while(!queue1.isEmpty() || !queue2.isEmpty() || !mergedQueue.isEmpty()){
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            TreeNode merged = mergedQueue.poll();
            merged.val = node1.val+node2.val;

            if(node1.left != null || node2.left != null){
                if(node1.left != null && node2.left != null){
                    TreeNode left = new TreeNode(0);
                    merged.left = left;
                    mergedQueue.add(merged.left);
                    queue1.add(node1.left);
                    queue2.add(node2.left);
                }else if(node1.left == null){
                    merged.left = node2.left;
                }else if(node2.left == null){
                    merged.left = node1.left;
                }
            }

            if(node1.right != null || node2.right != null){
                if(node1.right != null && node2.right != null){
                    TreeNode right = new TreeNode(0);
                    merged.right = right;
                    mergedQueue.add(merged.right);
                    queue1.add(node1.right);
                    queue2.add(node2.right);
                }else if(node1.right == null){
                    merged.right = node2.right;
                }else if(node2.right == null){
                    merged.right = node1.right;
                }
            }
        }
        return mergedRoot;
    }
}
