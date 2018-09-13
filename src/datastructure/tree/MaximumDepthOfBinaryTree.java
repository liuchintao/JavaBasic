package datastructure.tree;

public class MaximumDepthOfBinaryTree<T> {

	public int getMaximumDepthOfBinaryTree(BasicTree<T> root) {
		if (root == null) 
			return 0;
		return Math.max(getMaximumDepthOfBinaryTree(root.left),
				getMaximumDepthOfBinaryTree(root.right))+1;
	}
}
