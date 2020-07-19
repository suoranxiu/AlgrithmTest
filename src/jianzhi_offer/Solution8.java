package jianzhi_offer;

import java.util.Arrays;

public class Solution8 {
    /**
     * 输入一个非空整数数组，判断该数组是不是某二叉搜索树(BST)的后序遍历的结果。如果是则输出Yes,否则输出No。假
     * 设输入的数组的任意两个数字都互不相同。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }else {
            return VerifyBST(sequence,0, sequence.length-1);
        }

    }
    public boolean VerifyBST(int [] sequence,int start, int end){
        if(start >= end){
            return true;
        }
        int root = sequence[end];
        int idx;
        //区别左右子树
        for(idx = start; idx < end;idx++){
            if(sequence[idx] > root){
                break;
            }
        }
        //判断右子树中有没有比root值小的数
        for(int j=idx; j<end; j++){
            if(sequence[j] < root){
                return false;
            }
        }
        return VerifyBST(sequence,start,idx-1) && VerifyBST(sequence,idx,end-1);
    }

    public static void main(String[] args) {
        int [] a = {4,8,6,12,16,14,10};
        Solution8 solution8= new Solution8();
        System.out.println(solution8.VerifySquenceOfBST(a));
    }
}
