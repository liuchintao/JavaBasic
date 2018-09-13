package SwordToOffer.test;

import SwordToOffer.RotateArray;
import junit.framework.TestCase;

public class RotateArrayTest extends TestCase {
	public void testGetPivot() {
		Integer[] array = { 3,4,5,9,1,2 };
		RotateArray rotateArray = new RotateArray(array);
		System.out.println(rotateArray.getPivot());
	}
}
