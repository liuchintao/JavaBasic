package Interview.toutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WOWPackage {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int account = scanner.nextInt();
//		int pkg = scanner.nextInt();
//		List<int[]> arms = new ArrayList<>();
//		while(scanner.hasNext()) {
//			int[] arm = new int[2];
//			arm[0] = scanner.nextInt();
//			arm[1] = scanner.nextInt();
//		}
		List<int[]> arms = new ArrayList<>();
		int account = 130;
		int pkg = 3;
		int[] a = {100,380};
		int[] b = {20, 320};
		int[] c = {40, 360};
		int[] d = {50, 310};
		Collections.addAll(arms, a,b,c,d);
		int n = arms.size();
		int[][] dp = new int[pkg + 1][n + 1];
		for(int i = 1; i <= pkg; i++) {
			int tmpAccount = account;
			for(int j = 1; j <= n; j++) {
				if(tmpAccount - arms.get(j - 1)[0] < 0) {
					dp[i][j] = dp[i - 1][j - 1];
					continue;
				}
				tmpAccount -= arms.get(j - 1)[0];
				int tmp = dp[i][j - 1] + arms.get(j - 1)[1];
				dp[i][j] = tmp > dp[i - 1][j] ? tmp: dp[i - 1][j];
			}
		}
		System.out.println(dp[pkg][n]);
	}

}
