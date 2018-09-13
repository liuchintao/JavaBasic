package Algorithm;

import java.util.Scanner;

/**
 * This class is the solution of problem from
 * https://www.nowcoder.com/questionTerminal/bf877f837467488692be703735db84e6
 * 
 * @author Magister
 *
 */
public class NewCoderPackage {
	
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long volume = sc.nextInt();
		int[] snacks = new int[n];
		int i = 0;
		long sumVol = 0;
		for(int j = 0; j< n;j++) {
			snacks[i] = sc.nextInt();
			sumVol += snacks[i];
			i++;
		}
		if (sumVol <= volume) {
			count = (int) Math.pow(2, n);
			System.out.println(count);
			return;
		}
		getCount(snacks, volume, 0, 0);
		System.out.print(count + 1);
	}

	private static void getCount(int[] snacks, long volume, long sum, int cur) {
		if(cur < snacks.length) {
			if(sum > volume)
				return;
			if(sum + snacks[cur] <= volume) {
				count++;
				getCount(snacks, volume, sum + snacks[cur], cur+1);
			}
			getCount(snacks, volume, sum, cur+1);
		}
	}

}
