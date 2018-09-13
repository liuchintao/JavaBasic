package Algorithm;

import java.util.Random;
import java.util.Scanner;

public class GenerateUndupcArrayRandomly {
	
	private static int[] getArrayRandomly(int range) {
		int[] a = new int[range];
		int[] b = new int[range];
		int end = range - 1;
		for (int i = 0; i < range; i++) {
			a[i] = i + 1;
		}
		Random r = new Random();
		for (int i = 0; i < range; i++) {
			int minVal = 0;
			int maxVal = end + 1;
			int rdIndex = r.nextInt(maxVal) + minVal;
			b[i] = a[rdIndex];
			a[rdIndex] = a[end];
			end--;
		}
		return b;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the the range of array: ");
		int range = sc.nextInt();
		int[] array = getArrayRandomly(range);
		for (int i = 0; i < range; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
