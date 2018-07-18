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
	//默认为层序遍历
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
    
    //返回前序遍历
    public String toFrontString() {
    	StringBuilder SB = new StringBuilder("前序遍历：[");
    	preOrder(this,SB);//递归实现
    	//preorderIteratively(this,SB);//迭代实现
    	SB.deleteCharAt(SB.lastIndexOf(","));
    	SB.append("]");
		return SB.toString();
    }
    //返回中序遍历
  	public String toMidString() {
  		StringBuilder SB = new StringBuilder("中序遍历：[");
      	midOrder(this,SB);//递归实现
      	//inorderIteratively(this,SB);//迭代实现
      	SB.deleteCharAt(SB.lastIndexOf(","));
      	SB.append("]");
  		return SB.toString();
  	}
  	//返回后序遍历
  	public String toBackString() {
  		StringBuilder SB = new StringBuilder("后序遍历：[");
      	posOrder(this,SB);//递归实现
      	//postorderIteratively(this,SB);//迭代实现
      	SB.deleteCharAt(SB.lastIndexOf(","));
      	SB.append("]");
  		return SB.toString();
  	}
    
    
    /*
     * 递归前序遍历
     */
    public void preOrder(TreeNode<T> node, StringBuilder SB){
    	if (node != null)
        {
            //执行处理代表当前为中
    		//前序这里执行处理（中左右）
            SB.append(node.val);
            SB.append(",");
            preOrder(node.left,SB);
            //中序在这里（左中右）
            preOrder(node.right,SB);
            //后序在这里（左右中）
        }
    }
    
    /*
     * 递归中序遍历
     */
    public void midOrder(TreeNode<T> node, StringBuilder SB)
    {
        if (node != null)
        {	
            midOrder(node.left,SB);
            //在这里执行处理
            SB.append(node.val);
            SB.append(",");
            midOrder(node.right,SB);
        }
    }

    /**
     * 递归后序遍历
     */
    public void posOrder(TreeNode<T> node, StringBuilder SB)
    {
        if (node != null)
        {
            posOrder(node.left,SB);
            posOrder(node.right,SB);
            //在这里执行处理
            SB.append(node.val);
            SB.append(",");
        }
    }
    
    
    
    //前序遍历非递归版
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
    
    //中序遍历非递归版
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
    //后序遍历非递归版，比较复杂
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


    //以下的方法同样实现了非递归版前中后序遍历，只需要更改一段代码的位置即可实现
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
                //这里是后序遍历
                if (command.node.right!=null)
                    stack.push(new Command("go",command.node.right));
                //这里是中序遍历
                if (command.node.left!=null)
                    stack.push(new Command("go",command.node.left));
                stack.push(new Command("print",command.node));//这里是前序遍历
            }
        }
        return list;
    }
}
