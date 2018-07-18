package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 用非递归的方法实现树的前中后序遍历 {

    private static class Command{
        private String s;
        private TreeNode node;
        public Command(String s,TreeNode node){
            this.node = node;
            this.s = s;
        }
    }

    public static List preorderTraversal(TreeNode root) {
        List list = new ArrayList();
        if (root == null) return list;

        Stack<Command> stack = new Stack();
        stack.push(new Command("go",root));
        while (!stack.isEmpty()){
            Command command = stack.pop();
            if (command.s.equals("print")){
                list.add(command.node.val);
            }else {
                assert command.s.equals("go");
                if (command.node.right!=null)
                    stack.push(new Command("go",command.node.right));
                if (command.node.left!=null)
                    stack.push(new Command("go",command.node.left));
                stack.push(new Command("print",command.node));
            }
        }
        return list;
    }



    /*private static class Command{
        String s;   // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    };

    public static List<Integer> preorderTraversal(TreeNode root) {

        ArrayList res = new ArrayList();
        if(root == null)
            return res;

        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));
        while(!stack.empty()){
            Command command = stack.pop();

            if(command.s.equals("print"))
                res.add(command.node.val);
            else{
                assert command.s.equals("go");
                if(command.node.right != null)
                    stack.push(new Command("go",command.node.right));
                if(command.node.left != null)
                    stack.push(new Command("go",command.node.left));
                stack.push(new Command("print", command.node));
            }
        }
        return res;
    }*/

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
        System.out.println(preorderTraversal(root));
    }
}
