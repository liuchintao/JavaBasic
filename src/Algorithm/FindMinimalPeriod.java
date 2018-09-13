package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMinimalPeriod {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		List<int[]> arrays = new ArrayList<int[]>();
		for(int i = 0; i < num; i++) {
			int len = sc.nextInt();
			int[] arr = new int[len];
			for(int j = 0; j < len; j++) 
				arr[j] = sc.nextInt();
			arrays.add(arr);
		}
		int[] result = new int[num];
		getMinimalPeriods(result, arrays, num);
		for(int i = 0; i < num; i++) {
			System.out.println(result[i]);
		}
	}

	private static void getMinimalPeriods(int[] result, List<int[]> arrays, int num) {
		int[] arr;
		int ans;
		for(int i = 0; i < num; i++) {
			arr = arrays.get(i);
			ans = getPeriod(arr);
			result[i] = ans;
		}
	}

	private static int getPeriod(int[] arr) {
		int len = arr.length;
		if(len < 2)
			return 0;
		if(len == 2)
			return arr[1] - arr[0];
		int diff = 0;
		int pre = arr[1] - arr[0];
		for(int i = 0; i < len - 1; i++) {
			diff = arr[i + 1] - arr[i];
			diff = diff == pre? diff: diff + pre;
			pre = diff;
		}
		return diff;
	}
}
