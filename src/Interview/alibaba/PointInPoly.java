package Interview.alibaba;

import java.util.Scanner;

public class PointInPoly {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String testStr = scanner.nextLine();
		int x = Integer.parseInt(testStr.split(",")[0]);
		int y = Integer.parseInt(testStr.split(",")[1]);
		String locaStr = scanner.nextLine();
		String[] axis = locaStr.split(",");
		int[][] points = new int[axis.length / 2][2];
		int strIdx=0;
		for(int i = 0; i < axis.length / 2; i++) {
			points[i][0] = Integer.parseInt(axis[strIdx++]);
			points[i][1] = Integer.parseInt(axis[strIdx++]);
		}
		if(isInPoly(x, y, points)) {
			System.out.println("yes,0");
		}
	}
	
	public static boolean isInPoly(int x, int y, int[][] points) {
		boolean flag = false;
		int n = points.length;
		for(int i = 0, j = n - 1; i < n; j = i++) {
			if(((points[j][1]>y) != (points[i][1] < y)) &&
					(x < (points[j][0] - points[i][0]) * (y - points[i][1]) 
							/ (points[j][1] - points[i][1]) + points[i][0]))
				flag = !flag;
		}
		return flag;
	}
}
