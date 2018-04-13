package 算法类.剑指offer;

public class TreeNodeWithFather<T> {
	
	public T val;
	public TreeNodeWithFather<T> left;
	public TreeNodeWithFather<T> right;
	public TreeNodeWithFather<T> father;
	
	public TreeNodeWithFather(T data){
		this.val = data;
		this.left = null;
		this.right = null;
		this.father = null;
	}
}
