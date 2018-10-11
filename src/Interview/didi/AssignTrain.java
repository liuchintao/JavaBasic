package Interview.didi;

import java.util.Scanner;
import java.util.Stack;

public class AssignTrain {
	/**
	 * 判断出栈顺序是否正确
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] trains = new int[4];
		for (int i = 0; i < 4; i++)
			trains[i] = scanner.nextInt();
		int[] push = {1,2,3,4};
		if(IsPopOrder(push, trains))
			System.out.println("Yse");
		else
			System.out.println("No");
			
	}

	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		int j = 0;
		st.push(pushA[i++]);
		for (;j < popA.length;j++) {
			while (popA[j] != st.peek()) {
				if (i == pushA.length)
					return false;
				st.push(pushA[i++]);
			}
			st.pop();
		}
		if(!st.empty())
			return false;
		return true;
	}
}
