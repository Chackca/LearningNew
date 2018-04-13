package 算法类.剑指offer;
	
/*
 * 	题目要求：
	如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
	输入一个数组，求出这个数组中的逆序对总数。例如输入{7,5,6,4}，
	一共有5个逆序对，分别是（7,6），（7,5），（7,4），（6,4），（5,4）。
	
	解题思路：
	思路1：暴力解决。顺序扫描数组，对于每个元素，与它后面的数字进行比较，
	因此这种思路的时间复杂度为o(n^2)。
	
	思路2：
	上述思路在进行比较后，并没有将相关信息留下，其实在比较之后可以进行局部的排序，
	从而降低比较的次数，降低时间复杂度。
	可通过如下步骤求逆序对个数：先把数组逐步分隔成长度为1的子数组，统计出子数组内部的逆序对个数，
	然后再将相邻两个子数组合并成一个有序数组并统计数组之间的逆序对数目，
	直至合并成一个大的数组。其实，这是二路归并的步骤，只不过在归并的同时要多进行一步统计。
	因此时间复杂度o(nlogn)，空间复杂度o(n)，如果使用原地归并排序，可以将空间复杂度降为o(1)。
 */
public class 题51数组中的逆序对 {
    public static int inversePairs(int[] data){
        if(data==null || data.length<2)
            return 0;
        return mergeSortCore(data, 0, data.length - 1);
    }
    public static int mergeSortCore(int[] data,int start,int end){
        if(start>=end)
            return 0;
        int mid = start+(end-start)/2;
        int left = mergeSortCore(data,start,mid);
        int right = mergeSortCore(data,mid+1,end);
        int count = mergerSortMerge(data,start,mid,end);
        return left+right+count;
    }
    //start~mid, mid+1~end
    public static int mergerSortMerge(int[] data,int start,int mid,int end){
        int[] temp = new int[end-start+1];
        for(int i=0;i<=end-start;i++)
            temp[i] = data[i+start];
        int left = 0,right = mid+1-start,index = start,count = 0;
        while (left<=mid-start && right<=end-start){
            if(temp[left]<=temp[right])
                data[index++] = temp[left++];
            else{
                data[index++] = temp[right++];
                count += (mid-start)-left+1;
            }
        }
        while (left<=mid-start)
            data[index++] = temp[left++];
        while (right<=end-start)
            data[index++] = temp[right++];
        return count;
    }


    public static void main(String[] args){
        System.out.println(inversePairs(new int[]{7,5,6,4}));
        System.out.println(inversePairs(new int[]{5,6,7,8,1,2,3,4}));
        System.out.println(Merge(new int[]{7,5,6,4}));
        System.out.println(Merge(new int[]{5,6,7,8,1,2,3,4}));
    }


    //通过更改归并排序代码自己写的
    public static int Merge(int[] data){
        if (data==null) return -1;
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[data.length];
        return sort(data,0,data.length-1,temp);
    }
    private static int sort(int[] data, int left, int right, int[] temp) {
        if(left<right){
            int mid = left + (right - left)/2;
            int left1 = sort(data,left,mid,temp);//左边归并排序，使得左子序列有序
            int right1 = sort(data,mid+1,right,temp);//右边归并排序，使得右子序列有序
            int count = merge(data,left,mid,right,temp);//将两个有序子数组合并操作
            return left1+right1+count;
        }
        return 0;
    }
    private static int merge(int[] data, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        int count = 0;
        while (i<=mid && j<=right){
            if(data[i]<=data[j]){
                temp[t++] = data[i++];
            }else {
                temp[t++] = data[j++];
                count += mid - i +1;
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = data[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = data[j++];

        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            data[left++] = temp[t++];
        }
        return count ;
    }
}
