package Interview.toutiao;

import java.util.Scanner;

public class AddOperator {
	
	/**
	 * Testcase: 
	 * 2
	 * 11
	 * 00110
	 * Output:
	 * 2
	 * 2
	 */

	static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		int[] ans = new int[n];
		for (int times = 0; times < n; times++) {
			String numString = scanner.nextLine();
			int[] nums = new int[numString.length()];
			int tmp, zeroNum = 0, i = 0, j = 0;
			for (; i < numString.length(); i++) {
				tmp = numString.charAt(i) - '0';
				if (tmp == 0) {
					zeroNum++;
				}
				if (zeroNum == i + 1)
					continue;
				nums[j] = tmp;
				j++;
			}
			if (zeroNum == numString.length()) {
				System.out.println(1);
				return;
			}
			countMethods(nums, 0, 0, j);
			ans[times] = count;
			count = 0;
		}
		for(int num: ans)
			System.out.println(num);
	}

	private static void countMethods(int[] nums, int i, int target, int limit) {
		if (i == limit && target == 0)
			count++;
		if (i >= limit)
			return;
		int tmp = nums[i];
		if (tmp == 0) {
			countMethods(nums, i + 1, target - tmp, limit);
		} else {
			countMethods(nums, i + 1, target - tmp, limit);
			countMethods(nums, i + 1, target + tmp, limit);
			while (i < limit - 1) {
				tmp = tmp * 10 + nums[++i];
				countMethods(nums, i + 1, target - tmp, limit);
				countMethods(nums, i + 1, target + tmp, limit);
			}
		}
	}

}
