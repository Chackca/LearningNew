package 算法类.剑指offer;

/*
 * 	题目要求：
	实现一个函数完成字符串的左旋转功能。比如，输入abcdefg和数字2，输出为cdefgab。
	
	解题思路：
	类似于58.翻转单词顺序。首先对于字符串“abcdefg”整体翻转，得到“gfedcba”；
	然后对于后2个字符“ba”进行翻转，对于剩下的字符“gfedc”进行翻转，得到“cdefgab”。
	
 */
public class 题582左旋转字符串 {
	
	private static String  leftRotateString(String str, int i) {
		if (str == null) return null;
		int start = 0; int end = str.length()-1;
		if (i-1>end) return null;
		
		StringBuilder SB = new StringBuilder(str);
		reverseSubString(SB,0,i-1);
		reverseSubString(SB,i,end);
		reverseSubString(SB,start,end);
		
		return SB.toString();
	}
	
	public static void reverseSubString(StringBuilder stringBuilder,int start,int end){
        for(int i=start;i<=start+(end-start)/2;i++){
            char temp = stringBuilder.charAt(i);
            stringBuilder.setCharAt(i,stringBuilder.charAt(end-(i-start)));
            stringBuilder.setCharAt(end-(i-start),temp);
        }
    }

	public static void main(String[] args){
	     String str = "abcdefg";
	     System.out.println(leftRotateString(str,2));
	}

	
}
