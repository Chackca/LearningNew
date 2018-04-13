package 算法类.剑指offer;

public class 题43一至n整数中1出现的次数 {
	
	private static int numberOf1Between1AndN(int num) {
		if (num<=0) {
			return 0;
		}
		int result = 0;
		for (int j = 1; j <= num; j++) {
			result += numOf1(j);
		}
		return result;
	}
	
	private static int numOf1(int num) {
		int count1 = 0;
		while (num!=0) {
			if (num%10==1) {
				count1++;
			}
			num = num/10;			
		}
		return count1;
	}

	/*
	 *  534 = （个位1出现次数）+（十位1出现次数）+（百位1出现次数）=（53*1+1）+（5*10+10）+（0*100+100）= 214
		530 = （53*1）+（5*10+10）+（0*100+100） = 213
		504 = （50*1+1）+（5*10）+（0*100+100） = 201
		514 = （51*1+1）+（5*10+4+1）+（0*100+100） = 207
		10 = (1*1)+(0*10+0+1) = 2
	 */
	private static int numberOf1Between1AndN2(int n) {
		if(n<1)
	       return 0;
	    int count = 0;
	    int base = 1;//权值
	    int round = n;
	    while(round>0){//从个位数开始
	    	int former = n%base;//该位之前的数
	        int weight = round%10;//位值
	        round/=10;
	        count += round*base;
	        if(weight==1)
	            count+=former+1;
	        else if(weight>1)
	            count+=base;
	        base*=10;
	    }
	    return count;
	}

	public static void main(String[] args){
        System.out.println(numberOf1Between1AndN(121));
        System.out.println(numberOf1Between1AndN2(121));
        System.out.println(numberOf1Between1AndN(789));
        System.out.println(numberOf1Between1AndN2(789));

    }

	
	
}
