package Interview.toutiao.test;

import Interview.toutiao.FindFansGroups;
import junit.framework.TestCase;

public class FindFansGroupsTest extends TestCase {
	
	public void testFindOnesGroups() {
		FindFansGroups fGroups = new FindFansGroups();
		int m = 3, n = 3;
		int[][] metrix = {{1,0,1},{0,0,0},{1,0,1}};
		String ans = fGroups.findOnesGroups(metrix, m, n);
		System.out.println(ans);
	}

}
