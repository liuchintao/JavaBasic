package testjava.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TestList {
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		ListIterator<Integer> li = l1.listIterator();
		while(li.hasNext()) {
			Integer i= li.next();
			li.add(i+1);
			System.out.println(i);	
		}
		
	}
}
