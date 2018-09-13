package Interview.baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CharacterGenerate {
	/**
	 * 有一个机器，给机器输入两个字符L, R，可以输出在L和R范围内的所有对（pair）字符。
	 * 输入：
	 * str：表示最初输入机器的一系列字符
	 * str=cabcac
	 * pair：表示L和R组成的对的数量
	 * pair=3
	 * rangeLR：一个整数列表，每个元素包含一个对，表示输入的上限和下限
	 * rangeLR=
	 * 1 6
	 * 1 3
	 * 2 5
	 * 输出：caa
	 * [1,6]c出现了三次
	 * [1,3]各出现了一次
	 * [2,5]a出现了两次
	 * 所以是caa
	 * 返回一个字符列表，如果特定输入中的一个以上字符的频率相同，则输出字母顺序最小的字符
	 */
	public char[] rangeFrequent(String str, int pair, int[][] rangeLR) {
		char[] ans = new char[pair];
		Map<Character, List<Integer>> chars = new HashMap<>();
		for(int i = 0; i < str.length(); i++) {
			List<Integer> loc = chars.get(str.charAt(i));
			if(loc == null) 
				loc = new ArrayList<>();
			loc.add(i);
			chars.put(str.charAt(i), loc);
		}
		for(int i = 0; i < pair; i++) {
			if(i >= rangeLR.length)
				break;
			ans[i] = checkChar(chars, rangeLR[i]);
		}
		return ans;
	}

	private char checkChar(Map<Character, List<Integer>> chars, int[] lr) {
		char ans = 0;
		int max = 0, num = max;
		for(Entry<Character, List<Integer>> ch: chars.entrySet()) {
			List<Integer> nums = ch.getValue();
			num = 0;
			for(Integer n: nums)
				if(n < lr[0]-1 || n > lr[1]-1)
					break;
				else
					num++;
			if(num > max) {
				max = num;
				ans = ch.getKey();
			}
			else if(num == max && ans > ch.getKey())
				ans = ch.getKey();
		}
		return ans;
	}
	
}
