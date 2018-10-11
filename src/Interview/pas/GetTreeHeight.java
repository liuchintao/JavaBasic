package Interview.pas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class GetTreeHeight {

	static long max;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<Long, List<Long>> tree = new HashMap<>();
		long a, b, maxH = 0;
		while (scanner.hasNext()) {
			a = scanner.nextLong();
			b = scanner.nextLong();
			List<Long> children = tree.getOrDefault(a, new ArrayList<>());
			children.add(b);
			tree.put(a, children);
		}
		if (tree.size() <= 1) {
			System.out.println(tree.size());
			scanner.close();
			return;
		}
		Iterator<Entry<Long, List<Long>>> iterator = tree.entrySet().iterator();
		while (iterator.hasNext()) {
			visitTree(iterator.next().getKey(), tree, 1);
		}
		System.out.println(max);
		scanner.close();
	}

	private static void visitTree(long root, Map<Long, List<Long>> tree, long level) {
		List<Long> children = tree.get(root);
		if (children == null) {
			max = Math.max(max, level);
			return;
		}
		for (Long child : children) {
			visitTree(child, tree, level+1);
		}
		return;
	}
}
