package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {

	public static List<Integer> getNext(String str) {
		List<Integer> ans = new ArrayList<Integer>();
		int j = 0;
		int k = -1;
		ans.add(-1);
		while(j < str.length() - 1) {
			if(k == -1 || str.charAt(j) == str.charAt(k)) {
				j++;
				k++;
				ans.add(k);
			}
			else
				k = ans.get(k);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String str = "abCabCabC";
		System.out.println(getNext(str));
	}
}
