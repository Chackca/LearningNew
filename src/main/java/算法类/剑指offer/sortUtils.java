package 算法类.剑指offer;


import org.junit.Test;

public class sortUtils {
	
	//基数排序
	
	
	
	
	
	
	/*	堆排序：堆排序的基本思想是：将待排序序列构造成一个大顶堆，
		此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，
		此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，
		这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
		一般升序采用大顶堆，降序采用小顶堆
		堆排序由构建初始堆+交换堆顶元素和末尾元素并重建堆   两部分组成
	*/
	public static void heapSort(int[] data){
		if (data==null) return;
		//1.构建初始大顶堆
		//data.length/2-1定位到倒数第一个非叶子结点
		for (int i = data.length/2-1; i >= 0; i--) {
			adjustHeap(data,i,data.length);
		}
		//2.交换堆顶元素和末尾元素并重建堆
		for (int j = data.length-1; j >0; j--) {
			swap(data, 0, j);
			adjustHeap(data,0,j);
		}
	}
	
	//调整堆为最大堆，第二个参数i为需要考虑调整的节点,此处需要传入第三个参数长度，因为最后搭建排序数组的时候参加运算的数组长度会减小
	private static void adjustHeap(int[] data, int i, int length) {
		int temp = data[i];
		for (int j = 2*i+1; j < length; j=2*j+1) {
			//若当前节点的右子节点的值大于左子节点的值，则定位到右子节点
			if (j+1 < length && data[j+1]>data[j]) {
				j++;
			}
			//若当前考虑的节点（子节点）大于其父节点，则将其赋值给父节点，不用进行交换，到退出循环时再交换
			if (data[j]>temp) {
				data[i] = data[j];
				i = j;
			}else {
				break;
			}
		}
		data[i]=temp;
	}

	//堆排序测试
	@Test
	private void heapSortTest(){
        int[] data = {5,4,3,1,5,6,4,5,2,6,10,7,12};
        System.out.println("数组堆排序：\t");
        heapSort(data);
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }



	//桶排序：需要知道数组中的最大与最小值，然后创建一个大小为max-min的新数组，再遍历原数组
	//遍历到每个值则将新数组的那个位置+1
	//此案例需要根据具体要求来，下面代码的鲁棒性并不好
	public static void BucketSort(int[] data){
		if (data==null) return;
		int min = data[0];
		int max = data[0];
		for (int i = 0; i < data.length; i++) {
			if (data[i]>max) {
				max = data[i];
			}else if (data[i]<min) {
				min = data[i];
			}
		}
		//以上步骤只是为了找出最大最小值以便于创建临时数组，非桶排序必须，这里只是因为输入的数组没有规定数组大小范围
		int[] bucket = new int[max-min+1];
		for (int i = 0; i < data.length; i++) {
			bucket[data[i]-min]++;
		}
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i]!=0) {
				for (int j = 0; j < bucket[i]; j++) {
					System.out.print(i+min);
					System.out.print(" ");
				}
			}
		}
		
	}
	//桶排序测试
	@Test
	private void bucketSortTest(){
        int[] data = {5,4,3,1,2,6,10,7,7,4,12};
        System.out.println("数组桶排序：\t");
        BucketSort(data);
        
    }
	
	
	
	
	
	/*
	 * 归并排序
	 * 测试代码
	 *  int[] data = {9,8,7,6,5,4,3,2,1};
        sortUtils.Merge(data);
        System.out.println(Arrays.toString(data));
	 */
	public static void Merge(int[] data){
		if (data==null) return;
		//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
		int[] temp = new int[data.length];
        sort(data,0,data.length-1,temp);
	}
	private static void sort(int[] data, int left, int right, int[] temp) {
		if(left<right){
			int mid = left + (right - left)/2;
			sort(data,left,mid,temp);//左边归并排序，使得左子序列有序
	        sort(data,mid+1,right,temp);//右边归并排序，使得右子序列有序
	        merge(data,left,mid,right,temp);//将两个有序子数组合并操作
		}
	}
	private static void merge(int[] data, int left, int mid, int right, int[] temp) {
		int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(data[i]<=data[j]){
                temp[t++] = data[i++];
            }else {
                temp[t++] = data[j++];
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
	}


	
	/*
	 * 快速排序方式1：选择数组中的第一个数字作为分界进行排序
	 */
	public static void quickSort(int[] data,int start,int end) {
		if (data==null) return;
		if (start>=end) return;
		//获得start元素在原数组中排序后的准确的位置索引
		int index = partition3(data,start,end);
		quickSort(data,start,index-1);
		quickSort(data,index+1,end);
	}
	//作用：根据输入data【】，start与end，返回data[start]在排序数组中准确的位置
	private static int partition(int[] data, int start, int end) {
		if(start>=end)
	          return end;
		//存储目标值
		int target=data[start];
		//start是前面的哨兵，end是后面的哨兵
		while(end>start){
			//右哨兵从当前位置循环找到一个小于目标值的index
			while (end>start&&data[end]>target) 
				end--;
			//执行与左哨兵更换，并让左哨兵走一步
			if (end>start) 
				data[start++] = data[end];
			//左哨兵循环找到一个大于目标值的index
			while(end>start&&data[start]<target)
				start++;
			//左哨兵与右哨兵交换，并让右哨兵向左走一步
			if (end>start) 
				data[end--] = data[start];
		}
		//当执行到这里，start=end
		data[start]=target;
		//System.out.println(start);
		return start;
	}
	//自己写的
	private static int partition3(int[] data, int start, int end) {
		if(start>=end)
	          return end;
		//存储目标值
		int target=data[start];
		//start是前面的哨兵，end是后面的哨兵
		while(end>start){
			//右哨兵从当前位置循环找到一个小于目标值的index
			while (end>start&&data[end]>target) 
				end--;
			//执行与左哨兵更换，并让左哨兵走一步
			if (end>start&&data[end]<target) 
				swap(data, start, end);
			//左哨兵循环找到一个大于目标值的index
			while(end>start&&data[start]<target)
				start++;
			//左哨兵与右哨兵交换，并让右哨兵向左走一步
			if (end>start&&data[start]>target) 
				swap(data, start, end);
		}
		//当执行到这里，start=end
		data[start]=target;
		//System.out.println(start);
		return start;
	}
	//快速排序测试
	@Test
	private void testQuickSort(){
        int[] data = {5,4,3,1,2,6,10,7};
        quickSort(data,0,data.length-1);
        System.out.print("数组快速排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }
	
	
	/*
	 * 快速排序方式2：随机选择数组中的某一个数作为分界放到数组最后进行排序进行排序
	 */
	public static void quickSort2(int[] data,int start,int end) {
		if(data == null || start == end) return;
		//返回start-end区间内的数组的某个数排序后在数组中的实际位置
		int index = partition2(data, start, end);
		if (index>start) 
			quickSort2(data,start,index-1) ;
		if (index<end) 
			quickSort2(data,index+1,end) ;
	}
	
	
	private static int partition2(int[] data, int start, int end) {
		//start<index<end
		int index = start + (int)(Math.random() * ((end - start) + 1));
		//将随机选取的目标数放到数组的最后
		swap(data,index,end);
		//用于记录有多少个小于目标数的数
		int small = start -1;
		//遍历数组
		for (int i = start; i < end; i++) {
			//若发现当前数小于我们选取的数，
			if (data[i]<data[end]) {
				small ++ ; //计算加一
				if (small != index) {
					//交换i位置与 small位置的数
					swap(data,i,small);
				}
			}
		}
		small ++ ;
		swap(data,small,end);
		return 0;
	}
	private static void swap(int[] data, int index, int index2) {
		int temp = data[index2];
		data[index2] = data[index];
		data[index] = temp;
	}
	
	
	/*
	 * 希尔排序
	 */
	//数组希尔排序(插入排序缩小增量)，时间o(n^1.3)，空间o(1)，不稳定
    //时间复杂度是模糊的，有人在大量的实验后得出结论：当n在某个特定的范围后希尔排序的比较和移动次数减少至n^1.3。次数取值在1到2之间。
    public static void shellSort(int[] data){
        if(data==null || data.length<=1)
            return;
        
        //数组长12 d=6  d=3
        for(int gap=data.length/2; gap>0; gap=gap/2){
        	//i=6 7   /  3 4 5 
            for(int i=gap;i<data.length;i++){
                int cur = i;
                int temp = data[i];
                while (cur-gap>=0 && data[cur-gap]>temp) {
					data[cur] = data[cur-gap];
					cur = cur-gap;
				}
                data[cur]=temp;
            }
        }
    }
    @Test
    private void testShellSort(){
        int[] data = {5,4,3,1,2,6,10,7,2,2,2,2,8,9,45};
        shellSort(data);
        System.out.print("数组希尔排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }


	
	
	/*
	 * 选择排序
	 */
	public static void selectionSort(int[] data){
		if(data == null) return;
		int curMinIndex = 0;
		for (int i = 0; i < data.length; i++) {
			curMinIndex=i;
			for (int j = i; j < data.length; j++) {
				if (data[curMinIndex]>data[j]) {
					curMinIndex = j;
				}
			}
			int temp = data[i];
			data[i]=data[curMinIndex];
			data[curMinIndex]=temp;
		}
	}
	
	@Test
	private void testSelectionSort(){
        int[] data = {5,4,3,1,2,6,10,7};
        selectionSort(data);
        System.out.print("数组选择排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }

	
	
	
	/*
	 * 直接插入排序
	 */
	public static void insertionSort(int[] data){
		if(data == null) return;
		int now = 0;
		int index = 0;
		for (int i = 1; i < data.length; i++) {
			index = i;
			now = data[i];
			while (index>0&&data[index-1]>now) {
				data[index]=data[index-1];
				index--;
			}
			data[index] = now;
		}
	}
	
	//自己写的
	public static void insertionSort2(int[] data){
		if(data == null) return;
		int curValue = 0;
		int temp = 0;
		for (int i = 1; i < data.length; i++) {
			temp = i;
			curValue = data[i];
			while (temp-1>=0&&data[temp-1]>curValue) {
				swap(data, temp, temp-1);
				temp--;
			}
		}
	}
	
	
	@Test
	private void testInsertionSort(){
        int[] data = {5,4,3,1,2,6,10,7};
        insertionSort2(data);
        System.out.print("数组插入排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }
	
	/*
	 * 冒泡排序
	 */
	public static void bubbleSort(int[] data){
		if(data == null) return;
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 1; j < data.length-i; j++) {
				if (data[j-1]>data[j]) {
					int temp = data[j];
					data[j]=data[j-1];
					data[j-1]=temp;
				}
			}
		}
		return;
	}
	@Test
	private void testBubbleSort(){
        int[] data = {5,4,3,1,2,6,10,7};
        bubbleSort(data);
        System.out.print("数组冒泡排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }

}	
