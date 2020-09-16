package LeetCodeHot100.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
     TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> queue =new LinkedList<>();
        List<Double> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        queue.addLast(root);
        queue.addLast(null);
        double mean = 0;
        int count =0;
        while(!queue.isEmpty()){
            TreeNode cur = queue.pollFirst();
            if(cur != null){
                mean += cur.val;
                count++;
                if(cur.left != null){
                    queue.addLast(cur.left);
                }
                if(cur.right != null){
                    queue.addLast(cur.right);
                }
            }
            else {
                list.add((mean/count));
                mean = 0;
                count = 0;
                if(!queue.isEmpty()){
                    queue.addLast(null);
                }
            }
        }
        return list;
    }
}
