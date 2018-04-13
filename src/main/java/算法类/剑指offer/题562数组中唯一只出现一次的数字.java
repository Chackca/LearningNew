package 算法类.剑指offer;

public class 题562数组中唯一只出现一次的数字 {
	
	private static int findNumsAppearOnce(int[] data) {
		if (data==null||data.length<4) {
			return 0;
		}
		StringBuilder SB = new StringBuilder();
		int times[] = new int[32];
		for(int i=0;i<data.length;i++){  //SB=10010
			SB.append(Integer.toBinaryString(data[i]));
			//统计string字符中1的个数，并把每个1出现的位置索引对应times数组中加1
			for (int j =0 ; j < SB.length(); j++) {
				//char charAt = SB.charAt(j);
				if (SB.charAt(SB.length()-j-1)=='1') {
					times[j]++;
				}
				//SB.deleteCharAt(j);
			}
			SB.delete(0, SB.length());
		}
		int result = 0;
		for(int i = 0;i<times.length;i++){
			if (times[i]%3!=0) {
				result += (int) Math.pow(2, i);
			}
		}
		
		return result;
	}
	
	
	
	
	
	public static void main(String[] args){
        int[] data = new int[]{2,2,2,4,4,4,8,1,1,1,8,8,6};
        int result = findNumsAppearOnce(data); // 6
        System.out.println(result);
        
    }
	
}
