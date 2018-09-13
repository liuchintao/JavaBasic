package Algorithm;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = {4,2,4,1,3};
		solve(height);
		solveTimeN(height);
		int[] height1 = {1,8,6,2,5,4,8,3,7};
		solve(height1);
		solveTimeN(height1);
		int[] height2 = {1,1};
		solve(height2);
		solveTimeN(height2);
	}

	private static void solve(int[] height) {
		int[] dp = new int[height.length];
		int min;
		for(int i = 0; i < height.length; i++) {
			for(int j = 0; j < height.length; j++) {
				if(i+j<height.length) {
					min = height[j]<height[j+i]?height[j]:height[j+i];
					dp[j] = dp[j]<min*i?min*i:dp[j];
					if(j >= 1)
						dp[j] = dp[j]<dp[j-1]?dp[j-1]:dp[j];
				}else
					if(j >= 1)
					    dp[j] = dp[j - 1]>dp[j]? dp[j-1]:dp[j];
			}
		}
		System.out.println(dp[height.length-1]);
	}
	
	private static void solveTimeN(int[] height) {
		int i = 0, j = height.length - 1, maxArea = 0;
		while(i < j) {
			maxArea = maxArea > (j - i) * Math.min(height[i], height[j])? maxArea:(j - i) * Math.min(height[i], height[j]);
			if(height[i] < height[j]) {
				i++;
				continue;
			}else {
				j--;
				continue;
			}
		}
		System.out.println(maxArea);
	}

}
