package Algorithm;

class MergeLinkedList {

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(4);
		ln1.next = ln2;
		ln2.next = ln3;
		ListNode ln4 = new ListNode(1);
		ListNode ln5 = new ListNode(3);
		ListNode ln6 = new ListNode(4);
		ListNode ln7 = new ListNode(8);
		ListNode ln8 = new ListNode(9);
		ln4.next = ln5;
		ln5.next = ln6;
		ln6.next = ln7;
		ln7.next = ln8;
		ListNode l = mergeTwoLists1(ln1, ln4);
		while (l != null) {
			System.out.print(l);
			l = l.next;
		}
		System.out.println("");
		ListNode l1 = null;
		ListNode l2 = new ListNode(0);
		l = mergeTwoLists1(l1, l2);
		while (l != null) {
			System.out.print(l);
			l = l.next;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return val + " ";
		}
	}

	public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
				p = p.next;
			} else {
				p.next = l2;
				l2 = l2.next;
				p = p.next;
			}
		}
		if (l1 != null)
			p.next = l1;
		if (l2 != null)
			p.next = l2;
		return head.next;
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			System.out.print("Invalid.");
			return null;
		}
		ListNode t1 = l1;
		ListNode t2 = l2;
		ListNode ans = null;
		ListNode head = null;
		while (t1 != null && t2 != null) {
			if (t1.val <= t2.val) {
				if (ans == null) {
					ans = t1;
					head = ans;
				} else {
					ans.next = new ListNode(t1.val);
					ans = ans.next;
				}
				t1 = t1.next;
			} else {
				if (ans == null) {
					ans = t2;
					head = ans;
				} else {
					ans.next = new ListNode(t2.val);
					ans = ans.next;
				}
				t2 = t2.next;
			}
		}
		if (t1 != null) {
			if (ans == null) {
				ans = t1;
			} else {
				ans.next = t1;
			}
		} else if (t2 != null) {
			if (ans == null) {
				ans = t2;
			} else {
				ans.next = t2;
			}
		}
		return head;
	}
}