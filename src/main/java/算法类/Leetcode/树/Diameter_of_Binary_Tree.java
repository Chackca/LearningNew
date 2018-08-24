package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */
public class Diameter_of_Binary_Tree {

    /**
     * 利用递归的思想，求出左右节点的最深深度再相加即可
     * @param root
     * @return
     */
    private static int max;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        maxDepth(root);
        return max;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max,left+right);

        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);
        System.out.println(diameterOfBinaryTree(root));
    }
}
