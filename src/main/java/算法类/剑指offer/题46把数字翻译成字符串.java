package 算法类.剑指offer;
/*
 * 面试题46：把数字翻译成字符串

	题目要求：
	给定一个数字，按照如下规则翻译成字符串：
	0翻译成“a”，1翻译成“b”...25翻译成“z”。一个数字有多种翻译可能，
	例如12258一共有5种，分别是bccfi，bwfi，bczi，mcfi，mzi。
	实现一个函数，用来计算一个数字有多少种不同的翻译方法。
	
	解题思路：
	下面我们从自上而下和自下而上两种角度分析这道题目，以12258为例：

 */
public class 题46把数字翻译成字符串 {
	
	private static int getTranslationCount(int num) {
		if (num<=0) {
			return 0;
		}if (num==1) {
			return 1;
		}
		return getTranslationCount(Integer.toString(num));
	}
	
	
	
	private static int getTranslationCount(String number) {
		int f2 = 1;
		int f1 = 1;
		int g = 0;
		
		int length = number.length();
		for (int i = length-2; i >= 0; i--) {
			if (Integer.parseInt(number.charAt(i)+""+number.charAt(i+1))<26) g=1;
			else g=0;
			
			int temp = f2;
			f2 = f2 + f1*g;
			f1 = temp;
		}
		
		return f2;
	}



	public static void main(String[] args){
        System.out.println(getTranslationCount(-10));  //0
        System.out.println(getTranslationCount(1234));  //3
        System.out.println(getTranslationCount(12258)); //5
        System.out.println(getTranslationCount(12222)); //8

    }

	

}
