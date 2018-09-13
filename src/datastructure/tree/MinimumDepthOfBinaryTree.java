package datastructure.tree;

public class MinimumDepthOfBinaryTree<T> {

	public int minDepth(BasicTree<T> root) {
		if (root == null)
			return 0;
		int left = minDepth(root.left) + 1;
		int right = minDepth(root.right) + 1;
		return Math.min(left, right);
	}
}
