package Algorithm;

import java.util.Scanner;

public class YouAreOut {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String op = input.nextLine();
			int q = input.nextInt();
			int[] n = new int[q];
			int[] m = new int[q];
			int[] x = new int[q];
			int[] y = new int[q];
			for (int i = 0; i < q; i++) {
				n[i] = input.nextInt();
				m[i] = input.nextInt();
				x[i] = input.nextInt();
				y[i] = input.nextInt();
			}
			int i = 0;
			for (int j = 0; j < op.length(); j++) {
				if (i >= q) {
					break;
				}
				if (op.charAt(j) == 'r') {
					y[i]++;
					if (y[i] > m[i]) {
						i++;
						System.out.println(j + 1);
					}
				} else if (op.charAt(j) == 'l') {
					y[i]--;
					if (y[i] < 0) {
						i++;
						System.out.println(j + 1);
					}
				} else if (op.charAt(j) == 'd') {
					x[i]--;
					if (x[i] < 0) {
						i++;
						System.out.println(j + 1);
					}
				} else if (op.charAt(j) == 'u') {
					x[i]++;
					if (x[i] > n[i]) {
						i++;
						System.out.println(j + 1);
					}
				}
			}
			if (i == q - 1) {
				System.out.println(op.length());
			}
		}
	}
}
