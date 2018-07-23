package 算法类.Leetcode.图;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给出一个正整数n，给出最少的完全平方数，使它们的和=n
 * 完全平方数：1 4 9 16 25......
 * 12=4+4+4
 * 13=9+4
 *
 * 对问题建模：
 * 整个问题转化为一个图论问题
 * 从n到0，每个数字表示一个节点；
 * 如果两个数字x到y相差一个完全平方数，则连接一条边。
 * 我们得到了一个无权图
 * 原问题转化成，求这个无权图中从n到0的最短路径
 */
public class Perfect_Squares_279 {


    public static void solution(int target){
        if (target<=0) return;
        LinkedList<Pair<Integer,Integer>> queue = new LinkedList();
        queue.add(new Pair<>(target,0));
        boolean[] visited = new boolean[target+1];
        visited[target] = true;

        while (!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if (num == 0){
                System.out.println(step);
                return;
            }

            for (int i = 1; ; i++) {
                int a = num - i*i;
                if (a<0)break;
                if (a == 0) {
                    System.out.println(step+1);
                    return;
                }
                if (!visited[a]){
                    queue.add(new Pair<>(a,step+1));
                    visited[a]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        solution(12);
        solution(13);
    }

}
