package 算法类.Leetcode.递归;

import java.util.*;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations_77 {

    private static List<List> res = new ArrayList<>();

    private static List<List> Combinations(int n, int k) {
        if (n < 0 || k < 0 || k > n)
            return res;
        LinkedList<Integer> list = new LinkedList<>();
        find(n, k, 1, list);
        return res;
    }

    private static void find(int n, int k, int start, LinkedList<Integer> list) {
        if (list.size() == k) {
            res.add((List<Integer>)list.clone());
            return;
        }
        for (int i = start; i <= n; i++) {
            list.addLast(i);
            find(n,k,i+1,list);
            list.removeLast();
        }
        return;
    }

    public static void main(String[] args) {
        List<List> list = Combinations(4,2);//在【1，2，3，4】中找2个数的组合
        System.out.println(list);
    }

}
