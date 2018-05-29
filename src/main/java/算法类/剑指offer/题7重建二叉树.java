package 算法类.剑指offer;
/*
 * 	题目要求：
	根据二叉树的前序遍历和中序遍历，重建该二叉树。
	
	                    1
	                  /   \
	                 2     3
	                / \
	               4   5
	思路：以上图为例，前序遍历为12453，中序遍历为42513。前序的第一个数字1表明了树的根节点，结合中序可知，425为根节点的左子树，3为根节点的右子树。对于左子树部分，它的前序为245，中序为425，继续分而重建。对于左子树也如此。
	
 */
public class 题7重建二叉树 {

	public static TreeNode construct(int[] preorder, int[] inorder){
        if(preorder==null || inorder==null || preorder.length==0 || preorder.length!=inorder.length)
            return null;
        
        return constructCore(preorder,0,inorder,0,preorder.length);
    }
	//参数1前序数组，2前序计算开始，3中序数组，4中序计算开始，5当前数组长度
    public static TreeNode constructCore(int[] preorder, int preorder_start, int[] inorder, int inorder_start, int length){
        if(length==0)
            return null;
        //中序对应前序第一个根节点的索引
        int inorder_index = -1;
        for(int i=inorder_start;i<inorder_start+length;i++){
            if(inorder[i]==preorder[preorder_start]){
                inorder_index = i;
                break;
            }
        }
        int left_length = inorder_index - inorder_start;
        TreeNode node = new TreeNode(preorder[preorder_start]);
        node.left = constructCore(preorder,preorder_start+1,inorder,inorder_start,left_length);
        node.right = constructCore(preorder,preorder_start+left_length+1,inorder,inorder_index+1,length-left_length-1);
        return node;
    }
	
	
	
	public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //        / \
        //       4   5
        //pre->12453  in->42513   post->45231
        int[] pre={1,2,4,5,3};
        int[] in={4,2,5,1,3};
        //int[] pre={1,2,4,7,3,5,6,8};
        //int[] in={4,7,2,1,5,3,8,6};
        TreeNode<Integer> root = construct(pre,in);
        //对重建后的树,进行前中后序遍历，验证是否重建正确
        
        System.out.println(root.toFrontString());
        System.out.println(root.toMidString());
        System.out.println(root.toBackString());


        System.out.println(Math.pow(2,3));
    }

	

}
