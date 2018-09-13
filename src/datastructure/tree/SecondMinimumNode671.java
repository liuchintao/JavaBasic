package datastructure.tree;

public class SecondMinimumNode671 {
	/**
	 * Given a non-empty special binary tree consisting of nodes with the
	 * non-negative value, where each node in this tree has exactly two or zero
	 * sub-node. If the node has two sub-nodes, then this node's value is the
	 * smaller value among its two sub-nodes.
	 * 
	 * Given such a binary tree, you need to output the second minimum value in the
	 * set made of all the nodes' value in the whole tree.
	 * 
	 * If no such second minimum value exists, output -1 instead.
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
	 */
	public int findSecondMinimumValue(BasicTree<Integer> root) {
		if(root == null || (root.left == null && root.right == null))
			return -1;
		int lv = root.left.val;
		int rv = root.right.val;
		if(lv == root.val)
			lv = findSecondMinimumValue(root.left);
		if(rv == root.val)
			rv =  findSecondMinimumValue(root.right);
		if(lv != -1 && rv != -1)
			return Math.min(lv, rv);
		if(lv != -1)
			return lv;
		return rv;
		
	}
	
}
