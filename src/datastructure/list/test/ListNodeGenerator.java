package datastructure.list.test;

import datastructure.list.ListNode;

public class ListNodeGenerator {
	
	public static ListNode getEasyList(int n) {
		if(n <= 0)
			return null;
		ListNode head = new ListNode(0), p = head;
		for(int i = 1; i <= n; i++) {
			p.setNext(new ListNode(i));
			p = p.getNext();
		}
		return head.getNext();
	}
}
