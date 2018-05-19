package 算法类.剑指offer;

/**
 题目要求：
 判断一个字符串是否表示数值，如+100,5e2，-123，-1E-16都是，12e，1e3.14，+-5,1.2.3,12e+5.4都不是。
 提示：表示数值的字符串遵循模式A[.[B]][e|EC] 或者 .B[e|EC];A,B,C表示整数，|表示或。[]表示可有可无。
 */
public class 题20表示数值的字符串 {
	
	
	private static boolean isNumeric(String string) {
		
		
		
		return false;
	}
	
	
	public static void main(String[] args){
        System.out.println(isNumeric("+100"));//true
        System.out.println(isNumeric("5e2")); //true
        System.out.println(isNumeric("-123"));//true
        System.out.println(isNumeric("3.1416"));//true
        System.out.println(isNumeric("-1E-16"));//true
        System.out.println(isNumeric(".6"));//true
        System.out.println(isNumeric("6."));//true
        System.out.println(isNumeric("12e"));//false
        System.out.println(isNumeric("1a3.14"));//false
        System.out.println(isNumeric("1.2.3"));//false
        System.out.println(isNumeric("+-5"));//false
        System.out.println(isNumeric("12e+5.4"));//false
    }

	
}
