package Interview.Tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportantCity {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		boolean[][] roads = new boolean[n + 1][n + 1];
		int[] cityOutNum = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			roads[from][to] = true;
			cityOutNum[from]++;
		}
		int[] cityInNum = new int[n + 1];
		List<List<Integer>> paths = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			List<Integer> path = new ArrayList<>();
			iterateCities(roads, i, path);
			paths.add(path);
		}
		for(List<Integer> path: paths) {
			for(Integer city: path)
				cityInNum[city]++;
		}
		int count = 0;
		for(int i = 1; i <= n; i++) {
			if(cityOutNum[i] < cityInNum[i])
				count++;
		}
		System.out.println(count);
	}

	private static void iterateCities(boolean[][] roads, int i, List<Integer> path) {
		path.add(i);
		for (int idx = 1; idx < roads.length; idx++) {
			if (roads[i][idx]) {
				iterateCities(roads, idx, path);
				if (path.contains(idx))
					continue;
			}
		}
	}

}
