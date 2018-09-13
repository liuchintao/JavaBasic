package Interview.Tencent;

import java.util.Scanner;

public class Songs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long length = scanner.nextLong();
		long al = scanner.nextLong();
		long x = scanner.nextLong();
		long bl = scanner.nextLong();
		long y = scanner.nextLong();
		if (al * x + bl * y < length || length == 0)
			System.out.println(0);
		else if (al * x + bl * y == length)
			System.out.println(1);
		else {
			dfs(x, al, y, bl, length);
		}
	}

	private static void dfs(long x, long a, long y, long b, long length) {
		long count = 0;
		for (long i = 0; i <= x; i++) {
			for (long j = 0; j <= y; j++) {
				if (i * a + j * b == length) {
					long t1 = cal(x, i);
					long t2 = cal(y, j);
					count += t1 * t2;
					System.out.println("i = " + i + " j = " + j + " count = " + count);	
				}
			}
		}
		System.out.println(count);
	}

	private static long cal(long x, long y) {
		double ans = 1;
		for(long i = x; i > (x - y); i--) {
			ans *= i;
			if(y > 0)
				ans /= y--;
		}
		return (long)ans;
	}

}
