package SwordToOffer;

public class Question4 {
	public static void main(String[] args) {
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		int target1 = 7;
		int target2 = 20;
		int target3 = 15;
		int target4 = 6;
		int target5 = 1;
		int target6 = 9;
		System.out.println(contains(array, target1));
		System.out.println(contains(array, target2));
		System.out.println(contains(array, target3));
		System.out.println(contains(array, target4));
		System.out.println(contains(array, target5));
		System.out.println(contains(array, target6));
	}

	private static boolean contains(int[][] array, int target) {
		if(array == null)
			return false;
		int row = array[0].length;
		int col = array.length;
		int i = 0;
		int j = row - 1;
		while (i < col && j >= 0) {
			if (array[i][j] < target) {
				i++;
			} else if (array[i][j] > target) {
				j--;
			} else
				return true;
		}
		return false;
	}
}
