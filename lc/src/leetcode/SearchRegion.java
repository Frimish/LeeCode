package leetcode;

public class SearchRegion {
	public static void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		int n = board.length, m = board[0].length;
		boolean[][] vis = new boolean[n][m];

		for (int j = 0; j < m; j++) {
			dfs(0, j, board, vis);
			dfs(n - 1, j, board, vis);
		}

		for (int i = 0; i < n; i++) {
			dfs(i, 0, board, vis);
			dfs(i, m - 1, board, vis);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!vis[i][j]) {
					board[i][j] = 'X';
				}
			}
		}

	}

	private static void dfs(int x, int y, char[][] board, boolean[][] vis) {
		int n = board.length, m = board[0].length;
		if (x < 0 || x >= n || y < 0 || y >= m)
			return;
		if (board[x][y] == 'X')
			return;
		if (vis[x][y])
			return;
		vis[x][y] = true;
		dfs(x, y + 1, board, vis);
		dfs(x + 1, y, board, vis);
		dfs(x, y - 1, board, vis);
		dfs(x - 1, y, board, vis);
	}

	public static void main(String[] args) {
		char[][] board = new char[][] {

				// {'X', 'X', '0', '0'},
				// {'X', '0', '0', 'X'},
				// {'X', 'X', 'X', 'X'}
		};
		solve(board);
		int n = board.length, m = board[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
