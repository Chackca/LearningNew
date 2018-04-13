package 算法类.动态规划;

public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] L = new int[]{5,2,3,1,7,6,8,9,0,10};
        int n = L.length;
        int[] f = new int[n];//用于存放f(i)值；
        f[0]=1;//以第a1为末元素的最长递增子序列长度为1；
        for(int i = 1;i<n;i++){//循环n-1次
            f[i]=1;//f[i]的最小值为1；
            for(int j=0;j<i;j++){//循环i次
                //若当前位置元素小于目标位置&&
                if(L[j]<L[i]&&f[j]>f[i]-1)
                    f[i]=f[j]+1;//更新f[i]的值。
            }
        }
        System.out.println(f[n-1]);

        System.out.println(findLongest(L));
    }



    //二分查找 ，将每一个数字的插入时间优化到 O(logN)
    //https://www.nowcoder.com/questionTerminal/585d46a1447b4064b749f08c2ab9ce66
    public static int findLongest(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        B[0] = A[0];
        int end = 0;
        for (int i = 1; i < length; ++i) {
            // 如果当前数比B中最后一个数还大，直接添加
            if (A[i] >= B[end]) {
                B[++end] = A[i];
            }else {
                // 否则，需要先找到替换位置
                int pos = findInsertPos(B, A[i], 0, end);
                B[pos] = A[i];
            }
        }
        for (int i = 0; i < B.length; ++i) {
            System.out.print(B[i]+" ");
        }
        System.out.println();
        return end+ 1;
    }
    /**
      * 二分查找第一个大于等于n的位置
     B数组，是存储对应长度LIS的最小末尾
      */
    //参数解释：1.要查找的数组；2.目标值；3.4.设置数组的查找范围
    private static int findInsertPos(int[] B, int n, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) >> 1;// 直接使用(high + low) / 2 可能导致溢出
            if (B[mid] < n) {
                start = mid + 1;
            } else if (B[mid] > n) {
                end = mid ;
            } else {
                return mid;
            }
        }
        return start;
    }

}
