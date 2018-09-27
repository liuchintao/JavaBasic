package Algorithm;

public class GetPermutation60 {

	int count = 1;
	long ans;

	public String getPermutation(int n, int k) {
		char[] nums = new char[n];
		for (int i = 0; i < n; i++)
			nums[i] = (char) (i + '1');
		ans = Long.parseLong(String.valueOf(nums));
//		countKthPermutation(nums, 0, k);
		System.out.println(getPermutationByLeetCode(n,k));
		return String.valueOf(ans);
	}

	private void countKthPermutation(char[] nums, int begin, int k) {
		// Wrong answer
		// 不能保证全排列数组中的元素是按字典大小产生的；
		if (begin == nums.length) {
			System.out.println(count + ": " + String.valueOf(nums));
		}
		if (k == 1) {
			return;
		}
		if (count < k) {
			long tmp = Long.parseLong(String.valueOf(nums));
			if (tmp > ans) {
				ans = tmp;
				count++;
			}
		}
		for (int i = begin; i < nums.length; i++) {
			char tmp = nums[i];
			nums[i] = nums[begin];
			nums[begin] = tmp;
			countKthPermutation(nums, begin + 1, k);
			tmp = nums[i];
			nums[i] = nums[begin];
			nums[begin] = tmp;
		}
	}

	private String getPermutationByLeetCode(int n, int k) {
		int i, j, f = 1;
		char[] ans = new char[n];
		for (i = 1; i <= n; i++) {
			f *= i;
			ans[i-1] = (char) ('0' + i);
		}
		for(i = 0, k--; i < n; i++) {
			f /= n - i;
			j = i + k/f;// calculate index of char to put at s[i]
			char c = ans[j];
			for(;j > i; j--)
				// remove c by shifting to cover up (adjust the right part).
				ans[j] = ans[j - 1];
			k%=f;
			ans[i] = c;
		}
		return String.valueOf(ans);
	}

}
