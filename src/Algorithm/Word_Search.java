package Algorithm;

public class Word_Search {
    public static boolean[][] visited;
	public static int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i ++) {
        	for(int j = 0; j < board[0].length; j ++) {
        		if(word.charAt(0) == board[i][j] && search(word, board, i, j, 0)) {
        			return true;
        		}
        	}
        }
        return false;
    }
	
	public static boolean search(String word, char[][] board, int i, int j, int index) {
		if(index == word.length()) {
			return true;
		}
		if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || visited[i][j] || word.charAt(index) != board[i][j]) {
			return false;
		}
		visited[i][j] = true;
		for(int[] dir : dirs) {
			if(search(word, board, i + dir[0], j + dir[1], index + 1)) {return true;}
		}
		visited[i][j] = false;
		return false;
	}
}