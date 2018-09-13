package Interview.baidu;

import junit.framework.TestCase;

public class CharacterGenerateTest extends TestCase {
	
	public void testFunc() {
		CharacterGenerate cGenerate = new CharacterGenerate();
		String str = "cabcac";
		int pair = 3;
		int[][] rangeLR = {{1,6},{1,3},{2,5}}; 
		char[] ans = cGenerate.rangeFrequent(str, pair, rangeLR);
		System.out.println(ans);
	}

}
