package 算法类.剑指offer;

/*
题目要求： 我们把只包含因子2,3,5的数成为丑数。求按照从小到大的顺序第1500个丑数。1作为第一个丑数。

解题思路：
思路1：从1开始递增，依次判断每个数是否是丑数，不够高效；
思路2：思路1之所以效率低，比较关键的一点是遍历的每一个数字都进行丑数判断。
思路2不是去判断丑数，而是计算出丑数：因为每个丑数都可以看成是由1去乘以2、3、5，
再乘以2、3、5而衍生出来的。可以用三个指针指向第一个丑数1，
三个指针分别表示乘2，乘3，乘5，将三个指针计算出来的最小的丑数放在数组中，
并将该指针向后移动一个位置。为了得到第1500个丑数，
需要一个长度1500的数组来记录已经计算出来的丑数。因此这个思路也可以说是用空间换时间。

 */


public class 题49丑数 {
	
	public static boolean isUgly(int number) {
		if (number == 0) {
			return false;
		}else {
			while (number%2==0) {
				number=number<<1;
			}while (number%3==0) {
				number=number/3;
			}while (number%5==0) {
				number=number/5;
			}
		}
		return (number==1)?true:false;
	}
	
	
	public static int getUglyNumber_Solution2(int index) {
		if (index<0) {
			return 0;
		}
		int[] uglyNumbers = new int[index];
		//定义第一个丑数为1，接下去为：2、3、4、5、6、8、9、10...
		uglyNumbers[0]=1;
		
		int nextUglyIndex=1, multiply2=0, multiply3=0, multiply5=0;
		
		while (nextUglyIndex < index) {
			int min = min(uglyNumbers[multiply2]*2, uglyNumbers[multiply3]*3, uglyNumbers[multiply5]*5);
			uglyNumbers[nextUglyIndex]=min;
			//把已有的每个丑数*2，得到若干个小于或等于M的结果，累计结果的数量
			while (uglyNumbers[multiply2]*2<=uglyNumbers[nextUglyIndex]) {
				++multiply2;
			}
			while (uglyNumbers[multiply3]*3<=uglyNumbers[nextUglyIndex]) {
				++multiply3;
			}
			while (uglyNumbers[multiply5]*5<=uglyNumbers[nextUglyIndex]) {
				++multiply5;
			}
			++nextUglyIndex;

		}
		return uglyNumbers[nextUglyIndex-1];
	}
    
	public static int min(int x,int y,int z){
        int temp = x<y?x:y;
        return temp<z?temp:z;
    }
	
	public static void main(String[] args) {
		 System.out.println(getUglyNumber_Solution2(10));
	}
}
