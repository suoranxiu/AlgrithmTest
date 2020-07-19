package LeetCodeHot100.BinarySearch;

public class Solution29 {
    /**
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     *
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     *
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * 示例 1:
     *
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     *
     * 示例 2:
     *
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     *
     * 提示：
     *
     *     被除数和除数均为 32 位有符号整数。
     *     除数不为 0。
     *     假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
     */
    public static int divide(int dividend, int divisor) {//二分查找
        if(dividend == 0){
            return 0;
        }
        if(divisor == 1){
            return  dividend;
        }
        if(divisor == -1){
            if(dividend > Integer.MIN_VALUE){
                return -dividend;
            }else {
                return Integer.MAX_VALUE;
            }
        }
        boolean neg = false;
        if((dividend<0||divisor<0)&&!(dividend<0&&divisor<0)){
            neg = true;
        }
        long i = 0;
        long tmp1= dividend;
        long tmp2 = divisor;
        tmp1 = tmp1>0? tmp1:-tmp1;
        tmp2 = tmp2>0? tmp2:-tmp2;
        while(tmp1 >= tmp2){
            tmp1 =tmp1-tmp2;
            i++;
        }

        i = i>Integer.MAX_VALUE?Integer.MAX_VALUE:i;
        if (neg){
            return -(int) i;
        }else {
            return (int)i;
        }

    }

    public static void main(String[] args) {
        System.out.println(Solution29.divide(10,3));;
    }
}
