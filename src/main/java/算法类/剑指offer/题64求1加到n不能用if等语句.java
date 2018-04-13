package 算法类.剑指offer;

public class 题64求1加到n不能用if等语句 {
	
	
	
	public static int getSum(int num){
        int n = 0;
        boolean b = (num>0)&&((n=num+getSum(num-1))>0);
        return n;
    }
	
	
	
    public static void main(String[] args){
        System.out.println(getSum(10));
    }
}