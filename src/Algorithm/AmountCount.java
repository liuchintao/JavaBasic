package Algorithm;

import java.util.Scanner;

public class AmountCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = count(String.valueOf(nums[i]));
		}
		for (int i = 0; i < n; i++) {
			System.out.println(ans[i]);
		}
	}

	private static int count(String i) {
		int len = i.length();
		int n = Integer.parseInt(i);
		if (len < 2)
			return n;
		int rtn = (int) (n - Math.pow(10, len - 1) + 1) * len;
		while (len > 0) {
			len--;
			rtn += 9 * Math.pow(10, len - 1) * len;
		}
		return rtn;
	}
}
