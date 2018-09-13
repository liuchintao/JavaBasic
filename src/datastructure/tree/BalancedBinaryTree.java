package datastructure.tree;

public class BalancedBinaryTree<T> {
	Boolean result = true;
	public boolean isBalanced(BasicTree<T> root) {
		getDepth(root);
		return result;
	}

	private int getDepth(BasicTree<T> root) {
		if(root == null)
			return 0;
		int l = getDepth(root.left);
		int r = getDepth(root.right);
		if(l - r > 1)
			result = false;
		return 1 + Math.max(l, r);
	}
}
