package 算法类.排序算法;
import org.junit.Test;
import 算法类.domain.SortTestUtil;

public class 快速排序  implements Sort {

	@Override
	public void executeSort(int[] data) {
		quickSort(data,0,data.length);
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
				SortTestUtil.swap(data, start, end);
			//左哨兵循环找到一个大于目标值的index
			while(end>start&&data[start]<target)
				start++;
			//左哨兵与右哨兵交换，并让右哨兵向左走一步
			if (end>start&&data[start]>target)
				SortTestUtil.swap(data, start, end);
		}
		//当执行到这里，start==end
		//data[start]=target;//因为上面已经用swap交换了，所以不需要此步骤
		//System.out.println(start);
		return start;
	}
	//快速排序测试
	@Test
	public void testQuickSort(){
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
		SortTestUtil.swap(data,index,end);
		//用于记录有多少个小于目标数的数
		int small = start -1;
		//遍历数组
		for (int i = start; i < end; i++) {
			//若发现当前数小于我们选取的数，
			if (data[i]<data[end]) {
				small ++ ; //计算加一
				if (small != index) {
					//交换i位置与 small位置的数
					SortTestUtil.swap(data,i,small);
				}
			}
		}
		small ++ ;
		SortTestUtil.swap(data,small,end);
		return 0;
	}

}
