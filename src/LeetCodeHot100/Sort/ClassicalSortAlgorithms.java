package LeetCodeHot100.Sort;

public class ClassicalSortAlgorithms {

    public void sort1(int[] array){//冒泡排序
        if(array.length<2){
            return;
        }
        int i = 0;
        int j = 1;
        for(;i<array.length;i++){
            for(;j<array.length-i;j++){
                if(array[j-1]>array[j]){
                    swapArray(array,j,j-1);
                }
            }
        }
    }
    public void swapArray(int[] array,int idx1,int idx2){
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public void sort2(int[] array){//选择排序
        if(array.length<2){
            return;
        }
        for(int i = 0;i<array.length-1;i++){
            int minIdx = i;
            for(int j=i+1;j<array.length;j++){
                if(array[minIdx] > array[j]){
                    minIdx = j;
                }
            }
            swapArray(array,minIdx,i);
        }
    }

    public void sort3(int[] array){//插入排序
        if(array.length<2){
            return;
        }
        for(int i = 1;i<array.length;i++){
            for(int j=i;j>0;j--){
                if(array[j]<array[j-1]){
                    swapArray(array,j,j-1);
                }else {
                    break;
                }
            }

        }
    }

    public void sort4(int[] array){//希尔排序
        if(array.length<2){
            return;
        }
        for(int i = 1;i<array.length;i++){
            for(int j=i;j>0;j--){
                if(array[j]<array[j-1]){
                    swapArray(array,i,j-1);
                }else {
                    break;
                }
            }

        }
    }

    public void sort5(int[] array){//归并排序
        if(array.length<2){
            return;
        }
        divide(array,0,array.length-1);

    }
    private void divide(int[] array,int leftIdx,int rightBorder){
        if(leftIdx>= rightBorder){
            return;
        }
        int mid = (leftIdx + rightBorder)/2;
        divide(array,leftIdx,mid);
        divide(array,mid+1,rightBorder);
        merge(array,leftIdx,mid+1,rightBorder);
    }
    private void merge(int[] array,int leftIdx,int rightIdx,int rightBorder){
        int[] temp = new int[rightBorder - leftIdx +1];
        int i = leftIdx;
        int j = rightIdx;
        int k = 0;
        while(i<rightIdx && j<=rightBorder){
            if(array[i] <= array[j]){
                temp[k] = array[i];
                i++;
            }else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }
        while (i<rightIdx){
            temp[k] = array[i];
            k++;
            i++;
        }
        while (j <= rightBorder){
            temp[k] = array[j];
            k++;
            j++;
        }
        for (int m = 0;m < temp.length;m++){
            array[leftIdx+m] = temp[m];
        }
    }

    public void sort6(int[] array){//快速排序
        if(array.length<2){
            return;
        }
        divideQuickSort(array,0,array.length-1);
    }
    public void divideQuickSort(int[] array,int left,int rightBorder){
        if(left < rightBorder){
            int divide_idx = partition(array,left,rightBorder);
            divideQuickSort(array,left,divide_idx-1);
            divideQuickSort(array,divide_idx+1,rightBorder);
        }
    }
    public int partition(int[] array,int left,int rightBorder){
        int ref = left;
        int index = ref+1;
        for (int i = index;i<rightBorder;i++){
            if(array[i] < array[ref]){
                swapArray(array,i,index);
                index++;
            }
        }
        swapArray(array,ref,index-1);
        return index-1;
    }
    public void sort7(int[] array){//计数排序
        if(array.length<2){
            return;
        }
        int [] minAndMax  = calMinAndMax(array);
        int min = minAndMax[0],max = minAndMax[1];
        int[] negative = null,positive = null;
        if(min < 0){
            negative = new int[-min + 1];
        }
        if(max >=0){
            positive = new int[max +1];
        }
        for(int num:array){
            if(num >= 0 && positive!= null){
                positive[num] ++;
            }else if(num <0 && negative!= null){
                negative[-num]++;
            }
        }
        int index = 0;
        if(negative != null){
            for(int i = negative.length-1;i>0;i--){
                while(negative[i] >0){
                    array[index++] = -i;
                    negative[i]--;
                }
            }
        }
        if(positive != null){
            for(int i = 0;i<positive.length;i++){
                while(positive[i] >0){
                    array[index++] = i;
                    positive[i]--;
                }
            }
        }
    }
    private int[] calMinAndMax(int[] array){
        int [] minAndMax = {array[0],array[0]};
        for(int i = 0;i<array.length;i++){
            if(array[i]<minAndMax[0]){
                minAndMax[0] = array[i];
            }else if(array[i]>minAndMax[1]){
                minAndMax[1] = array[i];
            }
        }
        return minAndMax;

    }

    public void sort8(int[] array) {//基数排序
        if(array.length<2){
            return;
        }
    }

    public static void main(String[] args) {
//        int [] a = new int[]{1,5,8,4,5,2,6,4,0,9,6};
////        int [] a = new int[9];
//        ClassicalSortAlgorithms function = new ClassicalSortAlgorithms();
//        function.sort7(a);
//        for(int i= 0;i<a.length;i++){
//            System.out.print(a[i]+" ");
//        }
        System.out.println((56%10)/1 + 10);

    }

}
