package Algorithm;

public class FindPalindrome {

	public static void main(String[] args) {
		System.out.println(mathSolve(0));
		System.out.println(mathSolve(11));
		System.out.println(mathSolve(21));
		System.out.println(mathSolve(101));
		System.out.println(mathSolve(112));
		System.out.println(mathSolve(111));
	}
	
	private static boolean solve(int x) {
		if(x < 0)
			return false;
		char[] num = String.valueOf(x).toCharArray();
		int m = num.length >> 1;
		for(int i = m -1; i >= 0; i--) {
			if(num[i] == num[num.length -1 - i])
				continue;
			else
				return false;
		}
		return true;
	}
	
	private static boolean mathSolve(int x) {
		if(x < 0)
			return false;
		int palindrome = 0, temp = x, pop = 0;
		while(temp != 0) {
			pop = temp % 10;
			temp /= 10;
			palindrome = palindrome * 10 + pop; 
		}
		return palindrome == x;
	}

}
