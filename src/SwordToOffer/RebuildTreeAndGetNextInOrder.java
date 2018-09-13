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
		public MyBiTree(int val) {
			this.value = val;
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

	public static MyBiTree ReBuildCore(int[] in, int[] pre, int len) throws Exception {
		MyBiTree root = new MyBiTree(pre[0]);
        if(pre[0] == pre[len - 1] && in[0] == in[len - 1] && in[0] == pre[0])
            return root;
        int rootValIn = in[0];
        int i = 0;
        while(rootValIn != root.value){
            i++;
            rootValIn = in[i];
        }
        int leftLen = i;
        if(leftLen > 0){
            int[] newPre = new int[leftLen];
            for(i = 0; i < leftLen; i++)
                newPre[i] = pre[i + 1];
            int[] newIn = new int[leftLen];
            for(i = 0; i < leftLen; i++)
                newIn[i] = in[i];
            root.left = ReBuildCore(newIn, newPre, leftLen);
        }
        if(leftLen < len - 1){
            int[] newPre = new int[len - 1 - leftLen];
            for(i = 0; i < len - 1 - leftLen; i++)
                newPre[i] = pre[leftLen + i + 1];
            int[] newIn = new int[len - 1 - leftLen];
            for(i = 0; i < len - 1 - leftLen; i++)
                newIn[i] = in[leftLen + 1 + i];
            root.right = ReBuildCore(newIn, newPre, len - 1 - leftLen);
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
//		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
//		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		int[] pre = {1,2,4,3,5,6};
		int[] in = {4,2,1,5,3,6};
		try {
			MyBiTree t = ReBuild(in, pre, in.length);
			inOrderPrint(t);
			postOrderPrint(t);
			System.out.println(getNextInOrderNode(t));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
