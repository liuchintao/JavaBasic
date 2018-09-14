package testjava.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import junit.framework.TestCase;

public class CollectionsTest extends TestCase {

	public void testSortArrayBySpecIdx() {
		int[] a1 = { 3, 2 };
		int[] a2 = { 1, 3 };
		int[] a3 = { 2, 5 };
		List<int[]> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		for (int[] p : list)
			System.out.println(p[0] + ", " + p[1]);
		System.out.println();
		// Method I
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0])
					return 1;
				else if (o1[0] < o2[0])
					return -1;
				return 0;
			}
		});
		for (int[] p : list)
			System.out.println(p[0] + ", " + p[1]);
		System.out.println();
		
		List<int[]> list1 = new ArrayList<>();
		list1.add(a1);
		list1.add(a2);
		list1.add(a3);
		for (int[] p : list1)
			System.out.println(p[0] + ", " + p[1]);
		System.out.println();
		// Method II
		list1.sort((int[] o1, int[] o2) -> o1[0] > o2[0] ? 1 : -1);
		for (int[] p : list1)
			System.out.println(p[0] + ", " + p[1]);
		System.out.println();
	}
}
