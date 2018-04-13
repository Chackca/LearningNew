package 算法类.其他题目;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 顺丰1018.3.30后台笔试题
 * 丢手绢
 * 输入第一行代表总共n个人
 * 后面n行分别代表他们各自的值
 * 上面n行输入完毕后，最后再输入一行代表要取出上面的数的最大m个值
 *
 * 输出：最大m个值的总和
 *
 * 输入：
 * 5
 * 1
 * 2
 * 3
 * 4
 * 5
 * 3
 * 输出：
 * 12
 */
public class 顺丰丢手绢 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static long solve(int[] num, int m) {
        Arrays.sort(num);
        //quickSort(num,0,num.length-1);
        long result = 0;
        for (int i = num.length-1;i>num.length-m-1;i--){
            result+=num[i];
        }
        return result;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long res;

        int _num_size = 0;
        _num_size = Integer.parseInt(in.nextLine().trim());
        int[] _num = new int[_num_size];
        int _num_item;
        for(int _num_i = 0; _num_i < _num_size; _num_i++) {
            _num_item = Integer.parseInt(in.nextLine().trim());
            _num[_num_i] = _num_item;
        }

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        res = solve(_num, _m);
        System.out.println(String.valueOf(res));

    }

}