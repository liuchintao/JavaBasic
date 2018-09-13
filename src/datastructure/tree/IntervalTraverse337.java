package datastructure.tree;

public class IntervalTraverse337 {
	/**
	 * The thief has found himself a new place for his thievery again. There is only
	 * one entrance to this area, called the "root." Besides the root, each house
	 * has one and only one parent house. After a tour, the smart thief realized
	 * that "all houses in this place forms a binary tree". It will automatically
	 * contact the police if two directly-linked houses were broken into on the same
	 * night.
	 * 
	 * Determine the maximum amount of money the thief can rob tonight without
	 * alerting the police.
Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
	 */
//	private int max = 0;
	public int rob(BasicTree<Integer> root) {
//		if (root == null) return 0;
//		getMaxVal(root, false);
//		return max;
	    if (root == null || root.val == null) return 0;
	    int val1 = root.val;
	    if (root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
	    if (root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
	    int val2 = rob(root.left) + rob(root.right);
	    return Math.max(val1, val2);
	}

//	private int getMaxVal(BasicTree<Integer> root, boolean flag) {
//		if(root == null)
//			return 0;
//		int val = 0;
//		if(flag)
//			val = getMaxVal(root.right, !flag) + getMaxVal(root.left, !flag) + val;
//		else
//			val = getMaxVal(root.left, !flag) + getMaxVal(root.right, !flag);
//		max = Math.max(max, val);
//		return val;
//	}
}
