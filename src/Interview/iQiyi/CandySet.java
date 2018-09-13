package Interview.iQiyi;

import java.util.Scanner;

public class CandySet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] lr = new int[n][2];
		for (int i = 0; i < n; i++) {
			lr[i][0] = sc.nextInt();
			lr[i][1] = sc.nextInt();
		}
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++)
			dp[i][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int k = lr[i - 1][0]; k <= lr[i - 1][1] && j >= k; k++) {
					dp[i][j] += dp[i - 1][j - k];
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}
