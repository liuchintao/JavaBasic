package SwordToOffer;

public class VisitListK {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
//		System.out.println(FindKthToTail(head, 1).val);
//		ListNode newNode = ReverseList(head);
//		System.out.println(newNode.val);
		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(6);
		ListNode newHead = Merge(head,head2);
		System.out.println(newHead.val);
	}
	
	public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head, p;
        if(list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }
        p = head;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            }else{
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
        }
        if(list1 != null)
            p.next = list1;
        if(list2 != null)
            p.next = list2;
        return head;
    }
	
	public static ListNode FindKthToTail(ListNode head,int k) {
        if(k <= 0)
            return head;
        ListNode first = head, second = head;
        for(int i = 0; i < k-1; i++){
            if(first != null)
                first = first.next;
            else
                return head;
        }
        if(first == null)
        	return null;
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
	
	public static ListNode ReverseList(ListNode head) {
        ListNode p = null, temp = null;
        while(head != null){
            temp = head;
            head = head.next;
            temp.next = p;
            p = temp;
        }
        head = p;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
