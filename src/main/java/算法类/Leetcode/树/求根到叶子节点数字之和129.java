package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

/**
 * @Author Chackca
 * @Date 2018/9/8 20:17
 * @Description :
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 **/
public class 求根到叶子节点数字之和129 {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(sumNumbers());
    }

    public static int sumNumbers() {
        int[] arr = new int[]{4,9,0,5,1};
        int[] arr2 = new int[]{1,2,3};
        solution(arr2,0,new StringBuilder());
        return count;
    }

    private static void solution(int[] arr,int index,StringBuilder sb) {
        boolean flag = false;
        int length = sb.length();
        sb.append(arr[index]);
        if (2*index+1<arr.length) {
            solution(arr, 2 * index + 1, sb);
            sb.delete(length+1,sb.length());
        }
        else {
            flag=true;
            count+=Integer.parseInt(sb.toString());
        }
        if (2*index+2<arr.length) {
            solution(arr, 2 * index + 2,sb);
            sb.delete(length+1,sb.length());
        }
        else if (!flag){
            count+=Integer.parseInt(sb.toString());
        }
    }

}
