package 算法类.剑指offer;

/**
 * 题目要求：
 * 数字以01234567891011121314...的格式排列。在这个序列中，第5位（从0开始计）是5，第13位是1，第19位是4。求任意第n位对应的数字。
 *
 *
 * 以第15位数字2为例（2隶属于12，两位数，位于12从左侧以0号开始下标为1的位置）
 * 步骤1：首先确定该数字是属于几位数的;
 *       如果是一位数，n<9;如果是两位数，n<9+90*2=189;
 *       说明是两位数。
 * 步骤2：确定该数字属于哪个数。10+(15-10)/2= 12。
 * 步骤3：确定是该数中哪一位。15-10-(12-10)*2 = 1, 所以位于“12”的下标为1的位置，即数字2。
 *
 * 以第1001位数字7为例
 * 步骤1：首先确定该数字是属于几位数的;
 *       如果是一位数，n<9;如果是两位数，n<9+90*2=189;如果是三位数，n<189+900*3=2889;
 *       说明是三位数。
 * 步骤2：确定该数字属于哪个数。100+(1001-190)/3= 370。
 * 步骤3：确定是该数中哪一位。1001-190-(370-100)*3 = 1,所以位于“370”的下标为1的位置，即数字1。
 */
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
