package 算法类.其他题目;

import 算法类.剑指offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 扩展3判断是否为完全二叉树 {


    private static boolean isFullTree(TreeNode<Integer> head) {
        if (head ==null) return false;
        TreeNode<Integer> cur = null;
        Queue<TreeNode<Integer>> queue = new LinkedList() ;
        queue.offer(head);
        int currentRow=0;
        while (!queue.isEmpty()){
            currentRow ++;//代表当前为第几层
            int sizeNeedToBe = (int) Math.pow(2,currentRow-1);//当前行应该有的节点数
            int size = queue.size();//实际节点数
            //若当前行的节点数不等于实际节点数，要么是最后一行了，要么不是完全二叉树
            if (sizeNeedToBe!=size){
                for (int i = 0;i<size;i++){
                    cur = queue.poll();
                    System.out.print(cur.val);
                    if(cur.left!=null || cur.right!=null) return false;
                }
            }
            //若当前行的节点数为实际节点数，说明当前行不是最后一行
            else if (sizeNeedToBe==size){
                for (int i = 0;i<size;i++){
                    cur = queue.poll();
                    System.out.print(cur.val);
                    if(cur.left==null&&cur.right!=null) return false;
                    if(cur.left!=null&&cur.right==null)
                        if (queue.peek()!=null)
                            return false;
                    if(cur.left!=null) queue.offer(cur.left);
                    if(cur.right!=null) queue.offer(cur.right);
                }
            }
            System.out.println("\t");
        }
        return true;
    }





    public static void main(String[] args){
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
        System.out.println(isFullTree(root));

    }




}
