package datastructure.tree;

public class DiameterOfBinaryTree<T> {
	
	int max = 0;
	
	public int getDiameter(BasicTree<T> root) {
		getDepth(root);
		return max - 1;
	}

	private int getDepth(BasicTree<T> root) {
		if(root == null)
			return 0;
		int l = getDepth(root.left);
		int r =getDepth(root.right);
		max = Math.max(max, l + r);
		return Math.max(l, r) + 1;
	}
}
