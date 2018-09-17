package 算法类.其他题目;

import java.util.Scanner;

public class 虎牙9月6日二叉树前序遍历 {

    public static void order(String[] a){
        orderRecu(a,0,0);
    }

    public static void orderRecu(String[] a,int currentIndex ,int currentCen){
        if (currentIndex<a.length) {
            if (!a[currentIndex].equals("#"))
                System.out.print(a[currentIndex]);
            orderRecu(a,currentIndex*2+1,currentCen+1);
            orderRecu(a,currentIndex*2+2,currentCen+1);
        }
    }


    private static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //解析牛客网输入数据
    public static String[] parseSampleInput(){
        Scanner in = new Scanner(System.in);
        if (in.hasNext()){
            return in.nextLine().split(" ");
        }
        return null;
    }

    public static void main(String[] args) {
        String[] a = parseSampleInput();
        order(a);
    }

}

