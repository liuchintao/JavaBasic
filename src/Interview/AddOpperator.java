package Interview;

import java.util.Scanner;

public class AddOpperator {

	static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int target = scanner.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1;
		countMethods(nums, 0, target);
		System.out.println(count);
	}

	private static void countMethods(int[] nums, int i, int target) {
		if (i == nums.length && target == 0)
			count++;
		if (i >= nums.length)
			return;
		int tmp = nums[i];
		countMethods(nums, i + 1, target - tmp);
		if (i != 0)
			countMethods(nums, i + 1, target + tmp);
		int j = i;
		while (i < nums.length - 1) {
			tmp = tmp * 10 + nums[++i];
			countMethods(nums, i + 1, target - tmp);
			if (j != 0)
				countMethods(nums, i + 1, target + tmp);
		}
		// if (i + 1 < nums.length) {
		// countMethods(nums, i + 2, target - nums[i] * 10 - nums[i + 1]);
		// countMethods(nums, i + 2, target + nums[i] * 10 + nums[i + 1]);
		// }
	}

}
