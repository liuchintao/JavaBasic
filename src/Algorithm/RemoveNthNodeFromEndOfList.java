package Algorithm;

public class RemoveNthNodeFromEndOfList {

	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			this.val = x;
		}
		@Override
		public String toString() {
			return String.valueOf(val);
		}
		
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode second=new ListNode(2);
		head.next = second;
		ListNode third= new ListNode(3);
		second.next=third;
		ListNode forth= new ListNode(4);
		third.next = forth;
		
//		removeNthFromEnd(head, 4);
		printList(removeNthFromEnd(head, 5));
	}
	
	private static ListNode removeNthFromEnd(ListNode node, int n) {
		ListNode node1 = node, node2 = node;
		int count = 0;
		while(node1.next != null) {
			node1 = node1.next;
			count++;
			if(count > n)
				node2 = node2.next;
		}
		if(count + 1 > n)
			node2.next = node2.next.next;
		else
			node = node.next;
		return node;
	}
	
	private static void printList(ListNode node) {
		ListNode listNode = node;
		while (listNode.next != null) {
			System.out.print(listNode.val + " ");
			listNode = listNode.next;
		}
		System.out.println(listNode.val);
	}

}
