package LeetCodeHot100.BinaryTree;

public class Solution968 {
    public int minCameraCover(TreeNode root) {
        return Math.min(minCam(root,true,true),minCam(root,false,false));
    }

    /**
     *
     * @param root 当前节点
     * @param isPlaced 当前节点是否放置相机
     * @param watched 当前节点是否被自己或者父节点监控
     * @return
     */
    private int minCam(TreeNode root,boolean isPlaced,boolean watched){
        if(root == null){
            if(isPlaced){
                return Integer.MAX_VALUE;
            }
            return 0;
        }
        if(isPlaced){
            return 1+Math.min(Math.min(minCam(root.left,false,true)+minCam(root.right,false,true),
                    minCam(root.left,true,true)+minCam(root.right,false,true)),
                    minCam(root.left,false,true)+minCam(root.right,true,true));
        }else if(watched){
            return Math.min(Math.min(Math.min(minCam(root.left,true,true)+minCam(root.right,true,true),
                    minCam(root.left,true,true)+minCam(root.right,false,false)),
                    minCam(root.left,false,false)+minCam(root.right,true,true)),
                    minCam(root.left,false,false)+minCam(root.right,false,false)
            );
        }else {
            return Math.min(Math.min(minCam(root.left,true,true)+minCam(root.right,false,false),
                    minCam(root.left,true,true)+minCam(root.right,true,true)),
                    minCam(root.left,false,false)+minCam(root.right,true,true));
        }
    }
}
