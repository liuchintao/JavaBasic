package Interview.toutiao.test;

import Interview.toutiao.MergeSection;
import junit.framework.TestCase;

public class MergeSectionTest extends TestCase {
	public void testGetMergedSection() {
		MergeSection mergeSection = new MergeSection();
		String[] pairs = {"1,10;32,45","78,94;5,16","80,100;200,220;16,32"};
		System.out.println(mergeSection.mergeSection(pairs, pairs.length));
	}
}
