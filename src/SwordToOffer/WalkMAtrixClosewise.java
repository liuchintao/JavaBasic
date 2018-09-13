package SwordToOffer;

import java.util.ArrayList;

public class WalkMAtrixClosewise {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		ArrayList<Integer> temp = printMatrix(matrix);
		System.out.println(temp);
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> order = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return order;
		int left = -1, up = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
		boolean toLeft = false, toRight = true, toUp = false, toBottom = false;
		int num = matrix.length * matrix[0].length;
		int m = 0, n = 0;
		for (int i = 0; i < num; i++) {
			if (m >= 0 && m < matrix.length && n >= 0 && n < matrix[0].length) {
				order.add(matrix[m][n]);
				// Change flag
				if(m == up && n == left) {
					bottom--;
					toRight = true; toLeft = false; toUp = false; toBottom = false;
				}
				else if(m == up && n == right) {
					left++;
					toBottom = true; toLeft = false; toUp = false; toRight = false;
				}
				else if(m == bottom && n == right) {
					up++;
					toLeft = true; toBottom = false; toUp = false; toRight = false;
				}
				else if(m == bottom && n == left) {
					right--;
					toUp = true; toBottom = false; toLeft = false; toRight = false;
				}
				// Choose direction
				if(toRight)
					n++;
				if(toBottom)
					m++;
				if(toLeft)
					n--;
				if(toUp)
					m--;
				
			}
		}
		return order;
	}
}
