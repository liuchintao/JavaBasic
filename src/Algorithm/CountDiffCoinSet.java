package Algorithm;

import java.util.Scanner;

public class CountDiffCoinSet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();// Investment
		int num2 = sc.nextInt();// 01 bag
		int target = sc.nextInt();
		int count = num1 + num2;
		int[] val = new int[count];
		for (int i = 0; i < count; i++) {
			val[i] = sc.nextInt();
		}
		if (target == 0) {
			System.out.println("0");
			return;
		}
		int[][] dp = new int[count + 1][target + 1];
		for (int i = 0; i <= count; i++)
			dp[i][0] = 1;
		for (int i = 1; i <= count; i++) {
			for (int j = 1; j <= target; j++) {
				dp[i][j] = 0;
				if (i <= num1) {
					for (int k = 0; k <= j / val[i - 1]; k++) {
						dp[i][j] += dp[i - 1][j - k * val[i - 1]];
					}
				}
				else {
					for(int k = 0; k < 2; k++) {
						dp[i][j] += dp[i - 1][j - k*val[i - 1]];	
					}
				}
			}
		}
		int ans = dp[count][target];
		System.out.println(ans);
	}
}
