package Interview.ebay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nixushu {

	private static int count = 0;
	private static List<int[]> per = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int t = scanner.nextInt();
		int[] nums = new int[n];
		for (int i = 1; i <= n; i++)
			nums[i - 1] = i;
		permutation(0, nums, t);
		System.out.println(count);
		for(int[] p:per) {
			for(int i = 0; i < p.length; i++)
				System.out.print(p[i]);
			System.out.println();
		}
	}
	
	private static void permutation(int begin, int[] nums, int t) {
		if(begin == nums.length) {
			for(int i = 0; i < nums.length; i++)
				System.out.print(nums[i]);
			System.out.println();
			if(checkInversion(nums, t)) {
				count++;
				if(count == 1)
					per.add(nums.clone());
			}
		}
		for(int i = begin; i < nums.length; i++) {
			int tmp = nums[i];
			nums[i] = nums[begin];
			nums[begin] = tmp;
			permutation(begin+1, nums, t);
			tmp = nums[i];
			nums[i] = nums[begin];
			nums[begin] = tmp;
		}
	}

	private static boolean checkInversion(int[] nums, int t) {
		int c = 0;
		for(int i = 0; i < nums.length; i++)
			for(int j = i + 1; j < nums.length; j++)
				if(nums[i] > nums[j])
					c++;
		return c == t;
	}
}
