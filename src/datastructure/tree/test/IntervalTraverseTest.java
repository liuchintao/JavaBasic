package datastructure.tree.test;

import datastructure.tree.BasicTree;
import datastructure.tree.IntervalTraverse337;
import junit.framework.TestCase;

public class IntervalTraverseTest extends TestCase {
	public void testGetMax() {
//		Integer[] array = {3,4,5,1,3,null,1};
//		Integer[] array = {3,2,3,null,3,null,1};
		Integer[] array = {9,1,1,1,5,null,null,2};
		BasicTree<Integer> root = BasicTreeGenerator.getIntegerTreeByArray(array);
		IntervalTraverse337 iTraverse337 = new IntervalTraverse337();
		System.out.println(iTraverse337.rob(root));
	}

}
