package 算法类.剑指offer;

public class 题60n个骰子的点数 {

	private final static int maxValue=6;
	//采用递归实现
	private static void printProbability2(int num) {
		if (num<=0) return;
		int maxSum = num*maxValue;
		int[] Probabilities = new int[maxSum-num+1];
		Probability(num,Probabilities);
		int total = (int)Math.pow(maxValue, num);
		for (int i = num; i < maxSum; i++) {
			double ratio = (double)Probabilities[i-num]/total;
			System.out.println(ratio);
		}
	}
    private static void Probability(int num, int[] probabilities) {
    	for (int i = 1; i <= maxValue; i++) {
    		//总骰子数，当前骰子，当前累加值，存储的数组引用
    		Probability(num,num,i,probabilities);
		}
	}
	private static void Probability(int oriental, int current, int sum, int[] probabilities) {
		if (current == 1) {
			probabilities[sum-oriental]++;
		}else {
			for (int i = 1; i <= maxValue; i++) {
				Probability(oriental,current-1,sum+i,probabilities);
			}
		}	
	}



	public static void printProbability(int number){
        if(number<=0)
            return;
        //创建一个二维数组，行数为2，列数为  6*number+1
        int result[][] = new int[2][6*number+1];
        
        //将二维数组的第二行1~6设置为1，，作为第一次循环
        for(int i=1;i<=6;i++)
            result[1][i] = 1;
        
        
        for (int current = 2; current <= number; current++) {
			for (int i = current; i < current*maxValue+1; i++) {
				for (int j = i-maxValue; j < i; j++) {
					if (j>0) {
						result[current%2][i] += result[(current-1)%2][j];
					}
				}
			}
		}
        
        
        //num表示当前是第num个骰子，number是骰子总数，依次遍历
        /*for (int num=2;num<=number;num++){
        	//初始i=num，遍历6*num次
            for(int i=num;i<6*num+1;i++){
            	
                for(int j=i-6;j<i;j++)
                    if(j>0)
                    	result[num%2][i] += result[(num-1)%2][j];
            }
        }*/
        
        double sum = 0;
        
        for(int i=number;i<6*number+1;i++)
            sum += result[number%2][i];
        
        System.out.println("number = "+number);
        
        for(int i=number;i<6*number+1;i++)
            System.out.println("probability "+i+":"+result[number%2][i]/sum);
    }
    public static void main(String[] args){
        printProbability(2); //2~12
        System.out.println();
        //printProbability2(2); //2~12
        System.out.println();
        printProbability(0); //return
        System.out.println();
        printProbability(5);//11~66
        System.out.println();
        //printProbability2(5);//11~66
    }
	
}
