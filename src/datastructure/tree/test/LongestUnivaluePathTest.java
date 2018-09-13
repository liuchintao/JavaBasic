package datastructure.tree.test;

import datastructure.tree.BasicTree;
import datastructure.tree.LongestUnivaluePath687;
import junit.framework.TestCase;

public class LongestUnivaluePathTest extends TestCase {
	public void testLongestFunc() {
		BasicTree<Integer> root = BasicTreeGenerator.getIntegerTestCaseII();
		LongestUnivaluePath687<Integer> lPath687 = new LongestUnivaluePath687<>();
		System.out.println(lPath687.longestUnivaluePath(root));
	}

}
