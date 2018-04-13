package 算法类.剑指offer;

public class 题561数组中只出现一次的两个数字 {
	
	public static int[] findNumsAppearOnce(int[] data){
        int result = 0;
        for(int i=0;i<data.length;i++)
            result^=data[i];
        int indexOf1 = findFirstBit1(result);
        
        int ret[] = new int[]{0,0};
        int temp = 0;
        if(indexOf1<0)
            return ret;
        for(int i=0;i<data.length;i++){
        	//if((data[i]&indexOf1)==0)
        	temp = data[i];
        	if(((temp>>>indexOf1)&1)==0)
                ret[0]^=data[i];
            else
                ret[1]^=data[i];
        }
        return ret;
    }
	
    public static int findFirstBit1(int num){
        if(num<0)
            return -1;
        int indexOf1 = 0;
        while (num!=0){
            if((num&1)==1)
                return indexOf1;
            else{
                num = num>>1;
                indexOf1++;
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
        int[] data = new int[]{2,4,3,6,3,2,5,5,5,5,1,1,11,12,21,11,12,21,55,4,6,22};
        int[] result = findNumsAppearOnce(data); // 4,6
        System.out.println(result[0]);
        System.out.println(result[1]);

    }

}
