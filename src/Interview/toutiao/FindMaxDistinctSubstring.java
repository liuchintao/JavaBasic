package Interview.toutiao;

import java.util.HashSet;
import java.util.Set;

public class FindMaxDistinctSubstring {
	
	public static void main(String[] args) {
		FindMaxDistinctSubstring findMaxDistinctSubstring = new FindMaxDistinctSubstring();
		System.out.println(findMaxDistinctSubstring.solve("  "));
		System.out.println(findMaxDistinctSubstring.solve("1213"));
		System.out.println(findMaxDistinctSubstring.solve("11"));
		System.out.println(findMaxDistinctSubstring.solve("abcacbb"));
	}

	public int solveByBitMap(String str) {
		int[] bitmap = new int[256];
		for(int i = 0; i < 256; i++)
			bitmap[i] = -1;
		int maxlen = 0, start = -1;
		for(int i = 0; i < str.length(); i++) {
			if(bitmap[str.charAt(i)] > start)
				start = bitmap[str.charAt(i)];
			bitmap[str.charAt(i)] = i;
			maxlen = Math.max(maxlen, i - start);
		}
		return maxlen;
	}  
	
	public int solve(String str) {
		// Pass 40%
		if(str == null || str.length() == 0)
			return 0;
		if(str.length() == 1)
			return 1;
		Set<Character> characters = new HashSet<>();
		int maxIdx = 0, maxLength = 0, ri = maxIdx, clength = characters.size(), tmpLen = maxLength;
		while(maxIdx < str.length()) {
			if(ri >= str.length())
				break;
			characters.add(str.charAt(ri));
			if(characters.size() == clength + 1) {
				clength++;
				tmpLen++;
			}
			else {
				if(str.charAt(ri) != str.charAt(maxIdx)) {
					characters.remove(str.charAt(maxIdx));
					tmpLen--;
				}
				maxIdx++;
			}
			ri++;
			maxLength = maxLength > tmpLen ? maxLength:tmpLen;
		}
		return maxLength;
	}
	
	
}
