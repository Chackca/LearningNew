package 算法类.剑指offer;

public class 题61扑克牌中的顺子 {
	
	private static boolean isContinous(int[] data) {
		if (data.length!=5 ||data==null) {
			return false;
		}
		//对数组进行排序
		int[] table = new int[14];
        for(int i=0;i<data.length;i++){
            if(data[i]>13||data[i]<0)
                return false;
            table[data[i]]++;
        }
       
		//统计数组中0的数量
        int numOfZero = 0;
        while (table[0]!=0){
        	table[0]--;
        	numOfZero++;
        }
        
		//统计排序后的数组中相邻数字之间的空缺总数
        int start = 1;
        while (table[start]==0)
            start++;//记录第一个出现非0数字的位置
        
        int king = 0;
        for(int i=start;i<start+5;i++){
            if(i>13)
                break;
            if (table[i]==0) {
            	king++;//统计出现的空缺
			}
        }
        if (king<=numOfZero) {
        	return true;
		}
		
		return false;
	}
	
	
	
	public static void main(String[] args){
        int[] data1 = new int[]{4,2,7,12,1}; //false
        int[] data2 = new int[]{0,5,6,12,0}; //false
        int[] data3 = new int[]{6,5,8,7,4};  //true
        int[] data4 = new int[]{0,5,6,9,8};  //true
        int[] data5 = new int[]{0,13,0,12,0}; //true
        System.out.println(isContinous(data1));
        System.out.println(isContinous(data2));
        System.out.println(isContinous(data3));
        System.out.println(isContinous(data4));
        System.out.println(isContinous(data5));
    }

	
}
