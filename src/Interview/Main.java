package Interview;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		// int k = in.nextInt();
		// int x = k, y = k + 1;
		// int count = 0;
		// for(int i = 0; i <= n - k; i++) {
		// if(x + i > n)
		// break;
		// for(int j = 0; j <= n - k - 1; j++) {
		// if(y + j > n)
		// break;
		// if((x+i) % (y+j)>=k)
		// count ++;
		// }
		// }
		// System.out.println(count);
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] jobs = new int[n][2];
		for (int i = 0; i < n; i++) {
			jobs[i][0] = in.nextInt();
			jobs[i][1] = in.nextInt();
		}
		int[] capacity = new int[m];
		for (int i = 0; i < m; i++) {
			capacity[i] = in.nextInt();
		}
		int max_salary;
		for (int i = 0; i < capacity.length; i++) {
			max_salary = 0;
			for(int j = 0; j < jobs.length; j++) {
				if(j == 1) {
					System.out.println("");
				}
				if(capacity[i] >= jobs[j][0]) {
					if(max_salary<jobs[j][1]) {
						max_salary = jobs[j][1];
					}
				}
			}
			System.out.println(max_salary);
		}
	}
}
