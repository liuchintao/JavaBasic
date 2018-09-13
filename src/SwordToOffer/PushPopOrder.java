package SwordToOffer;

import java.util.ArrayList;
import java.util.List;

public class PushPopOrder {

	public boolean isPopOrder(int[] pushA, int[] popA) {
		List<Integer> stack = new ArrayList<>();
		int length = pushA.length;
		int popIdx = 0;
		int i = 0;
		for(; i < length; i++) {
			if(pushA[i] != popA[popIdx]) {
				int size = stack.size();
				if(size > 0 && stack.get(size - 1) == popA[popIdx]) {
					stack.remove(size-1);
					popIdx++;
				}
				stack.add(pushA[i]);
				continue;
			}
			popIdx++;
		}
		if(stack.size() == 0)
			return true;
		while(popIdx < length) {
			int size = stack.size();
			if(popA[popIdx] == stack.get(size - 1))
				stack.remove(size - 1);
			else if(popA[popIdx] != stack.get(size - 1))
				return false;
			popIdx++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] push = {1,2,3,4,5};
		int[] pop1 = {4,5,3,2,1};
		int[] pop2 = {4,5,3,1,2};
		int[] pop3 = {4,3,5,2,1};
		PushPopOrder ppo = new PushPopOrder();
		System.out.println(ppo.isPopOrder(push, pop1));
		System.out.println(ppo.isPopOrder(push, pop2));
		System.out.println(ppo.isPopOrder(push, pop3));
	}
}
