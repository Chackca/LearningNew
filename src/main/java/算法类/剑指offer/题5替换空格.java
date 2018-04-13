package 算法类.剑指offer;

public class 题5替换空格 {
	/*
	 * java解决
	 */
	private static String replaceBlank(String data) {
		if (data == null ) return null;
		int length = data.length();
		StringBuilder SB = new StringBuilder();
		
		for (int i = 0; i < length; i++) {
			if (data.charAt(i)==' ') {
				SB.append("%20");
			}else {
				SB.append(data.charAt(i));
			}
		}
		return SB.toString();
	}
	
	/*
	 * c语言字符串解决：指针方法
	 */
	private static char[] replaceBlank2(String data) {
		if (data == null ) return null;
		
		int length = data.length()-1;//需要扩展的数组长度
		char[] cha = data.toCharArray();//将字符串转换为字符数组
		for (int i = 0; i < data.length(); i++) {//检测字符串中的空格数量
			if (data.charAt(i)==' ') length=length+2;
		}
		//创建一个用于容纳更改后字符串的数组
		char[] charData = new char[length+1];
		
		for (int i = cha.length-1; i >= 0; i--) {
			if (cha[i]==' ') {
				charData[length]='0';
				charData[length-1]='2';
				charData[length-2]='%';
				length = length - 3;
			}else {
				charData[length]=cha[i];
				length--;
			}
		}
		
		//System.out.println(charData);
		
		return charData;
	}
	
	public static void main(String[] args){
		String data= new String("We are happy");
		
        System.out.println("原始字符串："+data);       
        System.out.println("Java方法更改后："+replaceBlank(data));
        System.out.print("C语言方法更改后：");
        System.out.println(replaceBlank2(data));
    }

	
}
