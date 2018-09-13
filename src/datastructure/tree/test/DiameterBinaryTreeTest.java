package datastructure.tree.test;

import datastructure.tree.DiameterOfBinaryTree;
import junit.framework.TestCase;

public class DiameterBinaryTreeTest extends TestCase {
	public void testGetDiameter() {
		DiameterOfBinaryTree<Integer> diameterOfBinaryTree = new DiameterOfBinaryTree<>();
		System.out.println(diameterOfBinaryTree.getDiameter(BasicTreeGenerator.getIntegerTestCase()));
	}
}
