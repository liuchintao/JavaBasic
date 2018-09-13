package Algorithm.pacakgeproblems;

public class CompletePackage {

	static void getResult(int[] values, int[] weight, int volume) {
		int n = values.length;
		int[] vs = new int[n + 1];
		int[] ws = new int[n + 1];
		int[] dp = new int[volume + 1];
		for (int i = 1; i < n + 1; i++) {
			vs[i] = values[i - 1];
			ws[i] = weight[i - 1];
		}
		for (int i = 1; i < n + 1; i++) {
			for(int j = ws[i]; j <= volume; j++) {
				dp[j] = dp[j - ws[i]] + vs[i] > dp[j]? dp[j - ws[i]] + vs[i]: dp[j];
			}
		}
		System.out.println(dp[volume]);
	}

	public static void main(String[] args) {
		int[] values = {1,2,3,4,5};
		int[] weight = {5,4,3,2,1};
		int volume = 10;
		getResult(values, weight, volume);
	}
}
