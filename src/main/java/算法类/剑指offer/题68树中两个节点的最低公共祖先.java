package 算法类.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 题68树中两个节点的最低公共祖先 {
	
	//方法二：使用辅助内存遍历
	//将两个节点的遍历路径分别存储在两个ArrayList中
	private static CommonTreeNode<Character> getLastParent2(CommonTreeNode<Character> root, CommonTreeNode<Character> node1,
			CommonTreeNode<Character> node2) {
		List<CommonTreeNode<Character>> list1 = new ArrayList<CommonTreeNode<Character>>();
		List<CommonTreeNode<Character>> list2 = new ArrayList<CommonTreeNode<Character>>();
		getPath(root,node1,list1);
		getPath(root,node2,list2);
		//CommonTreeNode<Character> result = root;
		//循环遍历两个list，当找到不一样的节点，说明上一个相同的节点即为公共父节点
		for (int i = 0; i < list1.size()&&i < list2.size(); i++) {
			if (list1.get(i)!=list2.get(i)) {
				return list1.get(i-1);
			}
		}
		
		return null;
	}
	

	
	//将root到node路径赋值到list中，即按顺序存储root到list的节点至list中
	private static boolean getPath(CommonTreeNode<Character> root,CommonTreeNode<Character> node, 
			List<CommonTreeNode<Character>> list) {
		
		if (root == node) {list.add(node);return true;}
		//将当前节点加入list
		list.add(root);
        for(CommonTreeNode<Character> child:root.children){
            if(getPath(child,node,list))
                return true;
        }
        //执行到这里，表示当前的节点的子节点都没有目标节点，将当前节点移除，并返回false
        list.remove(list.size()-1);
        return false;
        
	}




	public static void main(String[] args){
		
        CommonTreeNode<Character> root = new CommonTreeNode<Character>('A');
        CommonTreeNode<Character> b = new CommonTreeNode<Character>('B');
        CommonTreeNode<Character> c = new CommonTreeNode<Character>('C');
        CommonTreeNode<Character> d = new CommonTreeNode<Character>('D');
        CommonTreeNode<Character> e = new CommonTreeNode<Character>('E');
        CommonTreeNode<Character> f = new CommonTreeNode<Character>('F');
        CommonTreeNode<Character> g = new CommonTreeNode<Character>('G');
        CommonTreeNode<Character> h = new CommonTreeNode<Character>('H');
        CommonTreeNode<Character> i = new CommonTreeNode<Character>('I');
        CommonTreeNode<Character> j = new CommonTreeNode<Character>('J');
        
        CommonTreeNode<Character> q = new CommonTreeNode<Character>('q');
        
        root.addChildren(b,c); 
        b.addChildren(d,e);
        d.addChildren(f,g);
        e.addChildren(h,i,j);
        System.out.println(getLastParent1(root,f,h).val);
        System.out.println(getLastParent2(root,f,h).val);
        System.out.println(getLastParent1(root,h,i).val);
        System.out.println(getLastParent2(root,h,i).val);

    }

	//方法一：从上往下判断是否含有两个子节点，有的话返回true，直到返回true的节点的子节点返回false，那么这个返回true的就是要找的点
	private static CommonTreeNode<Character> getLastParent1(CommonTreeNode<Character> root, CommonTreeNode<Character> node1,
			CommonTreeNode<Character> node2) {
		if(root==null || node1==null || node2==null || !isInSubTree(root,node1,node2))
            return null;
		
        CommonTreeNode<Character> curNode = root;
        
        while (true) {	
        	//循环遍历每一层的子节点
        	for (CommonTreeNode<Character> child:curNode.children) {
        		//如果当前节点存在目标两节点
        		if (isInSubTree(child,node1,node2)) {
        			curNode = child;//将当前循环设置为下一层循环
        			break;//结束当前for循环，使其因为while(true)重新进入
				}
        		//判断当前的child是不是父节点的最后一个节点
        		//如果进入了，说明前面的节点包括他都不含有两目标节点，则他们的父节点就是我们要找的点
        		if (child==curNode.children.get(curNode.children.size()-1)) {
					return curNode;
				}
			}
		}
	}



	//为第一种方法getLastParent1服务
	//遍历循环root为根结点的树，检查node1和node2是否在其子节点中
	private static boolean isInSubTree(CommonTreeNode<Character> root, CommonTreeNode<Character> node1,
			CommonTreeNode<Character> node2) {
		boolean hasNode1 = false;
		boolean hasNode2 = false;
		//采用层序遍历的方法，用队列实现
		Queue<CommonTreeNode<Character>> queue = new LinkedList<CommonTreeNode<Character>>();
		queue.offer(root);//队尾进
		CommonTreeNode<Character> node = null;
		while (!queue.isEmpty()&&!(hasNode1&&hasNode2)) {
			node = queue.poll();//队头出
			if (node == node1) hasNode1 = true;
			if (node == node2) hasNode2 = true;
			for (CommonTreeNode<Character> commonTreeNode : node.children) {
				queue.offer(commonTreeNode);
			}
		}
		//System.out.println(hasNode1+"  "+hasNode2);
		return hasNode1&&hasNode2;
	}

}
