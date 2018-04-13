package 算法类.排序算法;

import java.util.LinkedList;

public class 基数排序  implements Sort {

	@Override
	public void executeSort(int[] data) {
		radixSort(data);
	}
	
	

	/*private void radixSort(int[] data) {
		
	}*/


	//自己写的
    //若有要求不能修改原数组则按下面的方式，否则output数组可以不需要
	private static void countSort2(int[] a, int exp) {
		int[] output = new int[a.length];    // 存储"被排序数据"的临时数组
		LinkedList[] buckets = new LinkedList[10];

	    for (int i = 0; i < buckets.length; i++) {
	    	buckets[i]=new LinkedList();
		}

	    // 将数据存储在buckets[]中
        for (int i = 0; i < a.length; i++){
        	//int temp = (a[i]/exp)%10;
            buckets[(a[i]/exp)%10].offer(a[i]);
        }
        int temp = 0;
        // 将数据存储到临时数组output[]中
        for (int j = 0; j < 10; j++) {
        	while (buckets[j].peek()!=null) {
        		output[temp++]=(int) buckets[j].poll();
    		}
		}

        // 将排序好的数据赋值给a[]
        for (int i = 0; i < a.length; i++)
            a[i] = output[i];

        output = null;
        buckets = null;

	}

	
	
	
	/*
     * 获取数组a中最大值
     */
    private static int getMax(int[] a) {
        int max;
        max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    /*
     * 对数组按照"某个位数"进行排序(桶排序)
     *
     * 参数说明：
     *     a -- 数组
     *     exp -- 指数。对数组a按照该指数进行排序。
     *
     * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
     *    (01) 当exp=1表示按照"个位"对数组a进行排序
     *    (02) 当exp=10表示按照"十位"对数组a进行排序
     *    (03) 当exp=100表示按照"百位"对数组a进行排序
     *    ...
     */
    //若有要求不能修改原数组则按下面的方式，否则output数组可以不需要
    private static void countSort(int[] a, int exp) {
        //int output[a.length];    // 存储"被排序数据"的临时数组
        int[] output = new int[a.length];    // 存储"被排序数据"的临时数组
        int[] buckets = new int[10];
        
        //(a[i]/exp)%10为当前的个位数
        
        // 将数据出现的次数存储在buckets[]中
        for (int i = 0; i < a.length; i++)
            buckets[ (a[i]/exp)%10 ]++;

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++)
            buckets[i] += buckets[i - 1];

        // 将数据存储到临时数组output[]中
        for (int i = a.length - 1; i >= 0; i--) {
            output[buckets[ (a[i]/exp)%10 ] - 1] = a[i];
            buckets[ (a[i]/exp)%10 ]--;
        }

        // 将排序好的数据赋值给a[]
        for (int i = 0; i < a.length; i++)
            a[i] = output[i];

        output = null;
        buckets = null;
    }

    /*
     * 基数排序
     * a -- 数组
     */
    public static void radixSort(int[] a) {
        int exp;    // 指数。当对数组按个位进行排序时，exp=1；按十位进行排序时，exp=10；...
        int max = getMax(a);    // 数组a中的最大值
        // 从个位开始，对数组a按"指数"进行排序
        for (exp = 1; max/exp > 0; exp *= 10)
            countSort2(a, exp);
    }

    public static void main(String[] args) {
        int i;
        int a[] = {53, 3, 542, 748, 14, 214, 154, 63, 616};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        radixSort(a);    // 基数排序

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
	
    
    
	
	/*public static void sort(int[] number, int d) //d表示最大的数有多少位
    {
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][] temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[] order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while(m <= d)
        {
            for(int i = 0; i < number.length; i++)
            {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for(int i = 0; i < 10; i++)
            {
                if(order[i] != 0)
                    for(int j = 0; j < order[i]; j++)
                    {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }
    public static void main(String[] args)
    {
        int[]data =
        {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100,2121,1154,141,1451};
        sort(data, 4);
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }*/
}
