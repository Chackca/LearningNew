package 算法类.剑指offer;

/*
 * 	题目要求：
	比如输入2，打印1,2......98,99；
	解题思路：此题需要考虑大数问题。
 */
public class 题17打印从1到最大的n位数 {

	//直接的解法，没有考虑到大数，并且每一次都要判断当前数是否已经到达目标值
	private static void print1ToMaxOfNDigits(int n) {	
		if (n<=0) return;
		
		int number = 1;
		while (n!=0) {
			number = number*10;
			n--;
		}
		for (int i = 1; i < number; i++) {
			System.out.println(i);
		}
	}
	
	//采用字符串的解法，考虑到大数
	private static void print1ToMaxOfNDigits1(int n) {	
		if (n<=0) return;
		StringBuilder SB= new StringBuilder();
		for (int i = 0; i < n; i++) {
			SB.append(0);
		}
		
		while (!Increment(SB)) { //判断没有进位
			//在SB中默认分配了n个长度的空间，如果直接sysout会打印出前面为0的字符
			//所以需要定一个函数自己控制下
			printNumber(SB);
		}
		
		//System.out.println(SB.toString());

	}
	
	//自增SB内部的数，并判断为SB分配的n位是否已不够
	private static boolean Increment(StringBuilder SB) {
		boolean isOverFlow = false;
		int length = SB.length();
		
		for (int i = length-1; i >= 0; i--) {	
			if ( SB.charAt(i)<'9'&&SB.charAt(i)>='0') {
				SB.setCharAt(i,(char) (SB.charAt(i)+1));
				return isOverFlow;
			}else if( SB.charAt(i)=='9'){
				SB.setCharAt(i,'0');
				//SB.setCharAt(i-1, (char) (SB.charAt(i-1)+1));
			}else {
				isOverFlow = true;
				return isOverFlow;
			}
		}
		
		isOverFlow=true;
		
		return isOverFlow;
	}
	
	private static void printNumber(StringBuilder SB) {
		//boolean flag = false;
		for (int i = 0; i < SB.length(); i++) {
			if(SB.charAt(i)=='0') 
				continue;
			else  {
				//String string=SB.substring(i, SB.length());
				System.out.println(SB.substring(i, SB.length()));
				break;
			}
		}
		
	}

	

	public static void main(String[] args){
		//print1ToMaxOfNDigits(2);
		print1ToMaxOfNDigits1(2);
	}

	
}
