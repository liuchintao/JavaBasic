package Interview.didi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MaxMagicStrength {
	/**
	 * 有一把魔法权杖，权杖上有n颗并排的法术石（编号为1到n）。每颗法术石具有一个能量值，权杖的法术强度等同于法术石的最小能量值。
	 * 权杖可以强化，一次强化可以将两颗相邻的法术石融合为一颗，融合后的能量值为这两颗法术石能量值之和。
	 * 现在有m次强化的机会，请问权杖能强化到的最大法术强度是多少？
	 * 第一行包含两个正整数n，m，表示n颗法术石，m次强化机会。
	 * 第二行为n个用空格隔开的正整数v1, v2, … ,vn，vi表示编号为i的法术石具有的能量值。
	 * 数据范围：1≤m<n≤100000，1≤vi≤100000
	 * 样例输入
	 * 6 3
	 * 1 7 2 2 5 9
	 * 样例输出
	 * 8
	 */
	// 此版本超时
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
