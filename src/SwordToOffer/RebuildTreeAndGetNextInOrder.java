package SwordToOffer;

import java.util.Stack;

public class RebuildTreeAndGetNextInOrder {
	public static class MyBiTree {
		MyBiTree parent;
		MyBiTree left;
		MyBiTree right;
		int value;

		@Override
		public String toString() {
			return "MyBiTree value=" + value;
		}

	}

	public static void postOrderPrint(MyBiTree t) {
		Stack<MyBiTree> stack = new Stack<MyBiTree>();
		StringBuffer sb = new StringBuffer();
		if (t == null)
			return;
		MyBiTree temp;
		MyBiTree pre = null;
		stack.push(t);
		while (!stack.isEmpty()) {
			temp = stack.pop();
			if ((temp.left == null && temp.right == null) ||
					(pre != null && (pre == temp.left || pre == temp.right))) {
				sb.append(temp.value);
				sb.append(" ");
				pre = temp;
			}
			else {
				stack.push(temp);
				if(temp.right != null)
					stack.push(temp.right);
				if(temp.left != null)
					stack.push(temp.left);
			}
		}
		System.out.println(sb);
	}

	public static void inOrderPrint(MyBiTree t) {
		Stack<MyBiTree> stack = new Stack<MyBiTree>();
		StringBuffer sb = new StringBuffer();
		if (t == null) {
			return;
		}
		MyBiTree temp = t;
		while (temp != null || !stack.empty()) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			if (!stack.isEmpty()) {
				temp = stack.pop();
				sb.append(temp.value);
				sb.append(" ");
				temp = temp.right;
			}
		}
		System.out.println(sb);
	}

	public static MyBiTree ReBuild(int[] inOrder, int[] preOrder, int len) throws Exception {
		if (inOrder == null || preOrder == null || len <= 0) {
			return null;
		}
		return ReBuildCore(inOrder, preOrder, len);
	}

	public static MyBiTree ReBuildCore(int[] inOrder, int[] preOrder, int len) throws Exception {
		if (inOrder.length == 0 && preOrder.length == 0)
			return null;
		int rootValue = preOrder[0];
		MyBiTree root = new MyBiTree();
		root.value = rootValue;
		root.left = root.right = null;
		if (preOrder[0] == preOrder[len - 1]) {
			if (inOrder[0] == inOrder[len - 1] && inOrder[0] == preOrder[0])
				return root;
			else
				throw new Exception("Invalid Input");
		}
		int rootInOrder = inOrder[0];
		int i = 0;
		while (i < len && rootInOrder != rootValue) {
			++i;
			rootInOrder = inOrder[i];
		}
		if (rootInOrder == inOrder[len - 1] && rootInOrder != rootValue) {
			throw new Exception("Invalid Input");
		}
		int leftLen = i;
		if (leftLen > 0) {
			int[] newPre = new int[leftLen];
			for (int j = 1; j < leftLen + 1; j++) {
				newPre[j - 1] = preOrder[j];
			}
			int[] newIn = new int[leftLen];
			for (int j = 0; j < leftLen; j++) {
				newIn[j] = inOrder[j];
			}
			root.left = ReBuildCore(newIn, newPre, leftLen);
			if(root!= null && root.left != null)
				root.left.parent = root;
		}
		if (leftLen < preOrder.length) {
			int[] newPre = new int[len - 1 - leftLen];
			for (int j = leftLen + 1; j < len; j++) {
				newPre[j - leftLen - 1] = preOrder[j];
			}
			int[] newIn = new int[len - 1 - leftLen];
			for (int j = leftLen + 1; j < len; j++) {
				newIn[j - leftLen - 1] = inOrder[j];
			}
			root.right = ReBuildCore(newIn, newPre, len - leftLen - 1);
			if(root != null && root.right != null)
				root.right.parent = root;
		}
		return root;
	}

	public static MyBiTree getNextInOrderNode(MyBiTree t) {
		MyBiTree ans = null;
		MyBiTree temp = t;
		if(temp.right != null) {
			MyBiTree tR = temp.right;
			while(tR.left != null) {
				tR = tR.left;
			}
			ans = tR;
		}
		else if(temp.parent != null) {
			MyBiTree parent = temp.parent;
			MyBiTree current = temp;
			while(parent != null && current == parent.right) {
				current = parent;
				parent = parent.parent;
			}
			ans = parent;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		try {
			MyBiTree t = ReBuild(in, pre, 8);
			inOrderPrint(t);
			postOrderPrint(t);
			System.out.println(getNextInOrderNode(t));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
