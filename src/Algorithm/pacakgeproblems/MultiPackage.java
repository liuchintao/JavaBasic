package Algorithm.pacakgeproblems;

public class MultiPackage {

	static void getResult(int[] values, int[] weight, int[] nums, int volume) {
		int n = values.length;
		int[] vs = new int[n + 1];
		int[] ws = new int[n + 1];
		int[] dp = new int[volume + 1];
		for (int i = 1; i < n + 1; i++) {
			vs[i] = values[i - 1];
			ws[i] = weight[i - 1];
		}
		for(int i = 1; i < n + 1; i++) {
			for(int j = ws[i]; j < volume + 1; j++) {
				for(int k = 0; k < nums.length; k++) {
					if(j - k*ws[i] >= 0) {
						dp[j] = dp[j - k * ws[i]] + vs[i] > dp[j]?dp[j - k * ws[i]] + vs[i]:dp[j];
					}
				}
			}
		}
	}

	public static void main(String[] args) {

	}
}
