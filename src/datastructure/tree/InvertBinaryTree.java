package datastructure.tree;

public class InvertBinaryTree<T> {
	public BasicTree<T> invertTree(BasicTree<T> root){
		if(root == null)
			return null;
		BasicTree<T> left = root.left;
		root.left = invertTree(root.right);
		root.right= invertTree(left);
		return root;
	}
}
