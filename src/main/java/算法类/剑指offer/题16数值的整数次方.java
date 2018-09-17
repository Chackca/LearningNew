package 算法类.剑指offer;


public class 题16数值的整数次方 {

	private static boolean invalidInput;

	private static double power(double base, int exponent) {
		//0的0次方不存在，0的正数次方=0
		if (base==0 && exponent>=0) return 0;
			//0的负数次方出错
		else if (base == 0 && exponent < 0)
		{invalidInput=true;return -1;}
		//一个任何数的0次方为1
		else if (exponent == 0) return 1;
		else if (exponent == 1) return base;

		double result = 0;
		int absExponent = exponent;

		if (exponent<0) {
			absExponent = -exponent;
		}

		//result = powerWithUnsignedExponent(base,absExponent);
		result = powerWithUnsignedExponentRecursion(base,absExponent);

		if (exponent<0) {
			result = 1/result;
		}

		return result;

	}

	/*
	 * 普通的计算算法
	 */
	public static double powerWithUnsignedExponent(double base, int exponent){
		double result = 1.0;
		for (int i = 1; i <=exponent; i++) {
			result *= base;
		}
		return result;
	}

	/*
	 * 递归的计算算法
	 */
	public static double powerWithUnsignedExponentRecursion(double base, int exponent){
		if (exponent == 1) {
			return base;
		}if (exponent ==0) {
			return 1;
		}
		double result = powerWithUnsignedExponentRecursion(base,exponent>>1);
		result *= result;
		if ((exponent & 1) == 1) {  //指数为奇数
			result *= base;
		}
		return result;
	}
	
	
	public static void main(String[] args){
        System.out.println("2^3="+power(2,3)+"\t是否报错:"+invalidInput);
        System.out.println("2^-3="+power(2,-3)+"\t是否报错:"+invalidInput);
        System.out.println("0^3="+power(0,3)+"\t是否报错:"+invalidInput);
        System.out.println("0^-3="+power(0,-3)+"\t是否报错:"+invalidInput);
    }

	/**
	 * 1.全面考察指数的正负、底数是否为零等情况。
	 * 2.写出指数的二进制表达，例如13表达为二进制1101。
	 * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
	 * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
	 */
	public double Power(double base, int n) {
		double res = 1,curr = base;
		int exponent;
		if(n>0){
			exponent = n;
		}else if(n<0){
			if(base==0)
				throw new RuntimeException("分母不能为0");
			exponent = -n;
		}else{// n==0
			return 1;// 0的0次方
		}
		while(exponent!=0){
			if((exponent&1)==1)
				res*=curr;
			curr*=curr;// 翻倍
			exponent>>=1;// 右移一位
		}
		return n>=0?res:(1/res);
	}

}
