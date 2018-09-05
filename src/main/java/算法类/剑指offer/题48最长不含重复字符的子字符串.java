package 算法类.剑指offer;

import java.util.Arrays;

/**
 * 题目要求：
 * 输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。例如对于arabcacfr，
 * 最长不含重复字符的子字符串为acfr，长度为4。
 *
 * 解题思路：
 * 动态规划。用dp[]记录状态，dp[i]表示以下标为i的字符结尾不包含重复字符的最长子字符串长度。
 * 初始化dp[0] = 1，求maxdp。每次可以根据dp的前一个状态推导出后一个状态，因此可以省略dp数组，
 * 使用一个变量记录dp值，使用maxdp记录最大的dp值。用一个position数组存储每一个字符串最后一次出现的index

 */
public class 题48最长不含重复字符的子字符串 {
	private static int longestSubstringWithoutDup(String string) {
		//0.判断输入是否正确
		if(string == null || string.trim().length()==0)
			return 0;
		int curLength = 0;
		int maxLength = 0;		
		//1.定义一个长度为26的数组，初始化其值都为0，用于存储每一个最近出现的字母的索引
		int[] position = new int[26];
		//int maxStrLeftIndex = 0;
		//int maxStrRightIndex = 0;
		Arrays.fill(position,-1);
		//2.遍历字符串，进行一系列判断
		for(int i =0 ; i<string.length() ; i++){
			//将当前遍历到的字符串的值存储到position数组中
			int preIndex = position[string.charAt(i)-'a'];
			//判断当前的值是否在之前出现过，判断当前的值与之前出现过的值的差是否大于当前的最长子字符串
			if(preIndex < 0 || i-preIndex>curLength)//没有出现过 || 当前索引-之前出现的索引 > 当前遍历的长度
				curLength++;
			else{//当前出现的值在当前的最长子数组中也有出现
				if(curLength>maxLength) {
					maxLength = curLength;
					//maxStrLeftIndex = i-curLength;
					//maxStrRightIndex = i;
				}
				curLength=i-preIndex;
			}
			//将当前遍历到的值更新到position数组中
			position[string.charAt(i) - 'a']=i;
		}
		if(curLength>maxLength) {
			maxLength = curLength;
			//maxStrLeftIndex = string.length()-curLength;
			//maxStrRightIndex = string.length();
		}
		//System.out.println(string.substring(maxStrLeftIndex,maxStrRightIndex));
		return maxLength;
	}
	
	
	
	public static void main(String[] args){
		//System.out.println(new String("aaa").valueOf(false));

		System.out.println(longestSubstringWithoutDup("arabcacfr"));
		System.out.println(longestSubstringWithoutDup("abcdefaaa"));
		System.out.println(longestSubstringWithoutDup("qwertyuioasdfghjkxcvbnujmyhntgbrfvedc"));
		System.out.println(longestSubstringWithoutDup("abcdcbaef"));

        
        
        /*String string=new String(" ");
        System.out.println(string==null);
        System.out.println(string.equals(""));
        System.out.println(string.length() == 0);
        System.out.println(string.length() == 1);
        System.out.println(string.trim().length() == 0 );
        System.out.println(string.trim().length() == 1 );*/


    }
	
}
