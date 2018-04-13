package 算法类.动态规划;
/*
 *	题目要求：
	给你一根长度为n的绳子，请把绳子剪成m段，
	记每段绳子长度为k[0],k[1]...k[m-1],求k[0]k[1]...k[m-1]的最大值。
	已知绳子长度n为整数，m>1(至少要剪一刀，不能不剪)，k[0],k[1]...k[m-1]均要求为整数。
	例如，绳子长度为8时，把它剪成3-3-2，得到最大乘积18；绳子长度为3时，把它剪成2-1，得到最大乘积2。

 */
public class 题14剪绳子 {
	
	/*
	 * 动态规划
	 */
	private static int maxCutting(int length) {
		if (length < 2 ) return 0;
		if (length == 2 ) return 1;
		if (length == 3 ) return 2;
		//该数组用于存储子问题的最优解
		int products[] = new int[length+1];
		products[0]=0;
		products[1]=1;
		products[2]=2;
		products[3]=3;
		//product[n]=product[i]*product[n-i];i<=n/2
		int max = 0 ;
		for (int i = 4; i <= length; i++) {
			max = 0;
			//遍历products里面的值，找到两个乘积最大的
			for (int j = 1; j <= i/2; j++) {
				int product = products[j]*products[i-j];
				if (product>max) max = product;
				products[i] = max;
			}
		}
		max = products[length];
		
		return max;
	}

	/*
	 * 贪婪算法
	 */
	private static int maxCutting2(int length) {
		if (length < 2 ) return 0;
		if (length == 2 ) return 1;
		if (length == 3 ) return 2;
		
		int timesOf3 = length/3;
		int result = 0;
		//比如原数是5，变成2*3
		if (length-timesOf3*3 == 2) {
			result = (int) Math.pow(3, timesOf3) * 2;
		}
		//比如原数是6，无需剩余
		if (length-timesOf3*3 == 0) {
			result = (int) Math.pow(3, timesOf3);
		}
		//比如原数是7,余下4变成2*2
		if (length-timesOf3*3 == 1) {
			result = (int) Math.pow(3, timesOf3-1)*2*2;
		}
		
		return result;
	}
	
	
	
	public static void main(String[] args){
        for(int i=2;i<15;i++){
            System.out.println("动态规划：长度为"+i+"的最大值->"+maxCutting(i));
			System.out.println("贪婪算法：长度为"+i+"的最大值->"+maxCutting2(i));
        }

    }

	
}
	
