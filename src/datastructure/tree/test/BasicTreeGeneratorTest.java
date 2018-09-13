package datastructure.tree.test;

import datastructure.tree.BasicTree;
import junit.framework.TestCase;

public class BasicTreeGeneratorTest extends TestCase {
	
	public void testByArrayGenetor() {
		Integer[] array = {3,4,5,1,3,null,1};
		BasicTree<Integer> root = BasicTreeGenerator.getIntegerTreeByArray(array);
		System.out.println(root);
	}

}
