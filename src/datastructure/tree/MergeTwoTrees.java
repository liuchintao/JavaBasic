package datastructure.tree;

public class MergeTwoTrees<T> {
	public BasicTree<Integer> merge(BasicTree<Integer> root1, BasicTree<Integer> root2){
		if(root1 == null && root2 == null)
			return null;
		if(root1 == null)
			return root2;
		if(root2 == null)
			return root1;
		BasicTree<Integer> root = new BasicTree<Integer>(root1.val + root2.val);
		root.left = merge(root1.left, root2.left);
		root.right= merge(root1.right, root2.right);
		return root;
	}
}
