package Algorithm.pacakgeproblems.test;

import Algorithm.pacakgeproblems.CombinationSum39;
import junit.framework.TestCase;

public class CombinationSumTest extends TestCase {

	public void testConbination() {
		int[] candidates = {2,3,6,7};
		int target = 7;
		CombinationSum39 combinationSum = new CombinationSum39();
		System.out.println(combinationSum.combinationSum(candidates, target));
	}
	
	public void testConbinationTarget8() {
		int[] candidates = {2,3,5};
		int target = 8;
		CombinationSum39 combinationSum = new CombinationSum39();
		System.out.println(combinationSum.combinationSum(candidates, target));
	}
}
