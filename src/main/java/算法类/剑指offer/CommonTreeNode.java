package 算法类.剑指offer;

import java.util.LinkedList;
import java.util.List;

public class CommonTreeNode<T> {
	
	public T val;
	public List<CommonTreeNode<T>> children;
	
	public CommonTreeNode(T val) {
		this.val = val;
		children = new LinkedList<>();
	}
	
	
	public void addChildren(CommonTreeNode<T>... children){
		 for(CommonTreeNode<T> child : children)
             this.children.add(child);
	
	}
}
