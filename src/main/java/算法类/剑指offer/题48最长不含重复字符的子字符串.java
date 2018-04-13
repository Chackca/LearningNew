package 算法类.剑指offer;

public class 题48最长不含重复字符的子字符串 {
	
	
	private static int longestSubstringWithoutDup(String string) {
		//0.判断输入是否正确
		if(string == null || string.trim().length()==0)
			return 0;
		int curLength = 0;
		int maxLength = 0;		
		//1.定义一个长度为26的数组，初始化其值都为0，用于存储每一个最近出现的字母的索引
		int[] position = new int[26];
		for(int i=0;i<position.length;i++)
			position[i] = -1;
		
		//2.遍历字符串，进行一系列判断
		for(int i =0 ; i<string.length() ; i++){
			//将当前遍历到的字符串的值存储到position数组中
			int preIndex = position[string.charAt(i)-'a'];
			//判断当前的值是否在之前出现过，判断当前的值与之前出现过的值的差是否大于当前的最长子字符串
			if(preIndex < 0 || i-preIndex>curLength)
				curLength++;
			else{//当前出现的值在当前的最长子数组中也有出现
				if(curLength>maxLength)
					maxLength=curLength;
				curLength=i-preIndex;
			}
			//将当前遍历到的值更新到position数组中
			position[string.charAt(i) - 'a']=i;
		}
		if(curLength>maxLength)
			maxLength=curLength;
		return maxLength;
	}
	
	
	
	public static void main(String[] args){
		//System.out.println(new String("aaa").valueOf(false));
		
		
        System.out.println(longestSubstringWithoutDup("arabcacfr"));
        System.out.println(longestSubstringWithoutDup("abcdefaaa"));
        
        
        /*String string=new String(" ");
        System.out.println(string==null);
        System.out.println(string.equals(""));
        System.out.println(string.length() == 0);
        System.out.println(string.length() == 1);
        System.out.println(string.trim().length() == 0 );
        System.out.println(string.trim().length() == 1 );*/


    }
	
}
