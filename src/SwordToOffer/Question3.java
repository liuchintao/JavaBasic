package SwordToOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question3 {
	public static void main(String[] args) throws Exception {
		int[] array1 = { 1, 2, 4, 0, 4 };
		// int[] array1 = {0,1,2,4,4};
		int[] array2 = { 1, 1, 3, 9, 4, 6, 4, 5, 7, 2 };
		// int[] array2 = {1,1,2,3,4,4,5,6,7,9};
		int[] array = { 2, 3, 1, 0, 2, 5, 3 };
		int[] array3 = { 1, 2, 3, 4, 5 };
		System.out.println(getDuplication(array1));
		System.out.println(getDuplication(array2));
		System.out.println(getDuplicationWithReRank(array));
//		System.out.println(getDuplicationWithReRank(array3));
		System.out.println(getDuplicationWithReRank(array2));

		/*
		 * =================================================== Version 2.0
		 */
		int[] l = { 2, 3, 5, 4, 3, 2, 6, 7 };
		int[] l1= {1,1,1,1,2,2};
		int[] l2= {1};
		int[] l3 = {4};
		System.out.println(getDuplicateVersion2(l));
		System.out.println(getDuplicateVersion2(l1));
		System.out.println(getDuplicateVersion2(l2));
		System.out.println(getDuplicateVersion2(l3));
	}

	public static List<Integer> getDuplication(int[] array) {
		/**
		 * The Time Complexity is O(n), and the Space Complexity is O(n)
		 */
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			Integer val = map.get(array[i]);
			if (val == null) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], val++);
				result.add(array[i]);
			}
		}
		return result;
	}

	public static List<Integer> getDuplicationWithReRank(int[] array) throws Exception {
		/**
		 * This function could optimizes Space Complexity to O(1)
		 * 
		 * But we need to fix method to be more robust.
		 */
		List<Integer> result = new ArrayList<Integer>();
		int i = 0;
		while (i < array.length) {
			// Filter nonconformity array.
			if (array[i] < 0 || array[i] >= array.length)
				throw new Exception("Array is nonconformity.");
			if (array[i] == i) {
				i++;
				continue;
			}
			if (array[array[i]] == array[i])
				result.add(array[i]);
			else {
				int temp = array[i];
				array[i] = array[array[i]];
				array[temp] = temp;
				i = 0;
				continue;
			}
			i++;
		}
		return result;
	}

	public static int getDuplicateVersion2(int[] array) {
		if ( array == null || array.length == 0)
			return -1;
		int start = 1;
		int end = array.length - 1;
		int middle;
		while (end >= start) {
			/**
			 * The loop will work n times. So the Time Complexity is O(nlg(n)),
			 * but the Space Complexity is O(1)
			 */
			middle = (end - start) / 2 + start;
			int count = countRange(array, start, middle);
			if(count == -1)
				return count;
			if (end == start) {
				if (count > 1)
					return start;
				else
					break;
			}
			if(count > middle - start + 1) {
				end = middle;
			}else {
				start = middle + 1;
			}
		}
		return -1;
	}

	private static int countRange(int[] array, int start, int end) {
		/**
		 * This method will be called about log(n) times.
		 */
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] >= array.length || array[i] < 1)
				return -1;
			if (array[i] >= start && array[i] <= end)
				count++;
		}
		return count;
	}
}
