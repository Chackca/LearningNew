package 算法类.剑指offer;

/*
 * 题目要求：
	输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果，
	假设输入数组的任意两个数都互不相同。
	
	解题思路：
	二叉搜索树的中序遍历是有序的，而此题是后序遍历。
	后序遍历可以很容易找到根节点，然后根据二叉搜索树的性质
	（左子树小于根节点，右子树大于根节点），
	可以将序列分为根节点的左子树部分与右子树部分，而后递归判断两个子树。

 */
public class 题33二叉搜索树的后序遍历序列 {
	
	//利用递归的方法做
	private static boolean verifySquenceOfBST(int[] data) {
		if(data == null ||data.length==0){
			return false;
		}
		return verifySquenceOfBST(data,0,data.length-1);
	}
	
	/*
	 * 思路：序列的最后一个点为树的根节点root
	 * 判断序列左边有多少个值是小于根节点root的
	 * 他们就是该root的左子节点，其中，最右边那个是其直接左子节点
	 * 若序列左边没有任何一个值小于根节点，那么他们都为右子节点
	 */
	
	
	private static boolean verifySquenceOfBST(int[] data, int start, int end) {
		
		//数组长度为2，一定能够组成BST
		if (end-start==2) return true;
		
        int root = data[end];
        int mid = 0;
        for (mid = start; mid < end; mid++) {
			if(data[mid]>root){
				mid --;
				break;
			}
		}for (int i = mid+1; i < end; i++) {
			if(data[i]<root){
				return false;
			}
		}
        
		return verifySquenceOfBST(data,start,mid)&&verifySquenceOfBST(data,mid+1,end-1);
	}




	public static void main(String[] args) {
	  //    		8
	  //          /   \
	  //         6     10
	  //        / \    / \
	  //       5   7  9  11
	  int[] data = {5,7,6,9,4,10,8};
	  int[] data1 = {5,7,6,9,11,10,8};
	  System.out.println(verifySquenceOfBST(data));
	  System.out.println(verifySquenceOfBST(data1));

	}
	
}
