package datastructure.tree.test;

import datastructure.tree.BasicTree;

public class BasicTreeGenerator {
	public static BasicTree<Integer> getIntegerTestCase() {
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
		return root;
	}
	
	public static BasicTree<Integer> getIntegerTestCaseII() {
		BasicTree<Integer> root = new BasicTree<Integer>(1);
		BasicTree<Integer> l1 = new BasicTree<Integer>(4);
		BasicTree<Integer> r1 = new BasicTree<Integer>(5);
		root.setLeft(l1);
		root.setRight(r1);
		BasicTree<Integer> l1l2= new BasicTree<Integer>(4);
		BasicTree<Integer> l1r2= new BasicTree<Integer>(4);
		l1.setLeft(l1l2);
		l1.setRight(l1r2);
		BasicTree<Integer> l1r1l3= new BasicTree<Integer>(5);
		r1.setLeft(l1r1l3);
		return root;
	}
	
	public static BasicTree<Integer> getIntegerTreeByArray(Integer[] array){
		if(array == null || array.length == 0)
			return null;
		BasicTree<Integer> root = createBasicTree(array, 0);
		return root;
	}

	private static BasicTree<Integer> createBasicTree(Integer[] array, int idx) {
		if(idx >= array.length)
			return null;
		BasicTree<Integer> root = new BasicTree<Integer>(array[idx++]);
		root.setLeft(createBasicTree(array, (idx<<1)-1));
		root.setRight(createBasicTree(array, idx<<1));
		return root;
	}
	
}
