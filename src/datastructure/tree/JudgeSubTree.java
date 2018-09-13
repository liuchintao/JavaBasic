package datastructure.tree;

public class JudgeSubTree<T> {
	
	/**
Given tree s:
     3
    / \
   4   5
  / \
 1   2
 Given tree t:
   4
  / \
 1   2
 return true
 
 Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
 return false
 
	 */

	public boolean isSubTree(BasicTree<T> tree, BasicTree<T> target) {
		if (tree == null)
			return false;
		return isSubTreeCore(tree, target) || isSubTreeCore(tree.left, target) || isSubTree(tree.right, target);
	}

	private boolean isSubTreeCore(BasicTree<T> root, BasicTree<T> target) {
		if (root == null && target == null)
			return true;
		if (root == null || target == null)
			return false;
		if (root.val.equals(target.val))
			return false;
		return isSubTreeCore(root.left, target.left) && isSubTreeCore(root.right, target.right);
	}

}
