package 算法类.剑指offer;

/*
 * 斐波那契数列
 * f(0)=0,f(1)=1,f(n)=f(n-1)+f(n-2) n>1
 */
public class 题10斐波那契数列 {
	
	/*
	 * 效率很低的递归做法
	 * 介绍递归时的标准写法
	 */
	private static long fibonacci1(int i) {
		
		if (i<=0) return 0;
		
		if (i==1) return 1;
		
		return fibonacci1(i-1)+fibonacci1(i-2);
	}

	/*
	 * 从下往上计算，避免重复运算的方法
	 * 时间复杂度为n
	 */
	private static long fibonacci2(int i) {
		if(i<=0)
            return 0;
        if(i==1)
            return 1;
		
		long fibNMinusOne = 1;//f(n-1)
		long fibNMinusTwo = 0;//f(n-2)
		long fibN = 0;
		
		for (int j = 2; j <= i; j++) {//初始f(2)=f(1)+f(0)
			fibN = fibNMinusTwo + fibNMinusOne; //f(n)=f(n-1)+f(n-2)
			fibNMinusTwo = fibNMinusOne;//
			fibNMinusOne = fibN ;//
		}
		return fibN;
	}
	
	
	
	
	public static void main(String[] args){
        System.out.println(fibonacci1(13));
        System.out.println(fibonacci2(13));
        /*System.out.println(fibonacci3(13));
        System.out.println(fibonacci4(13));*/
    }




	

	
}
