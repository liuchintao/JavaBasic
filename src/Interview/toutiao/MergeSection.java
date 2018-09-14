package Interview.toutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeSection {
	
	/**
	 * �༭�Ƿ�������������ʱ�����������ľ��ӵ������յ��ǳ�����[1,10]��ʾ��һ���ַ�����ʮ���ַ��ľ��������⣻
	 * [5,16]���Ժ�[1,10]�ϲ�Ϊ[1,16];
	 * ���룺
	 * 1,10;32,45
	 * 78,94;5,16
	 * 80,100;200,220;16,32
	 * �����
	 * 1,45;78,100;200,220
	 */
	
	public String mergeSection(String[] str, int m) {
		List<int[]> pairs = new ArrayList<>();
		for(String s: str) {
			String[] couples = s.split(";");
			for(String couple: couples) {
				String[] nums = couple.split(",");
				int[] pair = {Integer.parseInt(nums[0]),Integer.parseInt(nums[1])};
				pairs.add(pair);
			}
		}
		List<int[]> ans = getMergedSection(pairs);
		StringBuilder sBuilder = new StringBuilder();
		for(int[] pair: ans)
			sBuilder.append(pair[0] + "," + pair[1] + ";");
		return sBuilder.toString();
	}

	private List<int[]> getMergedSection(List<int[]> pairs) {
		if(pairs ==null || pairs.size() == 0)
			return null;
		Collections.sort(pairs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] > o2[0])
					return 1;
				else if(o1[0] < o2[0])
					return -1;
				return 0;
			}
		});
		List<int[]> ans = new ArrayList<>();
		ans.add(pairs.get(0));
		for(int i = 1; i < pairs.size(); i++) {
			int[] pair = pairs.get(i);
			int[] pre = ans.get(ans.size() - 1);
			if (pair[0] >= pre[0] && pair[0] <= pre[1]) {
				if(pair[1] >= pre[1]) {
					pair[0] = pre[0];
					ans.remove(ans.size() - 1);
					ans.add(pair);
				}
			}else
				ans.add(pair);
		}
		return ans;
	}
}
