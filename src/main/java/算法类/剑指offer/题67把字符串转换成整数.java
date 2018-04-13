package 算法类.剑指offer;

public class 题67把字符串转换成整数 {
	
//  atoi的需求是这样的：
//  如果前面有空格，需要剔除空格；
//  剔除空格后，第一个字符串如果是+号，认为是正数；如果是-号，认为是负数；
//  后面的字符如果不是数字，那么返回0，如果是数字，返回实际的数字。遇到不是数字的字符，转换结束。
//  此外，要考虑空串问题，数值溢出问题[2^(-31) ~ 2^31-1]。

	//本程序数值溢出还有问题
	public static int strToInt(String str) throws Exception{
		if (str == null || str.trim().length()==0) {
			throw new Exception("输入为空或者空格字符串");
		}
		//默认为正
		boolean isNegative = false;
		//用于记录第一位是否被符号位占用
		int index = 0; 
		int length = str.trim().length();
		StringBuilder SB = new StringBuilder(str.trim());
		//判断是不是负数
		if (SB.charAt(0)=='-') {isNegative = true; index=1;}
		else if (SB.charAt(0)>='0' && SB.charAt(0)<='9'){}
		else if (SB.charAt(0)=='+'){index=1;}
		else throw new Exception("非法的输入");
		
		int endIndex = index;
		boolean isDecimal = false;
		
		while (endIndex<length && SB.charAt(endIndex)>='0' && SB.charAt(endIndex)<='9') {
			endIndex++;
		}
		
		try{
			if(SB.charAt(endIndex)=='.')
				isDecimal=true;
		}catch (Exception e) {}
		
		int result = 0;
		if (endIndex == length || isDecimal) {
			String MIN_INT = Integer.toString(Integer.MAX_VALUE);
			String MAX_INT = Integer.toString(Integer.MIN_VALUE).substring(1);
			//System.out.println(MIN_INT);
			//System.out.println(MAX_INT);

			String string = SB.substring(index, endIndex);
			//是负数
			if (isNegative&&string.compareTo(MIN_INT)>0) 
				throw new Exception("数值下溢,待转换字符串为-"+string);
			//不是负数
			if (!isNegative&&string.compareTo(MAX_INT)>=0) 
				throw new Exception("数值上溢,待转换字符串为"+string);
			 
			//在这里执行具体的转换逻辑
			result = Integer.parseInt(string);
			
			
			
		}else {
			 throw new Exception("非法的输入");
		}
		
		return isNegative?-result:result;
	}
    
    public static void main(String[] args){
    	try {
            System.out.println(strToInt(" 100")); //100
            System.out.println(strToInt("-100")); //-100
            System.out.println(strToInt("0")); //0
            System.out.println(strToInt("-0"));//0
            System.out.println(strToInt("1.23"));  //1
            System.out.println(strToInt("-1.23")); //-1
        }
        catch (Exception e){
            e.printStackTrace();
        }
    	
    	edgeTest();
    }
    
    
    public static void edgeTest(){
        try {
            System.out.println(strToInt("2147483647"));  //2147483647
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(strToInt("-2147483647")); //-2147483647
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(strToInt("2147483648"));  //上溢
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(strToInt("-2147483648")); //-2147483648
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(strToInt("-2147483649")); //下溢
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(strToInt(null)); //待转换字符串为null或空串
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(strToInt(""));   //待转换字符串为null或空串
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

