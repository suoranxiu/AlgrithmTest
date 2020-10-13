package LeetCodeHot100.Array;

public class SolutionJZ35 {
    public static void main(String[] args) {
        SolutionJZ35 s = new SolutionJZ35();
        int result = 0;
        int [] array = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(s.InversePairs(array));
    }
    private int result;
    public int InversePairs(int [] array) {
        result = 0;
        mergeSort(array,0,array.length-1);
        return result;
    }
    private void mergeSort(int[] nums,int left, int rightBorder){
        if(left>=rightBorder){
            return ;
        }
        int mid = left +(rightBorder-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,rightBorder);
        merge(nums,left,mid+1,rightBorder);
    }
    private void merge(int[] nums,int left,int right,int rightBorder){
        int l = left;
        int r = right;
        int[] temp = new int[rightBorder-left+1];
        int k=0;
        while (l<right && r<=rightBorder){
            if(nums[l]>nums[r]){
                temp[k++] = nums[r++];
                result +=(right-l);
                result %=1000000007;
            }else {
                temp[k++] = nums[l++];
            }
        }
        while (l<right){
            temp[k++] = nums[l++];
        }
        while (r<=rightBorder){
            temp[k++] = nums[r++];
        }
        for(int i=0;i<temp.length;i++){
            nums[left+i] = temp[i];
        }
    }
}
