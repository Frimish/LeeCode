package leetcode;

public class SolveSuduku {
	public static void solveSudoku(char[][] board) {
		boolean[][] row = new boolean[10][10];
		boolean[][] col = new boolean[10][10];
		boolean[][] block = new boolean[10][10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					row[i][(int) (board[i][j] - '0')] = true;
					col[j][(int) (board[i][j] - '0')] = true;
					block[(i / 3) * 3 + j / 3][(int) (board[i][j] - '0')] = true;
				}
			}
		}
		dfs(board, row, col, block, 0);
	}

	private static boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int phase) {
		if (phase == 81)
			return true;
		int x = phase / 9;
		int y = phase % 9;
		if (board[x][y] != '.') {
			if (dfs(board, row, col, block, phase + 1))
				return true;
		} else {
			for (char c = '1'; c <= '9'; c++) {
				if (validate(row, col, block, x, y, c)) {
					board[x][y] = c;
					row[x][c - '0'] = true;
					col[y][c - '0'] = true;
					block[(x / 3) * 3 + y / 3][c - '0'] = true;
					if (dfs(board, row, col, block, phase + 1))
						return true;
					row[x][c - '0'] = false;
					col[y][c - '0'] = false;
					block[(x / 3) * 3 + y / 3][c - '0'] = false;
					board[x][y] = '.';
				}
			}
		}
		return false;
	}

	private static boolean validate(boolean[][] row, boolean[][] col, boolean[][] block, int x, int y, char c) {
		if (row[x][c - '0'])
			return false;
		if (col[y][c - '0'])
			return false;
		if (block[(x / 3) * 3 + y / 3][c - '0'])
			return false;
		return true;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '.' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' }, };
		solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
