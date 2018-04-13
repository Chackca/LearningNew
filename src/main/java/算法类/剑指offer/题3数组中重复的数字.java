package 算法类.剑指offer;


/*
 * 题目要求：
	在一个长度为n的数组中，所有数字的取值范围都在[0,n-1]，但不知道有几个数字重复或重复几次，
	找出其中任意一个重复的数字。
	例如：输入2,3,1,0,2,5,3
 		输出2或者3
 		
	最优解法四：只需要找到任意一个重复的数字即结束，
	从数组下标0开始，查看0号元素的值2，与2索引处的1比较，不一样，交换两个数的位置，
	此时数组变为1,3,2,0,2,5,3，依次继续变换3,1,2,0,2,5,3-->0,1,2,3,2,5,3，
	接下来到达数组下标1，发现数值和索引一样，不用改动，到达数组下标2，一样，数组下标3，
	值为2！=3，与2号索引比较，发现2号索引的值与其相等，自此找到重复的数。
 */
public class 题3数组中重复的数字 {
	
	/*
	 * 方法一：暴力求解法
	 * 分别取得每一个索引，然后比较他们与后面的其他索引的值
	 */
	private static int getDuplication(int[] data) {
		if (data==null ||data.length<2) 
			return 0;
		
		int cur = 0;
		for (int i = 0; i < data.length; i++) {
			cur = data[i];
			for (int j = i+1; j < data.length; j++) {
				//if (j == i) break;
				if (data[j]==cur) return data[j];
			}
		}
		return cur;
	}

	
	/*
	 * 方法二：用快速排序，nlogn，然后找到相邻两数值一样的数字
	 * 会修改原数据
	 */
	private static int getDuplication2(int[] data) {
		if (data==null ||data.length<2) return 0;
		sortUtils.quickSort(data,0,data.length-1);
		int pre = data[0];
		for (int i = 1; i < data.length; i++) {
			if (data[i]==pre) {
				return pre;
			}else {
				pre=data[i];
			}
		}
		
		return -1;
	}	
	

	/*
	 * 方法三：借助hash表，不会修改原数据，时间复杂度n，空间复杂度n
	 */
	private static int getDuplication3(int[] data) {
		if (data==null ||data.length<2) 
			return 0;
		
		int[] hashtable = new int[data.length];
		
		for (int item:data) {
			if (hashtable[item]==1) {
				return item;
			}else {
				hashtable[item]=1;
			}
		}
		
		return -1;
	}
	
	
	/*
	 * 方法四：最好的方法，根据数字特点排序，会修改原始数据，时间复杂度o(n),空间复杂度o(1)
	 * 
	 */
	private static int getDuplication4(int[] data) {
		if (data==null ||data.length<2) 
			return 0;
		for (int i = 0; i < data.length; i++) {
			while (data[i]!=i) {	
				if (data[i] == data[data[i]]) {
					return data[i];
				}
				int temp = data[i];      
				data[i] = data[data[i]];
				data[temp] = temp;
			}
		}
		return 0;
	}
	
	
	
	/*
	 * 方法五：类似于二路归并，这个思路应该说是二路计数，不修改原始数据，时间复杂度o(nlogn),空间复杂度o(1)
	 * 相当于以时间换空间，nlogn没有前面的n那么快
	 * 此时为题目2，不修改数组找出重复的字
	 */
	private static int getDuplication5(int[] data) {
		if (data==null ||data.length<2) 
			return -1;
		int start = 0;
		int end = data.length-2;
		
		while(end>=start){
			int middle = ((end - start)>>1) +start;
			//获得从左到中间的数字数量count，
		
			int count = countRange(data,start,middle);
			
			if (end==start) {
				if (count>1) {
					return start;
				}else {
					break;
				}
			}		
			
			if (count>(middle-start+1)) {
				end = middle;
			}else {
				start = middle+1;
			}
		}
		
		
		return -1;
	}
	
	
	

	
	public static int countRange(int[] data,int start,int end){
        int count = 0;
        for(int i=0;i<data.length;i++){
            if(start<=data[i] && end>=data[i])
                count++;
        }
        return count;
    }
	


	public static void main(String[] args){
        int[] data = {2,3,1,0,2,5,3};
        //int[] test = {6,1,2,7,9,3,4,5,10,8};
        System.out.println(getDuplication(data));
        System.out.println(getDuplication2(data));
        System.out.println(getDuplication3(data));
        System.out.println(getDuplication4(data));
        System.out.println(getDuplication5(data));

        int[] data1 = {2,3,1,0,4,5,5};
        System.out.println(getDuplication(data1));
        System.out.println(getDuplication2(data1));
        System.out.println(getDuplication3(data1));
        System.out.println(getDuplication4(data1));
        System.out.println(getDuplication5(data1));
    }
	
	/*
	 * Java有几种修饰符
	 * 类修饰符：public protected default private
	 * 成员变量修饰符：public private protected transient volatile friendly final static
	 * 方法修饰符：public protect private native synchronize final static
	 */
	
	

}
