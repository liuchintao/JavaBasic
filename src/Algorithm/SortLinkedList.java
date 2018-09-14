package Algorithm;

public class SortLinkedList {

    /*
     * Using Tree is not efficient enough but it is easy;
     * However I try to use HashMap but the efficient is not as well as I predicted.
     */
//	public static ListNode sortList(ListNode head) {
//		ListNode ans = new ListNode(0);
//        Map<Integer, List<ListNode>> map = new TreeMap<Integer, List<ListNode>>();
//		Map<Integer, List<ListNode>> map = new HashMap<Integer, List<ListNode>>();
//        ListNode p = head;
//        while(p != null) {
//        	List<ListNode> t = map.get(p.val);
//        	if(t == null) {
//        		t = new ArrayList<ListNode>();
//        	}
//        	ListNode np = new ListNode(p.val);
//        	t.add(np);
//        	map.put(p.val, t);
//        	p = p.next;
//        }
//        p = ans;
//        int[] keys = new int[map.size()];
//        int i = 0;
//        for(Object o: map.keySet().toArray()) {
//        	keys[i] = (Integer) o;
//        	i++;
//        }
//        sort(keys, 0, keys.length - 1);
//        List<ListNode> t;
//        for(i = 0; i < keys.length; i++) {
//        	t = map.get(keys[i]);
//        	for(ListNode ln: t) {
//        		p.next = ln;
//        		p = p.next;
//        	}
//        }
//        System.out.println(map);
//        Collection<List<ListNode>> coll = map.values();
//        Iterator<List<ListNode>> iterator = coll.iterator();
//        Set<Entry<Integer, List<ListNode>>> entrys = map.entrySet();
//        Iterator<Entry<Integer, List<ListNode>>> iterator = entrys.iterator();
//        List<ListNode> t;
//        while(iterator.hasNext()) {
//        	t = iterator.next().getValue();
//        	for(ListNode ln: t) {
//        		p.next = ln;
//        		p = p.next;
//        	}
//        }
//        List<ListNode> t;
//        for(Integer i: map.keySet()) {
//        	t = map.get(i);
//        	for(ListNode ln: t) {
//        		p.next = ln;
//        		p = p.next;
//        	}
//        }
//        return ans.next;
//    }
//	
//	private static int partition(int[] keys, int low, int high) {
//		int i = keys[low];
//		while(low<high) {
//			while(low<high && keys[high] >= i) {
//				high--;}
//				int temp = keys[low];
//				keys[low] = keys[high];
//				keys[high]= temp;
//			
//			while(low<high && keys[low] <= i) {
//				low++;}
//				temp = keys[low];
//				keys[low] = keys[high];
//				keys[high]= temp;
//			
//		}
//		return low;
//	}
//	
//	private static void sort(int[] keys, int low, int high) {	
//		if(low < high) {
//			int partLoc = partition(keys, low, high);
//			sort(keys, low, partLoc - 1);
//			sort(keys, partLoc + 1, high);
//		}
//	}

	
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(3);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(4);
		ln1.next = ln2;
		ln2.next = ln3;
		System.out.println(sortList(ln1));
	}

	private static ListNode sortList(ListNode head) {
	     
        ListNode x = head;
        
        while(x!=null){
           // System.out.print(x.val+" ");
            x=x.next;
        }
        
        //System.out.println("");
        
        if(head==null || head.next==null){
            return head;
        }
        
        //System.out.println("Cannot");
        
        ListNode pivot=head,bef=null,aft=null,piv,afth=null,befh=null;
        head=head.next;
        piv=pivot;
        while(head!=null){
            if(head.val<pivot.val){
                if(bef==null){
                    bef=head;
                    befh=head;
                } else{
                    bef.next=head;
                    bef=head;
                }
                //System.out.println("BefVal:"+bef.val+"  ");
            } else if(head.val>pivot.val){
                if(aft==null){
                    aft=head;
                    afth=head;
                } else{
                    aft.next=head;
                    aft=head;
                }
                //System.out.println("AftVal:"+aft.val+"  ");
            } else{
                piv.next=head;
                piv=head;
            }
            head=head.next;
        }
        
        if(bef!=null){
            bef.next=null;
           //System.out.println("Start");
            befh=sortList(befh);
            bef=befh;
            while(bef.next!=null){
                bef=bef.next;
            }
            //System.out.println("End");
            bef.next=pivot;
        } else{
            befh=pivot;
        }
                    //System.out.println("mid"+"  "+(afth!=null));
        
        piv.next=null;

        if(afth!=null){
            aft.next=null;
            //System.out.println("Starta");
            afth=sortList(afth);
            //System.out.println("Enda");
            piv.next=afth;
        }
        
       // System.out.println("ENDEND");
        
        return befh;
        
	}
}
class ListNode {
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
