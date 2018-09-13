package datastructure.sort;

import junit.framework.TestCase;

public class ShellSortTest extends TestCase {
	public void testShell() {
		Integer[] array = {5, 11, 7, 9, 2, 3, 12, 8, 6, 1, 4, 10};
		ShellSort<Integer> shellSort = new ShellSort<>();
		shellSort.sort(array);
		for(Integer ele: array)
			System.out.print(ele + " ");
	}
}
