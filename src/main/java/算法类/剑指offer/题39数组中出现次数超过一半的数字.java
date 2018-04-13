package 算法类.剑指offer;


/*
 * 题目要求：
找出数组中出现次数超过数组长度一半的数字。如输入{1,2,3,2,2,2,5,4,2}，则输出2。

解题思路：
因为该数字的出现次数超过了数组长度的一半，因此可以将问题转化为求数组的中位数。
如果按照这个思路，有以下两种方式解决：排序后求中位数、用快排的分区函数求中位数（topK问题）
书中还提到一种思路，相当巧妙，可以看作一种特殊的缓存机制。
该思路需要一个整型的value变量和一个整型的count变量，
记录缓存值与该缓存值被命中的次数。缓存规则以及执行步骤如下：

	步骤1： 缓存值value，命中次数count均初始化为0。
	步骤2： 从头到尾依次读取数组中的元素，判断该元素是否等于缓存值：
	     步骤2.1：如果该元素等于缓存值，则命中次数加一。
	     步骤2.2：如果该元素不等于缓存值，判断命中次数是否大于1：
	              步骤2.2.1：如果命中次数大于1，将命中次数减去1。
	              步骤2.2.2：如果命中次数小于等于1，则令缓存值等于元素值，命中次数设为1
	步骤3： 最终的缓存值value即为数组中出现次数超过一半的数字。
 */
public class 题39数组中出现次数超过一半的数字 {
	
	/*
	 * 使用缓存值求的方式
	 */
	private static int  moreThanHalfNum2(int[] data) {
		if(data==null || data.length==0)
	        return 0;
		int value = -1; //记录当前值
		int count = 0; //记录当前值出现的次数	
		for (int i = 0; i < data.length; i++) {
			int now = data[i];	
			if (count >= 1 && now == value) {
				count ++;
			}else if (count > 1 && now != value) {
				count--;
			}else if (count <= 1 && now != value) {
				value = now;
				count = 1;
			}
		}
		return value;
	}

	/*
	 * 使用快拍的partition函数
	 */
	private static int  moreThanHalfNum1(int[] data) {
		if(data==null || data.length==0)
	        return 0;
		int start = 0;
		int end = data.length-1;
		int middleIndex = (data.length)>>>1;
		int index = partition(data,start,end);
		
		while (index!=middleIndex) {
			if (index<middleIndex) {
				start = index+1;
				index = partition(data,start,end);
			}else {	
				end = index-1;
				index = partition(data,start,end);
			}
		}
		if (index==middleIndex) {
			return data[middleIndex];
		}
		
		return -1;
	}
	
	
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

	public static void main(String[] args){
        int[] data = {1,2,3,2,2,2,5,4,2,4,4,4,4,4,4,4,4,4,4,4};
        System.out.println(moreThanHalfNum2(data));
        System.out.println(moreThanHalfNum1(data));
    }

	
}
