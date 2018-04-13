package 算法类.进制转换;

import java.util.Scanner;

/*
 * 该进制能转换10进制以下的数与16进制数
 */
public class NumberConversionUtil {
	
	//其他进制转换为十进制，参数一：之前的进制，参数二：要转换的数值，返回值：转换后的十进制数
	public static int NumberToTen(int beforeConversion, String number){
		if (number ==null ) return -1;
		double result = 0;//声明转换后的数值
		String subString ;
		for (int i = 0; i < number.length(); i++) {//根据字符串的长度循环获得单个元素
			subString = number.substring(i,i+1);//将字符创按循环截取
			if (beforeConversion == 16) {//判断是否是十六进制
				subString = sixteenCharToNumber(subString);
			}
			result = Integer.parseInt(subString)//返回转换的结果
					* Math.pow(beforeConversion, beforeConversion-i-1);
		}
		return (int)result;
		
	}
	
	//十进制转换为其他进制，参数一：转换后的进制，参数二：要转换的数值，返回值：转换后的值
	public static String TenToNumber(int afterConversion,String number) {
		int current = Integer.parseInt(number);
		if (number ==null ) return "-1";
		String opResult = "";
		if (afterConversion == 16 ) {
			while (current>=afterConversion) {
				opResult += sixteenNumberToChar(current%afterConversion);
				current /= afterConversion;
			}
			if (current!=0) 
				opResult += sixteenNumberToChar(current);
		}else{
			while(current>=afterConversion){//判断传入的值是否大于转换后的数制
				opResult+=current%afterConversion;
				current/=afterConversion;
			}
			if(current!=0)opResult+=current;//最终余数
	    }
	    String riResult = "";//倒序二进制字符串
	    for(int i=opResult.length()-1;i>=0;i--){//根据二进制的转换方式进行循环输出
	    	riResult = riResult + opResult.substring(i,i+1);
	    }
	    return riResult;
	}
	
	
	//十六进制字母对应数字
	private static String sixteenCharToNumber(String s) {
		String num="";
		if(s.equals("A") || s.equals("a"))
			num="10";
		else if(s.equals("B") || s.equals("b"))
			num="11";
		else if(s.equals("C") || s.equals("c"))
			num="12";
		else if(s.equals("D") || s.equals("d"))
			num="13";
		else if(s.equals("E") || s.equals("E"))
			num="14";
		else if(s.equals("F") || s.equals("f"))
			num="15";
		else
			num=s;
		return num;
	}
	
	//将数字转换为十六进制
	private static String sixteenNumberToChar(int num){//十六进制数字对应字母
		String c="";
		if(num==10) c="A";
		else if(num==11) c="B";
		else if(num==12) c="C";
		else if(num==13) c="D";
		else if(num==14) c="E";
		else if(num==15) c="F";
		else c=String.valueOf(num);
		return c;
	}
	
	
	
	
	public static void main(String []args){//java程序的主入口处
		String number;//要转换的数
		int beforeConversion,afterConversion;//转换前的数制，转换后的数制
		String result="";//经过数制转换后的结果
		String stop="";
		Scanner read=new Scanner(System.in);//得到用户输入的值

		do{
			System.out.println("请输入三个参数（整数）：待转换的数据   转换前的数制  转换后的数制");
			number=read.next();
			beforeConversion=read.nextInt();
			afterConversion=read.nextInt();
			stop="Q";
		}
		while(stop!="Q");//跳出循环
		try {
			if(beforeConversion!=10){//判断转换前的数制是否是十进制
				String temp=String.valueOf(NumberToTen(beforeConversion,number));//获得转换成十进制的数
				result=String.valueOf(TenToNumber(afterConversion, temp));//十进制转换成其它进制
			}else{
				result=String.valueOf(TenToNumber(afterConversion, number));//十进制转换成其它进制
			}
			System.out.println(beforeConversion+"进制的数:"+number+",转换成"+afterConversion+"进制的数为："+result);
		} catch (Exception e) {
			System.out.print("转换失败，请输入合法数据！");
			System.exit(-1);//所有程序（方法，类等）停止，系统停止运行
		}
	}
}

