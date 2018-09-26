package datastructure.list.test;

import datastructure.list.ListNode;
import datastructure.list.SwapNodesInPairs_24;
import junit.framework.TestCase;

public class TestSwapNodesInPairs_24 extends TestCase {
	
	private SwapNodesInPairs_24 swap = new SwapNodesInPairs_24();
	
	public void testSwapNodesWith4Nodes() {
		ListNode head = ListNodeGenerator.getEasyList(4);
		ListNode ans = swap.swapPairs(head);
		while(ans != null) {
			System.out.print(ans + " ");
			ans = ans.getNext();
		}
	}
	
	public void testSwapNodesWith2Nodes() {
		ListNode head = ListNodeGenerator.getEasyList(2);
		ListNode ans = swap.swapPairs(head);
		while(ans != null) {
			System.out.print(ans + " ");
			ans = ans.getNext();
		}
	}
	
	public void testSwapNodesWith5Nodes() {
		ListNode head = ListNodeGenerator.getEasyList(5);
		ListNode ans = swap.swapPairs(head);
		while(ans != null) {
			System.out.print(ans + " ");
			ans = ans.getNext();
		}
	}
	
	public void testSwapNodesWith1Nodes() {
		ListNode head = ListNodeGenerator.getEasyList(1);
		ListNode ans = swap.swapPairs(head);
		while(ans != null) {
			System.out.print(ans + " ");
			ans = ans.getNext();
		}
	}
}
