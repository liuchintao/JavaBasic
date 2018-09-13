package datastructure.tree.test;

import datastructure.tree.BasicTree;
import datastructure.tree.MinimumDepthOfBinaryTree;
import junit.framework.TestCase;

public class MinimumDepthOfBinaryTreeTest extends TestCase {
	
	public void testGetMinDepth() {
		BasicTree<Integer> root = BasicTreeGenerator.getIntegerTestCase();
		MinimumDepthOfBinaryTree<Integer> minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree<>();
		System.out.println(minimumDepthOfBinaryTree.minDepth(root));
	}

}
