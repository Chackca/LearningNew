package 算法类.剑指offer;

public class 题572和为s的连续正数序列 {
	
	private static void findContinuousSequence(int target) {
		if (target<=0) {
			return;
		}

		int start = 1;
		int end = 2;
				
		while (target/2>=end) {
			int headAndEnd = start+end;
			int number = end-start+1;
			int all = (headAndEnd*number)/2;
			if (all<target) {
				end++;
			}else if (all>target) {
				start++;
			}
			if (all==target) {
				for (int i = start; i <= end; i++) {
					System.out.println(i);
				}
				end++;
				System.out.println();
			}
		}
	}
	
	
	 public static void main(String[] args){
	      findContinuousSequence(15);
	 }

}
