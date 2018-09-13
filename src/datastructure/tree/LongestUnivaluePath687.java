package datastructure.tree;

public class LongestUnivaluePath687<T extends Comparable<T>> {
	/*
	 * Given a binary tree, find the length of the longest path where each node in
	 * the path has the same value. This path may or may not pass through the root.
	 * Note: The length of path between two nodes is represented by the number of edges between them.
              1
             / \
            4   5
           / \   \
          4   4   5 
	 * return 2
	 */
	private int path = 0;
	public int longestUnivaluePath(BasicTree<T> root) {
		if(root == null)
			return 0;
		findLongestPath(root);
		return path;
	}

	private int findLongestPath(BasicTree<T> root) {
		if(root == null)
			return 0;
		int l = findLongestPath(root.left);
		l = root.left != null && root.val.equals(root.left.val) ? l + 1 : 0;
		int r = findLongestPath(root.right);
		r = root.right != null && root.val.equals(root.right.val) ? r + 1 : 0;
		path = Math.max(path, l + r);
		return Math.max(l, r);
	}
}
