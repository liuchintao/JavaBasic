package Interview.Huawei;

//public class Main1 {
//
//	static void solution(String str) {
//		int len = str.length();
//		if (len == 0) {
//			System.out.println("");
//			return;
//		}
//		char[] ans = new char[len];
//		Map<Character, Integer> map = new HashMap<Character, Integer>();
//		for (int i = 0; i < len; i++) {
//			Integer val = map.get(str.charAt(i));
//			if (val == null) {
//				val = 0;
//			}
//			val++;
//			map.put(str.charAt(i), val);
//		}
//		char[] temp = new char[map.size()];
//		int i = 0;
//		for (Character c : map.keySet()) {
//			temp[i] = c;
//			i++;
//		}
//		sort(temp, 0, i - 1);
//		for (i = 0; i < len;) {
//			for(int j = 0; j < map.size(); j++) {
//				int times = map.get(temp[j]);
//				if(times > 0) {
//					ans[i] = temp[j];
//					map.put(temp[j], times - 1);
//					i++;
//				}
//			}
//		}
//		System.out.println(ans);
//	}
//
//	private static void sort(char[] temp, int low, int high) {
//		if (low < high) {
//			int loc = partition(temp, low, high);
//			sort(temp, low, loc - 1);
//			sort(temp, loc + 1, high);
//		}
//
//	}
//
//	private static int partition(char[] temp, int low, int high) {
//		int i = temp[low];
//		while (low < high) {
//			while (low < high && temp[high] >= i)
//				high--;
//			char t = temp[low];
//			temp[low] = temp[high];
//			temp[high] = t;
//			while (low < high && temp[low] <= i)
//				low++;
//			t = temp[low];
//			temp[low] = temp[high];
//			temp[high] = t;
//		}
//		return low;
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
//		solution(str);
//	}
//}
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
        if(str.length() == 0) {
			System.out.println("");
			return;
		}
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for(int i = 0; i < str.length(); i ++) {
			char c = str.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				int sum = map.get(c);
				map.put(c, sum + 1);
			}
		}
		boolean flag = true;
		while(flag) {
			for(Entry<Character, Integer> entry : map.entrySet()) {
				if(entry.getValue() > 0) {
					flag = true;
					System.out.print(entry.getKey());
				} else {
					flag = false;
				}
				entry.setValue(entry.getValue() - 1);
			}
		}
	}
}
