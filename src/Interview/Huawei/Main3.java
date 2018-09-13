package Interview.Huawei;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		solve(str1, str2);
	}

	private static void solve(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int[] s1 = new int[len1];
		int[] s2 = new int[len2];
		int[] ans = new int[len1 + len2];
		reverse(str1, str2, s1, s2);
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				ans[i + j] += s1[i] * s2[j];
			}
		}
		for (int i = 0; i < len1 + len2 - 1; i++) {
			ans[i + 1] += ans[i] / 10;
			ans[i] = ans[i] % 10;
		}
		char[] result = new char[ans.length];
		int j = 0;
		boolean flag = true;
		if(ans[len1 + len2 - 1] != 0)
			flag = false;
		for (int i = len1 + len2 - 1; i >= 0; i--) {
			if (ans[i] == 0 && flag) {
				flag = false;
				continue;
			}
			result[j] = (char) (ans[i] + 48);
			if(j == 46) {
				System.out.println("");
			}
			j++;
		}
		if(check(result)) {
			System.out.println(0);
			return;
		}
		System.out.println(result);
	}
	
	private static boolean check(char[] result) {
		int j = 0;
		for (int i = 0; i < result.length; i++) {
			if(result[i] == '0') {
				j++;
			}
		}
		if(j == result.length - 1) {
			return true;
		}	
		return false;
	}

	private static void reverse(String str1, String str2, int[] s1, int[] s2) {
		for (int i = s1.length - 1; i >= 0; i--)
			s1[s1.length - 1 - i] = str1.charAt(i) - 48;
		for (int i = s2.length - 1; i >= 0; i--)
			s2[s2.length - 1 - i] = str2.charAt(i) - 48;
	}
}
