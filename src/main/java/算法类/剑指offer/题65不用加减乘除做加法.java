package 算法类.剑指offer;

public class 题65不用加减乘除做加法 {
	public static int add(int a,int b){
        int sum = a^b;
        int carry = (a&b)<<1;
        int temp;
        while (carry!=0){
            temp = sum;
            sum = sum^carry;
            carry = (carry&temp)<<1;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(add(3,5)); //8
        System.out.println(add(3,-5)); //-2
        System.out.println(add(0,1));  //1
    }

}
