package Algorithm;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abbac"));
		System.out.println(longestPalindrome("abba"));
		System.out.println(longestPalindrome("abbc"));
		System.out.println(reverseMethod("aaaa"));
	}
	
	private static String longestPalindrome(String s) {
		if(s == null || s.isEmpty())
			return "";
		int left = 0, right = 0, max = 1;
		for(int i = 0; i < s.length(); i++) {
			int oddLeft = i - 1, oddRight = i + 1, odd = 0;
			int evenLeft= i, evenRight = i + 1, even = 0;
			boolean oddF = false, evenF = false;
			while(oddLeft < oddRight && oddLeft >= 0 && oddRight < s.length()) 
				if(s.charAt(oddLeft) == s.charAt(oddRight)) {
					odd = oddRight - oddLeft + 1;
					oddLeft--;
					oddRight++;
					oddF = true;
				}else {
					oddF = false;
					oddLeft++;
					oddRight--;
					odd = oddRight - oddLeft + 1;
					break;
				}
			while(evenLeft < evenRight && evenLeft >= 0 && evenRight < s.length())
				if(s.charAt(evenRight) == s.charAt(evenLeft)) {
					even = evenRight - evenLeft + 1;
					evenF = true;
					evenLeft--;
					evenRight++;
				}else {
					evenF = false;
					evenLeft++;
					evenRight--;
					even = evenRight - evenLeft + 1;
					break;
				}
			if(odd > even && odd > max) {
				if(oddF) {
					oddRight--;
					oddLeft++;
				}
					max = odd;
					left = oddLeft;
					right = oddRight;	
				}else if(even > odd && even > max) {
					if(evenF) {
						evenRight--;
						evenLeft++;
					}
					max = even;
					left = evenLeft;
					right= evenRight;
			}
		}
		return s.substring(left, right + 1);
	}
	
	private static String reverseMethod(String s) {
		if(s == null && s.isEmpty())
			return "";
		int max = 0;
		for(int i = 0; i < s.length() >> 1; i++) {
			int j = i >> 1;
			for(; j >= 0 && j <= i; j--) {
				if(j - 1 > 0 && s.charAt(j - 1) == s.charAt(j))
					continue;
				else
					break;
			}
			max = (i - j) * 2 > max ? (i - j) * 2: max;
		}
		return null;
	}

}
