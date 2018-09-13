package datastructure.tree;

public class BasicTree<T> {
	T val;
	BasicTree<T> left;
	BasicTree<T> right;
	public BasicTree(T t) {
		this.val = t;
	}
	public T getVal() {
		return val;
	}
	public void setVal(T val) {
		this.val = val;
	}
	public BasicTree<T> getLeft() {
		return left;
	}
	public void setLeft(BasicTree<T> left) {
		this.left = left;
	}
	public BasicTree<T> getRight() {
		return right;
	}
	public void setRight(BasicTree<T> right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "BasicTree [val=" + val + "]";
	}
}
