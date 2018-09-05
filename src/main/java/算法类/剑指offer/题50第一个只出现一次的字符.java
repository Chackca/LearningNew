package 算法类.剑指offer;

/**
 * 题目要求：
 * 字符串中第一个只出现一次的字符。在字符串中找出第一个只出现一次的字符。如输入abaccdeff，则输出b。
 *
 * 解题思路：
 * 思路1：暴力求解，从前到后依次判断每个字符是否只出现一次，时间复杂度o(n^2)，空间复杂度o(1)；
 * 思路2：用空间换时间。这个思路可行的前提是题目中所说的“字符”指的是ascii编码的字符。
 * 0-127是7位ASCII码的范围，是国际标准。128-255称为扩展ASCII码，不是国际标准。
 * 在C++中，char是1字节（8bit），能表示256个不同的字符。而java中，char是unicode编码，
 * 2字节（16bit）。但本题中，假设所有字符都可用ascii表示（0-255）。
 * 在上述假设下，可以申请一个长度为256的int数组作为哈希表，占用空间1kB，
 * 用它来记录字符出现的次数。第一扫描字符串，修改对应字符的次数；第二遍扫描，当遇到在数组中对应值为1的字符，即得到所求，时间复杂度o(n)。
 */
public class 题50第一个只出现一次的字符 {
	//第一个只出现一次的字符
	private static char firstNotRepeatingChar(String string) {
		
		if (string==null ||string.trim().length()==0) {
			return '\77';
		}
		int[] times = new int[256];
        for(int i=0;i<string.length();i++)
            times[string.charAt(i)]++;
        
        for(int i=0;i<string.length();i++){
            if(times[string.charAt(i)]==1)
                return string.charAt(i);
        }
		
		return '\77';
	}

	
	public static void main(String[] args) {
		//第一题
		System.out.println(firstNotRepeatingChar("a021baccbdeff"));
		
		//第二题，字符流中第一个只出现一次的字符
		String str = "google";
        CharStatistics charStatistics = new CharStatistics();
        for(int i=0;i<str.length();i++){
            charStatistics.insert(str.charAt(i));
            System.out.print(charStatistics.find());
        }
	}
	//字符流中第一个只出现一次的字符
	public static class CharStatistics{
        private int[] times;
        private int index;
        public CharStatistics(){
            index = 0;
            times = new int[256];
            //-1表示未出现，>=0表示出现的位置且仅出现一次，-2表示出现两次及以上
            for(int i=0;i<256;i++)
                times[i] = -1;
        }
        public void insert(char ch){
            if(times[ch]==-1)
                times[ch] = index;
            else
                times[ch] = -2;
            index++;
        }
        public char find(){
            int minIndex = 256;
            char ret = '\77'; //若没有只出现一次的字符，显示\77，即？
            for(int i=0;i<256;i++){
                if(times[i]>=0 && times[i]<minIndex) {
                    minIndex = times[i];
                    ret = (char)i;
                }
            }
            return ret;
        }
    }
}
