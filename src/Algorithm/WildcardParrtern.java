package Algorithm;

public class WildcardParrtern {

	public static void main(String[] args) {
		String s1 = "aa";
		String p1 = "a";
		System.out.println(isMatched(s1, p1));
		String s2 = "aa";
		String p2 = "*";
		System.out.println(isMatched(s2, p2));
		String s3 = "cb";
		String p3 = "?a";
		System.out.println(isMatched(s3, p3));
		String s4 = "adceb";
		String p4 = "*a*b";
		System.out.println(isMatched(s4, p4));
		String s5 = "acdcb";
		String p5 = "a*c?b";
		System.out.println(isMatched(s5, p5));
		String s6 = "aa";
		String p6 = "a*";
		System.out.println(isMatched(s6, p6));
		String s7 = "aa";
		String p7 = "?*";
		System.out.println(isMatched(s7, p7));
		String s8 = "";
		String p8 = "*";
		String p81 = "?";
		System.out.println(isMatched(s8, p8));
		System.out.println(isMatched(s8, p81));
		String s9 = "a";
		String p9 = "a*";
		System.out.println(isMatched(s9, p9));
		String s10 = "a";
		String p10 = "aa";
		System.out.println(isMatched(s10, p10));
		String s11 = "c";
		String p11 = "*?*";
		// System.out.println(isMatch(s11, p11));
		System.out.println(isMatched(s11, p11));
	}

	private static boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		if (p.equals("*"))
			return true;
		if (s.length() == 0 && p.length() == 0)
			return true;
		int idx = s.length() - 1, i = p.length() - 1;
		for (; i >= 0 && idx >= 0;) {
			// p[i] = '*'
			if (p.charAt(i) == '*' && i - 1 >= 0) {
				while (true) {
					if (idx > 0 && s.charAt(idx - 1) != p.charAt(i - 1) && p.charAt(i - 1) != '?')
						idx--;
					else if (idx - 1 >= 0) {
						idx--;
						i--;
						break;
					} else {
						i--;
						break;
					}
				}
				continue;
			}
			if (p.charAt(i) == '*' && i - 1 < 0)
				return true;
			// p[i] = '?'
			if (p.charAt(i) == '?') {
				if (i > 0 && idx > 0) {
					idx--;
					i--;
					continue;
				}
				if (i == 0 && idx == i)
					return true;
				else
					return false;
			}
			// p[i] = [a-z]
			if (idx >= 0 && p.charAt(i) == s.charAt(idx)) {
				if (idx == 0 && i > 0) {
					i--;
					if (p.charAt(i) != '*')
						return false;
					break;
				} else if (idx == 0 && i == idx)
					return true;
				idx--;
				i--;
			} else
				return false;
		}
		if ((idx == i && i == 0) || (i == 0 && p.charAt(i) == '*'))
			return true;
		return false;
	}

	private static boolean isMatched(String s, String p) {
		if (s == null || p == null)
			return false;
		if (p.equals("*"))
			return true;
		int x = s.length() - 1, y = p.length() - 1;
		while (x >= 0 && y >= 0) {
			if (y == 0 && p.charAt(y) == '*')
				return true;
			if (p.charAt(y) >= 'a' && p.charAt(y) <= 'z')
				if (p.charAt(y) != s.charAt(x))
					return false;
				else {
					y--;
					x--;
					continue;
				}
			if (p.charAt(y) == '?') {
				y--;
				x--;
				continue;
			}
			if (p.charAt(y) == '*') {
				while (y >= 0) {
					if (p.charAt(y) == '?')
						if (x < 0)
							return false;
						else
							x--;
					if (p.charAt(y) >= 'a' && p.charAt(y) <= 'z')
						break;
					y--;
				}
				if (x < 0 && y < 0)
					return true;
				int x1 = 0;
				while (x1 < s.length() - 1)
					if (s.charAt(x1) == p.charAt(y))
						break;
					else
						x1++;
				if (x1 > x)
					return false;
				x = x1 - 1;
				y--;
			}
		}
		if (y == 0 && p.charAt(y) == '*')
			return true;
		if (x < 0 && y < 0)
			return true;
		return false;
	}

	private static boolean isMatchDP(String s, String p) {
		int x = s.length(), y = p.length();
		boolean[][] dp = new boolean[x + 1][y + 1];
		dp[x][y] = true;
		for(int i = y - 1; i >= 0; i--) 
			if(p.charAt(i) != '*')
				break;
			else
				dp[x][i] = true;
		for(int i = x - 1; i >= 0; i--)
			for(int j = y - 1; j >= 0; j--) {
				if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')
					dp[i][j] = dp[i+1][j+1];
				else if(p.charAt(j) == '*')
					dp[i][j] = dp[i+1][j]||dp[i][j+1];
			}
		return dp[0][0];
	}
}
