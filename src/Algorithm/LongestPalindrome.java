package Algorithm;

public class LongestPalindrome {

	public static void getLongestSubSequence(String str) {
		int len = str.length();
		if (len == 0) {
			System.out.println("0");
			return;
		}
		char[] cs = str.toCharArray();
		int dp[][] = new int[len][len];
		for (int i = len - 1; i >= 0; i--) {
			dp[i][i] = 1;
			for (int j = i + 1; j < len; j++) {
				if (cs[i] == cs[j])
					dp[i][j] = dp[i + 1][j - 1] + 2;
				else
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
			}
		}
		System.out.println(dp[0][len - 1]);
	}

	public static void getLongestSubSequenceNoDp(String str) {
		int len = str.length();
		if (len == 0) {
			System.out.println("Method Without DP: 0");
			return;
		}
		char[] cs = str.toCharArray();
		int i = 0;
		int max = 0, temp = 0;
		int x, y;
		while (i < len) {
			// Set center at gap between the cs[i] and cs[i + 1];
			x = i;
			y = i + 1;
			temp = 0;
			while (x >= 0 && y < len) {
				if (cs[x] == cs[y]) {
					temp += 2;
					x --;
					y ++;
				}
				else {
					break;
				}
			}
			max = temp > max ? temp: max;
			// Set center at cs[i];
			temp = 1;
			x = i - 1;
			y = i + 1;
			while(x >= 0 && y < len) {
				if(cs[x] == cs[y]) {
					temp += 2;
					x--;
					y++;
				}
				else {
					break;
				}
			}
			max = temp > max ? temp: max;
			i ++;
		}
		System.out.println("Method Without DP: " + max);
	}

	public static void main(String[] args) {
		String str1 = "";
		String str2 = "abs";
		String str3 = "abba";
		String str4 = "gocdogle";
		String str5 = "tesAbbAd";
		getLongestSubSequence(str1);
		getLongestSubSequence(str2);
		getLongestSubSequence(str3);
		getLongestSubSequence(str4);
		getLongestSubSequence(str5);
		
		getLongestSubSequenceNoDp(str1);
		getLongestSubSequenceNoDp(str2);
		getLongestSubSequenceNoDp(str3);
		getLongestSubSequenceNoDp(str4);
		getLongestSubSequenceNoDp(str5);
	}
}
