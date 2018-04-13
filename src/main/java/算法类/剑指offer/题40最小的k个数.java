package 算法类.剑指offer;

/*
 *  题目要求：
	找出n个整数中最小的k个数。例如输入4,5,1,6,2,7,3,8，则最小的4个数字是1,2,3,4。
 */
public class 题40最小的k个数 {
	
	//选择排序,时间复杂度o(N*k),适合k较小的情况
    public static int getLeastNumbers1(int[] data,int k){
        if(data==null||data.length==0||k>data.length)
            return 0;
        for(int i=0;i<k;i++){
            int minIndex = i;
            for(int j=i+1;j<data.length;j++){
                if(data[j]<data[minIndex])
                    minIndex = j;
            }
            if(minIndex!=i){
                int temp = data[minIndex];
                data[minIndex] = data[i];
                data[i] = temp;
            }
        }
        //第k小，也就是排序后下标为k-1的元素。
        return data[k-1];
    }

    //使用分区函数解决，时间复杂度o(n)(不确定),会修改原数组
    public static int getLeastNumbers2(int[] data,int k){
        if(data==null || data.length==0 || k>data.length)
            return 0;
        int left=0,right=data.length-1;
        int index = partition(data,left,right);
        while(index!=k-1){
            if(index<k-1)
                index = partition(data,index+1,right);
            else
                index = partition(data,left,index-1);
        }
        return data[k-1];
    }
    public static int partition(int[] data,int left,int right){
        int pivot = data[left];
        while(left<right){
            while (left<right && data[right]>=pivot)
                right--;
            if(left<right)
                data[left] = data[right];
            while (left<right && data[left]<pivot)
                left++;
            if(left<right)
                data[right] = data[left];
        }
        data[left] = pivot;
        return left;
    }

	
	public static void main(String[] args){
        int[] data1 = {6,1,3,5,4,2};
        System.out.println(getLeastNumbers1(data1,5));
        int[] data2 = {6,1,3,5,4,2};
        System.out.println(getLeastNumbers2(data2,5));
        int[] data3 = {6,1,3,5,4,2};
        //System.out.println(getLeastNumbers3(data3,5));
    }
}
