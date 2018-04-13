package 算法类.剑指offer;
/*
 * 	题目要求：
	实现两个函数，分别用来序列化和反序列化二叉树。
	
	解题思路：
	此题能让人想到重建二叉树。但二叉树序列化为前序遍历序列和中序遍历序列，
	然后反序列化为二叉树的思路在本题有两个关键缺点：
	1.全部数据都读取完才能进行反序列化。
	2.该方法需要保证树中节点的值各不相同（本题无法保证）。
	其实，在遍历结果中，记录null指针后（比如用一个特殊字符$），
	那么任何一种遍历方式都能回推出原二叉树。但是如果期望边读取序列化数据，
	边反序列化二叉树，那么仅可以使用前序或层序遍历。
	但层序记录的null个数要远多于前序，因此选择使用记录null指针的前序遍历进行序列化。
 */
public class 题37序列化二叉树 {
	
private static String serialize(TreeNode<Integer> root) {
		if(root==null)
	        return "$,";
		StringBuilder SB =  new StringBuilder();
	    SB.append(root.val);
	    SB.append(",");
	    SB.append(serialize(root.left));
	    SB.append(serialize(root.right));
		return SB.toString();
	}
	
	
	
	private static TreeNode<Integer> deserialize(String str) {
		if (str ==null) return null;
		StringBuilder SB = new StringBuilder(str);
		return deserializeCore(SB);
	}
	
	
	private static TreeNode<Integer> deserializeCore(StringBuilder SB) {
		if (SB.length()==0)return null;
		String num = SB.substring(0,SB.indexOf(","));
		SB.delete(0,SB.indexOf(","));//删除数值
		SB.deleteCharAt(0);//删除逗号
		if(num.equals("$"))
	         return null;
		TreeNode<Integer> node = new TreeNode<>(Integer.parseInt(num));
        node.left = deserializeCore(SB);
        node.right = deserializeCore(SB);
        return node;
	}



	public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //       /      / \
        //      4      5   6
        //    1,2,4,$,$,$,3,5,$,$,6,$,$
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);
    
        System.out.println("原始树："+root);
        String result = serialize(root);
        System.out.println("序列化结果："+result);
        TreeNode<Integer> deserializeRoot = deserialize(result);
        System.out.println("反序列后的树："+deserializeRoot);
    }

	
}
