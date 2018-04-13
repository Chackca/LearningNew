package 算法类.剑指offer;


public class 题16数值的整数次方 {

	private static boolean invalidInput;
	
	private static double power(int base, int exponent) {
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
	public static double powerWithUnsignedExponent(int base, int exponent){
		double result = 1.0;
		for (int i = 1; i <=exponent; i++) {
			result *= base;
		}
		return result;
	}
	
	/*
	 * 递归的计算算法
	 */
	public static double powerWithUnsignedExponentRecursion(int base, int exponent){
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

	

}
