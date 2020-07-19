package jianzhi_offer;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1 {

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int [][] array) {

        if(array.length >0){
            for(int i=0; i < array.length; i++){
                for(int j=0; j < array.length; j++){
                    if(target >= array[i][0]){
                        if(target == array[i][j]){
                            return true;
                        }
                    }else{
                        return false;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {

        for(int i=0;i < str.length();i++){
            if(str.substring(i,i+1).equals(" ")){
                str.replace(i,i+1,"%20");
            }
        }
        String result = str.toString();
        return result;
    }



    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }

}



