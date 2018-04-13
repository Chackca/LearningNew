package 算法类.剑指offer;
/*
 * 题目要求：
	实现一个函数，输入一个int型整数，输出该数字在计算机中二进制表示形式的1的个数。
	例如9->1001,输出2；-3->11111111111111111111111111111101,输出31。
 */
public class 题15二进制中1的个数 {
	
	public static void main(String[] args) {
		 int n = 7;  
	     System.out.println("7的二进制表示中1的个数为：" + numberOf3(n)); 
	     int m = -3;  
	     System.out.println("-3的二进制表示中1的个数为：" + numberOf3(m));  
	}
	
	public static int numberOf3(int n) {  
        int count = 0;  
        //把一个整数减去1之后再和原来的整数做位与运算，
        //得到的结果相当于把原整数的二进制表示形式的最右边的1变成0
        while (n != 0){  
            count++;  
            n = (n - 1) & n;  
        }  
        return count;  
    }  
	//将数字无符号右移，直到为0。
	public static int numberOfOne1(int n){
        int count=0;
        while(n!=0){
            if((n&1)!=0)
                count++;
            n>>>=1;
        }
        return count;
    }
	//使用一个标记，初始为1，让标记值与原输入数字异或，然后标记值左移。
    public static int numberOfOne2(int n){
        int count=0;
        int flag=1;
        while(flag!=0){
            if((n&flag)!=0)
                count++;
            flag<<=1;
        }
        return count;
    }
	
}
