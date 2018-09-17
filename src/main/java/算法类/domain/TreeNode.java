package 算法类.domain;

import java.util.*;

public class TreeNode<T> {
	public T val;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode(T val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

    /**
     * 默认输出为层序遍历
     * @return
     */
    @Override
    public String toString() {
        StringBuilder SB = new StringBuilder("层序遍历：[");
        Queue<TreeNode<T>> queue = new LinkedList();
        queue.offer(this);
        TreeNode<T> temp;
        while(!queue.isEmpty()){
            temp = queue.poll();//插入并删除此队列的头
            SB.append(temp.val);
            SB.append(",");
            if(temp.left!=null)
                queue.offer(temp.left);
            if(temp.right!=null)
                queue.offer(temp.right);
        }
        SB.deleteCharAt(SB.lastIndexOf(","));
        SB.append("]");
        return SB.toString();
    }
    
    /**
        返回前序遍历
     */
    public String toFrontString() {
    	StringBuilder SB = new StringBuilder("前序遍历：[");
    	preOrder(this,SB);//递归实现
    	//preorderIteratively(this,SB);//迭代实现
    	SB.deleteCharAt(SB.lastIndexOf(","));
    	SB.append("]");
		return SB.toString();
    }
    /**
     * 返回中序遍历
     */
  	public String toMidString() {
  		StringBuilder SB = new StringBuilder("中序遍历：[");
      	midOrder(this,SB);//递归实现
      	//inorderIteratively(this,SB);//迭代实现
      	SB.deleteCharAt(SB.lastIndexOf(","));
      	SB.append("]");
  		return SB.toString();
  	}

    /**
     * 返回后序遍历
     * @return
     */
  	public String toBackString() {
  		StringBuilder SB = new StringBuilder("后序遍历：[");
      	posOrder(this,SB);//递归实现
      	//postorderIteratively(this,SB);//迭代实现
      	SB.deleteCharAt(SB.lastIndexOf(","));
      	SB.append("]");
  		return SB.toString();
  	}
    
    
    /**
     * 递归前序遍历
     */
    public void preOrder(TreeNode<T> node, StringBuilder SB){
    	if (node == null)
    	    return;
        //执行处理代表当前为中
        //前序这里执行处理（中左右）
        SB.append(node.val);
        SB.append(",");
        preOrder(node.left,SB);
        //中序在这里（左中右）
        preOrder(node.right,SB);
        //后序在这里（左右中）
    }
    
    /**
     * 递归中序遍历
     */
    public void midOrder(TreeNode<T> node, StringBuilder SB) {
        if (node == null)
            return;
        midOrder(node.left,SB);
        //在这里执行处理
        SB.append(node.val);
        SB.append(",");
        midOrder(node.right,SB);
    }

    /**
     * 递归后序遍历
     */
    public void posOrder(TreeNode<T> node, StringBuilder SB) {
        if (node == null)
            return;
        posOrder(node.left,SB);
        posOrder(node.right,SB);
        //在这里执行处理
        SB.append(node.val);
        SB.append(",");
    }


    /**
     * //前序遍历非递归版
     * @param node
     * @param SB
     */
    public void preorderIteratively(TreeNode<T> node, StringBuilder SB){
    	 if(node==null)
             return;
    	//stack栈顶元素永远为cur的父节点
        Stack<TreeNode<T>> stack = new Stack();
        TreeNode<T> cur = node;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
            	SB.append(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop().right;
            }
        }
    }

    /**
     * 中序遍历非递归版
     * @param node
     * @param SB
     */
    public void inorderIteratively(TreeNode<T> node, StringBuilder SB){
        //stack栈顶元素永远为cur的父节点
        Stack<TreeNode<T>> stack = new Stack();
        TreeNode<T> cur = node;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
            	SB.append(stack.peek().val);
                cur = stack.pop().right;
            }
        }
        
    }

    /**
     *  后序遍历非递归版，比较复杂
     */
    public void postorderIteratively(TreeNode<T> node, StringBuilder SB){
        //stack栈顶元素永远为cur的父节点
        //prevVisted用于区分是从左子树还是右子树返回的
        Stack<TreeNode<T>> stack = new Stack();
        TreeNode<T> cur = node;
        TreeNode<T> prevVisted = null;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.peek().right;
                if(cur!=null && cur!=prevVisted){
                    stack.push(cur);
                    cur = cur.left;
                }
                else{
                    prevVisted = stack.pop();
                    SB.append(prevVisted.val);       
                    cur = null;
                }
            }
        }
    }


    /**
     * 以下的方法同样实现了非递归版前中后序遍历，只需要更改一段代码的位置即可实现
     */
    private static class Command{
        private String s;
        private TreeNode node;
        public Command(String s,TreeNode node){
            this.node = node;
            this.s = s;
        }
    }

    /**
     * 此种方法可以很方便地更换前中后序
     * @param root
     * @return
     */
    public static String preorderTraversal(TreeNode root) {
        if (root == null) return null;
        List list = new ArrayList();

        Stack<Command> stack = new Stack();
        stack.push(new Command("go",root));
        while (!stack.isEmpty()){
            Command command = stack.pop();
            if (command.s.equals("print")){
                list.add(command.node.val);
            }else { //go
                //这里是后序遍历
                if (command.node.right!=null)
                    stack.push(new Command("go",command.node.right));
                //这里是中序遍历
                if (command.node.left!=null)
                    stack.push(new Command("go",command.node.left));
                stack.push(new Command("print",command.node));//这里是前序遍历
            }
        }
        return list.toString();
    }

    /**
     * 测试用例
     * @param args
     */
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

        //ZhiPrint(root);
        root.traverseReverse(root);
        //测试打印中序遍历
        /*System.out.println(root.toMidString());
        //测试打印后序遍历
        System.out.println(root.toBackString());*/
    }


    /**
     * 从底到上的层序遍历
     * @param node
     */
    public static void traverseReverse(TreeNode node){
        if (node == null)
            return;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(node);
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        int index = 0;
        while (!queue.isEmpty()){
            list.add(index,new ArrayList());
            ArrayList innerList = list.get(index++);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                 TreeNode cur = queue.poll();
                 innerList.add(cur.val);
                 if (cur.left!=null){
                     queue.offer(cur.left);
                 }
                 if (cur.right!=null){
                     queue.offer(cur.right);
                 }
            }
        }

        for (int i = list.size()-1; i >= 0 ; i--) {
             ArrayList innerList = list.get(i);
            for (int j = 0; j < innerList.size(); j++) {
                System.out.print(innerList.get(j));
            }
            System.out.println();
        }
    }

    /**
     * 二叉树的最小深度
     */
    public static int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        if (left==0||right==0){
            return left+right+1;
        }
        return 1+Math.min(left,right);
    }


    /**
     * 判断是否为平衡二叉树
     */
    /*
     * 采用递归的方法，效率不高，节点会被重复计算
     */
    private static boolean isBalanced(TreeNode<Integer> root) {
        if (root==null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        if(left-right>1 ||left-right<-1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    /*
     * 采用后序遍历的方法，每个节点只算一次
     */
    //用后序遍历，并记录每个节点的深度，从而可以通过一次遍历完成整棵树的判断
    public static boolean isBalanced2(TreeNode<Integer> node){
        if(node==null)
            return true;
        int depth[] = new int[1];
        return isBalanced2Core(node,depth);
    }

    private static boolean isBalanced2Core(TreeNode<Integer> root, int[] depth) {
        if (root==null) {
            return true;
        }
        int left[] = new int[1];
        int right[] = new int[1];

        if (isBalanced2Core(root.left,left)&&isBalanced2Core(root.right,right)) {
            if ((left[0]- right[0]<=1)||(left[0]- right[0]>=-1)) {
                depth[0] = 1+ ((left[0]>right[0])?left[0]:right[0]) ;
                return true;
            }
        }
        return false;
    }

    /**
     * 按之字形打印二叉树
     * 两个栈
     * @param root
     */
    public static void ZhiPrint(TreeNode root){
        if(root == null)return;
        //用于保存  左右  子节点
        Stack<TreeNode<Integer>> stack1 = new Stack();
        //用户保存  右左  子节点
        Stack<TreeNode<Integer>> stack2 = new Stack();

        TreeNode<Integer> temp ;
        stack2.push(root);

        while(!stack1.isEmpty()||!stack2.isEmpty()){
            while(!stack1.isEmpty()){
                temp = stack1.pop();
                System.out.print(temp.val);
                if(temp.right!=null)stack2.push(temp.right);
                if(temp.left!=null)stack2.push(temp.left);
            }
            System.out.println();
            while(!stack2.isEmpty()){
                temp = stack2.pop();
                System.out.print(temp.val);
                if(temp.left!=null)stack1.push(temp.left);
                if(temp.right!=null)stack1.push(temp.right);
            }
            System.out.println();
        }
    }

    /**
     * 二叉树的直径
     * 直径：从一个子节点到另外一个子节点的最长长度
     */
    private static int Diameter;
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        maxDepth(root);
        return Diameter;
    }
    private static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        Diameter = Math.max(Diameter,left+right);
        return Math.max(left,right)+1;
    }


    /**
     * 二叉树的镜像
     */
    public void mirrorRecursively(TreeNode<Integer> root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            return;
        }
        //执行交换左右子树
        TreeNode<Integer> tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        if(root.left!=null){
            mirrorRecursively(root.left);
        }if(root.right!=null){
            mirrorRecursively(root.right);
        }
    }

    /**
     * 判断是否为对称二叉树
     */
    //递归实现
    public boolean isSymmetrical(TreeNode<Integer> root){
        if(root==null)
            return false;
        if(root.left==null && root.right==null)
            return true;
        if(root.left==null || root.right==null)
            return false;
        return isSymmetrical(root.left,root.right);
    }
    public boolean isSymmetrical(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        if(!root1.val.equals(root2.val))
            return false;
        return isSymmetrical(root1.left,root2.right) && isSymmetrical(root1.right,root2.left);
    }




}