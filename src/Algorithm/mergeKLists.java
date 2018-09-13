package Algorithm;

public class mergeKLists {

	static int count;
	
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}
	
	private static void printList(ListNode head) {
		ListNode node = head;
		while (node.next!=null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(node.val);
	}
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode node12= new ListNode(4);
		head1.next = node12;
		ListNode node13= new ListNode(5);
		node12.next= node13;
		
		ListNode head2 = new ListNode(1);
		ListNode node21= new ListNode(3);
		head2.next = node21;
		ListNode node22= new ListNode(4);
		node21.next= node22;
		
		ListNode head3 = new ListNode(2);
		ListNode node31= new ListNode(6);
		head3.next = node31;
		
		ListNode[] lists = {head1, head2, head3};
		printList(mergeLists(lists));
//		printList(partition(lists, 0, lists.length - 1));
		System.out.println(count);
	}
	
	private static ListNode mergeLists(ListNode[] lists) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		while (true) {
			int nullCount = 0, idx = -1;
			while (++idx < lists.length && lists[idx] == null) {
				nullCount++;
				count++;
			}
			if (nullCount == lists.length)
				break;
			int min = lists[idx].val;
			for(int i = idx; i < lists.length; i++) {
				count++;
				if (lists[i] == null) {
					nullCount++;
					continue;
				}
				if (min > lists[i].val) {
					idx = i;
					min = lists[i].val;
				}
			}
			p.next = lists[idx];
			p = p.next;
			lists[idx] = lists[idx].next;
		}
		return head.next;
	}
	
	private static ListNode partition(ListNode[] lists, int s, int e) {
		if(s == e)
			return lists[s];
		if(s < e) {
			int q = (s + e) / 2;
			ListNode l1 = partition(lists, s, q);
			ListNode l2 = partition(lists, q + 1, e);
			return merge(l1, l2);
		}else
			return null;
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null)	return l2;
		if(l2 == null)	return l1;
		if(l1.val < l2.val) {
			count++;
			l1.next = merge(l1.next, l2);
			return l1;
		}else {
			count++;
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
}
