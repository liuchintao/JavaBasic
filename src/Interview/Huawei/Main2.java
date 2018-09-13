package Interview.Huawei;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		String s = "7462464657722693758861902455673677472937653451007744809376392212931345812219613865483767182118420188";
		String s1= "727242657943845129863672215412493495871648943323";
		System.out.println(s1.length());
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] a = new int[num];
		int[] dp = new int[num];
		for (int i = 0; i < num; i++) {
			a[i] = in.nextInt();
			dp[i] = 0;
		}
		for (int i = 0; i < num; i++) {
			for (int j = 1; j <= a[j]; j++) {
				if (i + j < num) {
					if (dp[i + j] <= 0) {
						dp[i + j] = dp[i] + 1;
					} else if (dp[i] + 1 < dp[i + j]) {
						dp[i + j] = dp[i] + 1;
					}
				}
			}
		}
		System.out.println(dp[num-1]);
//		for (int i = 0; i < num; i++) {
//			for (int j = i; j <= a[i]; j++) {
//				if (i + j < num) {
//					if (dp[i + j] <= 0) {
//						dp[i + j] = dp[i] + 1;
//					} else if (dp[i] + 1 < dp[i + j]) {
//						dp[i + j] = dp[i] + 1;
//					}
//				}
//			}
//		}
//		System.out.println(dp[num - 1]);
	}

}
