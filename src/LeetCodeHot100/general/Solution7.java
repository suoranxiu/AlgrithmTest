package LeetCodeHot100.general;

import java.math.BigDecimal;

public class Solution7 {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     */
    public static int reverse(int x) {
        Long tmp = Long.valueOf(x);
        boolean flag = tmp>0 ? true:false;
        String str = Long.toString(Math.abs(tmp));
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray =  str.toCharArray();
        for(int i=charArray.length-1; i>=0 ; i--){
            stringBuffer.append(charArray[i]);
        }
        BigDecimal b = new BigDecimal(stringBuffer.toString());
        if(b.compareTo(new BigDecimal(String.valueOf(Integer.MAX_VALUE))) > 0){
            //溢出了
            return 0;
        }
        if(!flag){
            stringBuffer.insert(0,'-');
        }
        return Integer.parseInt(stringBuffer.toString());
    }

    public static void main(String[] args) {
//        int a = -123;
//        System.out.println(Integer.toString(a));
//        System.out.println(Solution7.reverse(-2147483648));
//        char[] c = {'0'};
        System.out.println(Math.abs(Long.valueOf(-2147483648)));
    }
}
