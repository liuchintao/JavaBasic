package Interview.toutiao;

public class FindFansGroups {

	/*
	 * ��һ��M*N�ľ����У��ҳ��ж��ٸ���0�����ģ�1��Ⱥ�壻 Ⱥ��Ķ���Ϊ����������б�Խ���1���� 
	 * 1|0|1 
	 * 0|0|0 
	 * 1|0|1
	 * ���������ֻ��һ��1��Ⱥ�壬Ⱥ���СΪ5
	 */
	public String findOnesGroups(int[][] metrix, int m, int n) {
		boolean[][] isVisited = new boolean[m][n];
		int tmp, groups = 0, max = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (!isVisited[i][j]) {
					tmp = visitMetrix(isVisited, metrix, i, j, m, n);
					max = Math.max(max, tmp);
					groups = tmp > 0 ? ++groups : groups;
				}
			}
		return groups + "," + max;
	}

	private int visitMetrix(boolean[][] isVisited, int[][] metrix, int i, int j, int m, int n) {
		if (i < 0 || j < 0 || i >= m || j >= n || isVisited[i][j])
			return 0;
		isVisited[i][j] = true;
		if(metrix[i][j] == 0)
			return 0;
		int members = visitMetrix(isVisited, metrix, i - 1, j - 1, m, n) 
				+ visitMetrix(isVisited, metrix, i - 1, j, m, n)
				+ visitMetrix(isVisited, metrix, i - 1, j + 1, m, n)
				+ visitMetrix(isVisited, metrix, i, j - 1, m, n)
				+ visitMetrix(isVisited, metrix, i, j + 1, m, n)
				+ visitMetrix(isVisited, metrix, i + 1, j - 1, m, n)
				+ visitMetrix(isVisited, metrix, i + 1, j, m, n)
				+ visitMetrix(isVisited, metrix, i + 1, j + 1, m, n) + 1;
		return members;
	}
}
