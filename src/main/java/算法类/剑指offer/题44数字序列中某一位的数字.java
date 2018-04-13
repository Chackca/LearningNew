package 算法类.剑指offer;

public class 题44数字序列中某一位的数字 {
	
	private static int digitAtIndex(int num) {
		if (num<=0) return 0;
		int round = 1;
		int sum =0;
		while(num>sum){
			sum += weight(round)*round;
			round++;
		}
		int temp = num-(sum-weight(round-1)*(round-1));
		int chushu = temp/(round-1);
		int yushu = temp%(round-1);
		int result = (int) (Math.pow(10, round-1-1))+chushu;
		return Integer.toString(result).charAt(yushu)-'0';
	}
	
	private static int weight(int round) {
		if (round == 1) {
			return 10;
		}
		int weight = 9;
		for (int i = 2; i <= round; i++) {
			weight *= 10;
		}
		return weight;
	}

	public static void main(String[] args){
        for(int i=9;i<16;i++)
            System.out.println(digitAtIndex(i));
        System.out.println(digitAtIndex(1001));

    }

	
}
