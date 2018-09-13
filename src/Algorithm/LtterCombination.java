package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class LtterCombination {

	public static void main(String[] args) {
		System.out.println(letterCombination("237"));
		System.out.println(letterCombination("2"));
	}

	private static List<String> letterCombination(String digits) {
		List<String> ans = new ArrayList<>();
		if(digits == null || digits.length() == 0 )
			return ans;
		char[] character = new char[digits.length()];
		char[][] letters = {{ 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
				{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }};
		int[] life = new int[digits.length()];
		int resetZero = 0;
		int num = -1;
		for(int i = 0; i < digits.length();) {
			if (i == digits.length() - 1) {
				num = digits.charAt(i) - '2';
				while (life[i] < letters[num].length) {
					character[i] = letters[num][life[i]];
					life[i]++;
					ans.add(String.valueOf(character));
				}
				for(int j = digits.length() - 1; j >= 0; j--)
					if(life[j] == letters[digits.charAt(j) - '2'].length)
						resetZero++;
					else
						break;
				if(resetZero == digits.length())
					break;
				for(int j = 0; j < resetZero; j++)
					life[digits.length() - 1 - j] = 0;
				i -= resetZero;
				resetZero = 0;
			}
			num = digits.charAt(i) - '2';
			character[i] = letters[num][life[i]];
			life[i]++;
			i++;
		}
		return ans;
	}

}
