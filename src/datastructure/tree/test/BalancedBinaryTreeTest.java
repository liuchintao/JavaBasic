package datastructure.tree.test;

import datastructure.tree.BalancedBinaryTree;
import datastructure.tree.BasicTree;
import junit.framework.TestCase;

public class BalancedBinaryTreeTest extends TestCase {
	public void testIsBalanced() {
		BasicTree<Integer> root = new BasicTree<Integer>(1);
		BasicTree<Integer> l1 = new BasicTree<Integer>(2);
		BasicTree<Integer> r1 = new BasicTree<Integer>(3);
		root.setLeft(l1);
		root.setRight(r1);
		BasicTree<Integer> l1l2= new BasicTree<Integer>(4);
		BasicTree<Integer> l1r2= new BasicTree<Integer>(5);
		l1.setLeft(l1l2);
		l1.setRight(l1r2);
		BasicTree<Integer> l1l2l3= new BasicTree<Integer>(6);
		l1l2.setLeft(l1l2l3);
		BalancedBinaryTree<Integer> balanced = new BalancedBinaryTree<>();
		System.out.println(balanced.isBalanced(root));
	}
}
