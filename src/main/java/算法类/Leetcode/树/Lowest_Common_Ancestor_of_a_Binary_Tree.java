package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

/**
 *     给出一棵二叉树与两个节点，寻找两个节点的最低公共祖先
 *     Logical Thinking
 *     Since it is hard to sum up the transition from LCA(p, q) to LCA( subtrees of p, subtrees of q). We try observing root.
 *     How does LCA(root, p, q) relate to LCA(root.left, p, q) and LCA(root.right, p,q)?
 *     If p, q are both to the left of root,
 *     LCA(root, p, q) = LCA(root.left, p, q);
 *     If p, q are both to the right of root,
 *     LCA(root, p, q) = LCA(root.right, p, q);
 *     If p, q locate different sides of root,
 *     LCA(root, p, q) = root;
 *     The recursion ends when root == null || root == p || root == q.
 *
 *     Clear Java Code
 */
public class Lowest_Common_Ancestor_of_a_Binary_Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode leftSub = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSub = lowestCommonAncestor(root.right, p, q);
        if (leftSub == null) {
            return rightSub;
        }
        if (rightSub == null) {
            return leftSub;
        }

        return root;
    }
}
