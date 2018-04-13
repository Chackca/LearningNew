package 算法类.剑指offer;

/*
 * 	题目要求：
	给定二叉树和其中一个节点，
	找到中序遍历序列的下一个节点。树中的节点除了有左右孩子指针，还有一个指向父节点的指针。
 */
public class 题8二叉树的下一个节点 {
	
	/*
	 * 1.如果一个结点没有左右子树但有父树，则下一个点为父树
	 * 2.如果一个结点有左右子树，则下一个节点为其最右子树的左子树，若右子树没有左子树，则为右子树
	 * 3.如果一个结点为父结点的右子树，且再无左右子节点，则其下一个节点为一颗作为父结点左子树的节点的父节点
	 * 4.如果一个结点无左右子树，且它是父子树的右节点，父子树最上层又是根节点的右子树，则结束
	 */
	private static TreeNodeWithFather<Integer> getNext(TreeNodeWithFather<Integer> node) {
		if (node == null) return null;
		TreeNodeWithFather<Integer> tempFather = null;
		//如果一个结点没有左右子树
		if (node.left == null && node.right == null) {
			//3.4前提：没有左右子树且为父节点的右子树
			if (node.father.right == node) {
				tempFather = node.father;
				//3.父子树最上层又是某节点的左子树，则下一个节点为某节点
				while (tempFather!=null ) {
					if (tempFather==tempFather.left.father &&tempFather.right!=node) {
						return tempFather;
					}else {
						tempFather = tempFather.father;
					}
				}
				//4.父树最上面找不到作为左子树的父树
				return null;		
			}
			
			//1.没有左右子树且为父节点的左子树
			else {
				return node.father;
			}
			
		}//2.如果一个结点有左右子树，则下一个节点为其右子树的左子树，若右子树没有左子树，则为右子树
		else if (node.right!=null) {
			if (node.right.left!=null) {
				node=node.right;
				while (node.left!=null) {
					node = node.left;
				}
				return node;
			}else {
				return node.right;
			}
			
		}
		
		
		return null;
	}
	
	
	
	public static void main(String[] args){
        //            1
        //          // \\
        //         2     3
        //       // \\
        //      4     5
        //    inorder->42513
        TreeNodeWithFather<Integer> root = new TreeNodeWithFather<Integer>(1);
        root.left = new TreeNodeWithFather<Integer>(2);
        root.left.father = root;
        root.right = new TreeNodeWithFather<Integer>(3);
        root.right.father = root;
        root.left.left = new TreeNodeWithFather<Integer>(4);
        root.left.left.father = root.left;
        root.left.right = new TreeNodeWithFather<Integer>(5);
        root.left.right.father = root.left;

        System.out.println(getNext(root.left.left).val);//4的下一个2
        System.out.println(getNext(root.left).val);//2的下一个5
        System.out.println(getNext(root.left.right).val);//5的下一个1
        System.out.println(getNext(root).val);//1的下一个3
        System.out.println(getNext(root.right));//3的下一个null
    }

	
}
