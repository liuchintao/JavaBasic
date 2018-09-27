package Algorithm.test;

import Algorithm.GetPermutation60;
import junit.framework.TestCase;

public class TestGetPermutation60 extends TestCase {
	
	public void testGetPermutation3_1() {
		GetPermutation60 getPermutation60 = new GetPermutation60();
		getPermutation60.getPermutation(3,1);
	}
	
	public void testGetPermutation3_3() {
		GetPermutation60 getPermutation60 = new GetPermutation60();
		getPermutation60.getPermutation(3,3);
	}
	
	public void testGetPermutation4_9() {
		GetPermutation60 getPermutation60 = new GetPermutation60();
		getPermutation60.getPermutation(4,9);
	}
	
	public void testGetPermutation3_5() {
		GetPermutation60 getPermutation60 = new GetPermutation60();
		getPermutation60.getPermutation(3,5);
	}
	
	public void testGetPermutation3_6() {
		GetPermutation60 getPermutation60 = new GetPermutation60();
		getPermutation60.getPermutation(3,6);
	}
}
