package 算法类.Leetcode.复杂度;

/**
 *  题目一：
 *  Given an array of integers, every element appears twice except for one. Find that single one.
     Note:
     Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

     给定一个整数数组，每个元素都出现两次，除了一个只出现一次。请找到那个出现一次的
     注意:
     您的算法应该具有线性运行时的复杂性。你能在不使用额外内存的情况下实现吗？

    思路：所有元素都异或一下， 最后得出的结果按位取反即为目标数


    题目二：
     Given an array of integers, every element appears three times except for one. Find that single one.
     Note:
     Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


     给定一个整数数组，每个元素都出现三次，除了一个只出现一次。请找到那个出现一次的
     注意:
     您的算法应该具有线性运行时的复杂性。你能在不使用额外内存的情况下实现吗？

     思路：
 */
public class 找到只出现一次的元素 {

    public static class Solution {
        public static int singleNumberForQuestionOne(int[] A) {
            int result = 0;
            for (int i = 0 ; i < A.length ; i++){
                result = result ^ A[i];
            }
            return result;
        }

        public static int singleNumberForQuestionTwo(int[] A) {
            int result=0;
            for(int i=0;i<32;++i){
                int bits=0;
                for(int j=0;j<A.length;++j){
                    bits+=(A[j]>>i)&1;//依次获取元素的每一位，并将数组元素相同位相加
                }
                result|=(bits%3)<<i;
            }
            return result;
        }
        //自己写的，这个方法不支持负数
        /*public static int singleNumberForQuestionTwo(int[] A) {
            if (A == null) return -1;
            int[] array = new int[32];
            String value;
            for (int i = 0 ; i < A.length; i++){
                value = Integer.toBinaryString(A[i]);
                for (int j = 0 ; j <value.length();j++){
                    if (value.charAt(j)=='1'){
                        array[value.length()-1-j]++;
                    }
                }
            }
            String sss = Integer.toBinaryString(-5);
            int result = 0;
            for (int i = 0 ; i < 32 ; i++){
                if (array[i]%3!=0){
                    //result += Math.pow(2,i);
                    array[i] = array[i]%3;
                }else {
                    array[i]=0;
                }
            }

            if (array[31]==1){
                for (int i = 0 ; i < 32 ; i++){
                    array[i] = ~array[i];
                }
            }
            return result;
        }*/
        //牛客写的，这个方法支持负数

    }

    public static void main(String[] args) {

        //在大部分元素出现两次的数组中找到出现一次的数字
        int[] data = new int[]{5,6,7,5,6,8,9,1,2,2,1,8,9,11,11,7,12};//12
        int result = Solution.singleNumberForQuestionOne(data);
        System.out.println(result);

        //在大部分元素出现三次的数组中找到出现一次的数字
        int[] data2 = new int[]{1,1,1,2,2,2,-5};//6
        result = Solution.singleNumberForQuestionTwo(data2);
        System.out.println(result);
    }

}
