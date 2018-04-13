package 算法类.剑指offer;

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
		System.out.println(firstNotRepeatingChar("abaccbdeff"));
		
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
