package 算法类.其他题目;

/*
说有N对夫妇。编号为0..N-1。(0,1),(2,3)是夫妻。
现在出了点问题，他们并不是按顺序坐。
现在的顺序是row[i]
然后可以两两交换，问最少交换几次，使得每对夫妇都挨着坐。

乍一看有点难，leetcode也是hard的难度。
简单分析一下。
对于row[0]来说，如果row[1] 和 row[0]是夫妻，那么他们两个就都不动就好。如果两个都移走，那么不是最优。
考虑row[0]和row[1]不是夫妻的情况
操作1: 要么把row[0]和 row[0]的夫妻边上的交换
操作2: 要么把row[1]和row[0]的夫妻交换
操作3：要么row[0]和row[1]都移走。
显然操作3要不得。

对于0和1间隔奇数的情况:
0abc1d
变成 dabc10 或 01bcda
对于0和1间隔偶数的情况
0abcd1
变成 01bcda 或者 dabc01

可见操作1和操作2是等价的，移动之后都是01挨上，ad挨上

那么就用操作2吧，方便编程。

如此，我们就从row[0]开始，每次找到她的夫妻，放在她的边上就好。
当然可以记录位置来变得O(N)，但是题目中N <= 60，那就O(N^2)好了。
 */
public class 扩展2CVTE新郎新娘坐凳子 {

    private static int minSwapsCouples(int[] data) {
        if (data == null || data.length < 2 || data.length%2!=0) return -1;
        int temp = 0;
        int result = 0;

        for (int i=0;i<data.length;i=i+2) {
            //若为偶数，则向上求奇数，若为奇数，则向下求偶数
            if (data[i]%2==0){
                temp = data[i]+1;
            }else {
                temp = data[i]-1;
            }
            if (temp!=data[i+1]){
                for (int j = i+2;j<data.length;j++){
                    if (data[j]==temp){
                        swap(data,i+1,j);
                        result ++;
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void swap(int[] data, int index, int index2) {
        int temp = data[index2];
        data[index2] = data[index];
        data[index] = temp;
    }


    public static void main(String[] args){
        int[] data = new int[]{1,9,4,0,2,5,8,6,7,3};
        System.out.println(minSwapsCouples(data));
    }

}
