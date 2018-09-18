package Interview.littlered;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NodePrePostFromLayerAndMid {
	
	/*
	 * 已知层序遍历和中序遍历，求前序遍历和后序遍历和叶子节点
	 * Input：
	 * 3 5 4 2 6 7 1（层序）
	 * 2 5 3 6 4 7 1（中序）
	 * Output：
	 * 2 6 1 （叶子）
	 * 3 5 2 4 6 7 1（前序） 
	 * 2 5 6 1 7 4 3 （后序）
	 */
	private static int idx = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String layer = scanner.nextLine();
		String mid = scanner.nextLine();
		String[] layNums = layer.split(" ");
		String[] midNums = mid.split(" ");
		int[] lNums = new int[layNums.length];
		int[] mNums = new int[midNums.length];
		for (int i = 0; i < layNums.length; i++) {
			lNums[i] = Integer.parseInt(layNums[i]);
			mNums[i] = Integer.parseInt(midNums[i]);
		}
		List<Integer> preOrder = new ArrayList<>();
		// layer: 0 to nums.size()/2 - 1;
		// mid : nums.size()/2 to nums.size() - 1;
		getPre(lNums, mNums, 0, 0, lNums.length - 1, mNums.length - 1, preOrder);
		List<Integer> postOrder = new ArrayList<>();
		int[] pre = new int[preOrder.size()];
		for(int i = 0; i < preOrder.size(); i++)
			pre[i] = preOrder.get(i);
		List<Integer> leaves = new ArrayList<>();
		getPost(pre, mNums, postOrder, leaves);
		for(Integer leave: leaves) {
			System.out.print(leave + " ");
		}
		System.out.println();
		for(Integer n: preOrder) {
			System.out.print(n + " ");
		}
		System.out.println();
		for(Integer n: postOrder) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	private static void getPost(int[] pre, int[] mid, List<Integer> postOrder, List<Integer> leaves) {
		if(mid.length == 0)
			return ;
		int root = pre[idx++];
		int i = 0;
		for(; i < mid.length; i++)
			if(mid[i] == root)
				break;
		int[] left = new int[i];
		int[] right= new int[mid.length - i - 1];
		int j = 0;
		for(; j < i; j++)
			left[j] = mid[j];
		for(j++; j < mid.length; j++)
			right[j - i - 1] = mid[j];
		if(left.length == 1)
			leaves.add(left[0]);
		if(right.length == 1)
			leaves.add(right[0]);
		getPost(pre, left, postOrder, leaves);
		getPost(pre, right, postOrder, leaves);
		postOrder.add(root);
	}

	private static void getPre(int[] lnums, int[] mnums, int l1, int l2, int r1, int r2, 
			List<Integer> preOrder) {
		int i = 0, j = 0;
		for (i = l1; i <= r1; i++) {
			boolean f = false;
			for (j = l2; j <= r2; j++) {
				if (lnums[i] == mnums[j]) {
					preOrder.add(lnums[i]);
					f = true;
					break;
				}
			}
			if (f)
				break;
		}
		if (j > l2)
			getPre(lnums, mnums, 0, l2, r1, j - 1, preOrder);
		if (j < r2)
			getPre(lnums, mnums, 0, j + 1, r1, r2, preOrder);
	}

}
