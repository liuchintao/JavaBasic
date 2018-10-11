package Interview.didi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MaxMagicStrength {
	/**
	 * ��һ��ħ��Ȩ�ȣ�Ȩ������n�Ų��ŵķ���ʯ�����Ϊ1��n����ÿ�ŷ���ʯ����һ������ֵ��Ȩ�ȵķ���ǿ�ȵ�ͬ�ڷ���ʯ����С����ֵ��
	 * Ȩ�ȿ���ǿ����һ��ǿ�����Խ��������ڵķ���ʯ�ں�Ϊһ�ţ��ںϺ������ֵΪ�����ŷ���ʯ����ֵ֮�͡�
	 * ������m��ǿ���Ļ��ᣬ����Ȩ����ǿ�����������ǿ���Ƕ��٣�
	 * ��һ�а�������������n��m����ʾn�ŷ���ʯ��m��ǿ�����ᡣ
	 * �ڶ���Ϊn���ÿո������������v1, v2, �� ,vn��vi��ʾ���Ϊi�ķ���ʯ���е�����ֵ��
	 * ���ݷ�Χ��1��m<n��100000��1��vi��100000
	 * ��������
	 * 6 3
	 * 1 7 2 2 5 9
	 * �������
	 * 8
	 */
	// �˰汾��ʱ
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		List<Integer> stones = new LinkedList<>();
		for (int i = 0; i < n; i++)
			stones.add(scanner.nextInt());
		for (int i = 0; i < m; i++) {
			process(stones);
		}
		int min = stones.get(0);
		for(Integer stone: stones)
			min = stone < min ? stone:min;
		System.out.println();
	}

	private static int process(List<Integer> stones) {
		if (stones.size() == 1)
			return stones.get(0);
		int min = stones.get(0) + stones.get(1), idx = 1, f = -1;
		for (int i = 1; i < stones.size() - 1; i++)
			if (min > stones.get(i) + stones.get(i + 1)) {
				min = stones.get(i) + stones.get(i + 1);
				idx = i;
				f = 1;
			}
		stones.set(idx, stones.get(idx) + stones.get(idx+f));
		stones.remove(idx + f);
		return min;
	}
}
