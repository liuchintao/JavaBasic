package Algorithm;

public class WorSearchSolution {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String t1 = "ABCCED";
		String t2 = "TEST";
		System.out.println(exist(board, t1));
		System.out.println(exist(board, t2));
	}

	public static boolean exist(char[][] board, String word) {
		if (word.isEmpty())
			return true;
		if (board == null)
			return false;
		int rows = board.length;
		int cols = board[0].length;
		if (word.length() > rows * cols)
			return false;
		boolean[][] flag = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (word.charAt(0) == board[i][j] && check(board, word, i, j, 0, flag)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean check(char[][] board, String word, int i, int j, int index, boolean[][] flag) {
		if (index == word.length())
			return true;
		if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] != word.charAt(index)
				|| flag[i][j] == true)
			return false;
		flag[i][j] = true;
		if(check(board, word, i+1,j, index+1, flag) ||
				check(board, word, i-1,j, index+1, flag) ||
				check(board, word, i,j+1, index+1, flag) || 
				check(board, word, i,j-1, index+1, flag))
			return true;
		flag[i][j] = false;
		return false;
	}
}
