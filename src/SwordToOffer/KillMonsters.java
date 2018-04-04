package SwordToOffer;

import java.util.Scanner;

public class KillMonsters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] xs = new int[n];
		for(int i = 0; i < n; i++) {
			xs[i] = in.nextInt();
		}
		int[] ys = new int[n];
		for(int i = 0; i< n; i++) {
			ys[i] = in.nextInt();
		}
		if(n < 4) {
			System.out.println(n);
			return;
		}
		int max = 0;
		int t1 = 0;
		for(int a = 0; a < n; a++) {
			for(int b = 0; b < n; b++) {
				if(a == b)
					continue;
				int abx = xs[a] - xs[b];
				int aby = ys[a] - ys[b];
				for(int c = 0; c < n; c++) {
					if(a == c || b == c)
						continue;
					t1 = 0;
					for(int d = 0; d < n; d++) {
						if(a == d || b == d || c == d)
							continue;
						int cdx = xs[c] - xs[d];
						int cdy = ys[c] - ys[d];
						int adx = xs[a] - xs[d];
						int ady = ys[a] - ys[d];
						if(abx * cdx == -(aby * cdy) || abx * ady == adx * aby) {
							t1++;
						}
					}
					t1 += 3;
					max = t1 > max ? t1: max;
				}
			}
		}
		System.out.println(max);
	}
}
/**
 *
50
-301563 714382 940434 768504 195 959350 13 212532 31412 -893508 -546715 134712 68 5 -517857 374406 560379 150226 39 176 202 -856465 17 483518 4 26 160 181 570660 794784 225 185272 46572 192 -380380 34 25 48 174094 -901951 7 198 564061 -559737 -971731 -465785 67 188 -738639 144167
-416652 972572 -451947 354396 45 -365014 137 291391 -265483 -923344 -719789 125652 82 145 -610115 507468 343284 -374914 111 26 52 376367 133 -551928 146 124 10 31 -574912 264828 75 797089 958910 42 -483260 116 125 102 988193 -994605 143 48 208105 -690643 -58337 96189 83 38 884870 -403893
*/
