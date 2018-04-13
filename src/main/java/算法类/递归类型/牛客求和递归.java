package 算法类.递归类型;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *   题目描述
     输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
     输入描述:
     每个测试输入包含2个整数,n和m
     输出描述:
     按每个组合的字典序排列输出,每行输出一种组合
     示例1
     输入

     5 5
     输出

     1 4
     2 3
     5
 */


public class 牛客求和递归 {
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, m;
         
        while(sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();  //计算的总和，目标值
            dfs(1, m, n);
            for(ArrayList<Integer> list : res) {
                int i = 0;
                for(; i < list.size() - 1; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println(list.get(i));
            }
        }
    }
    //索引，目标值，可以使用的最大值
    public static void dfs(int index, int count, int n) {
        //递归退出的条件
        if(count == 0) { //执行到这里说明成功找到
            res.add(new ArrayList<>(list));
        }
        else {
            for(int i = index; i <= count && i <= n; i++) {
                list.add(i);
                dfs(i + 1, count - i, n);
                list.remove(list.size() - 1);
            }
        }
    }
}

