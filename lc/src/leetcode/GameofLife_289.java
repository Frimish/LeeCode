package leetcode;

public class GameofLife_289 {
	public static void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;
		int n = board.length, m = board[0].length, count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				count = countNeighbors(board, n, m, i, j);
				if (board[i][j] == 1) {
					if (count == 2 || count == 3) board[i][j] = 3;
				} else {
					board[i][j] = count == 3 ? 2 : 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] >>= 1;
			}
		}
	}

	private static int countNeighbors(int[][] board, int n, int m, int x, int y) {
		int count = 0;
		for (int i = Math.max(0, x - 1); i < Math.min(n, x + 2); i++) {
			for (int j = Math.max(0, y - 1); j < Math.min(m, y + 2); j++) {
				if (i == x && j == y)
					continue;
				count += board[i][j] & 1;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[][] board = new int[][] {{}};
		gameOfLife(board);
	}
}
