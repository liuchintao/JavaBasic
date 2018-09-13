package Interview.baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CharacterGenerate {
	/**
	 * ��һ�����������������������ַ�L, R�����������L��R��Χ�ڵ����жԣ�pair���ַ���
	 * ���룺
	 * str����ʾ������������һϵ���ַ�
	 * str=cabcac
	 * pair����ʾL��R��ɵĶԵ�����
	 * pair=3
	 * rangeLR��һ�������б�ÿ��Ԫ�ذ���һ���ԣ���ʾ��������޺�����
	 * rangeLR=
	 * 1 6
	 * 1 3
	 * 2 5
	 * �����caa
	 * [1,6]c����������
	 * [1,3]��������һ��
	 * [2,5]a����������
	 * ������caa
	 * ����һ���ַ��б�����ض������е�һ�������ַ���Ƶ����ͬ���������ĸ˳����С���ַ�
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
