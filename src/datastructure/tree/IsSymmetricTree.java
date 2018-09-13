package datastructure.tree;

public class IsSymmetricTree<T> {
	
	/*
    1
   / \
  2   2
 / \ / \
3  4 4  3
	 */
	
	
	public boolean isSymmetric(BasicTree<T> root) {
		if(root == null)
			return false;
		return isSymmetricCore(root.left, root.right);
	}

	private boolean isSymmetricCore(BasicTree<T> left, BasicTree<T> right) {
		if(left == null && right == null)  return true;
		if(left == null || right == null)  return false;
		if(left.val != right.val)  return false;
		return isSymmetricCore(left.left, right.right) && isSymmetricCore(left.right, right.left);
	}

}
