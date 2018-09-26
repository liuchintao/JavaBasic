package datastructure.list;

public class SwapNodesInPairs_24 {
	/*
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * Your algorithm should use only constant extra space.
	 * You may not modify the values in the list's nodes, only nodes itself may be changed.
	 */
	
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null)
		    return head;
		ListNode p = head.next, h = head.next, q = head;
		ListNode tmp, pre = head;
		int count = 0;
		while(true) {
			count++;
			tmp = p.next;
			p.next = q;
			q.next = tmp;
			if(count > 1)
				pre.next = p;
			if(tmp == null || tmp.next == null)
				break;
			pre = q;
			q = tmp;
			p = tmp.next;
		}
		return h;
	}
}
