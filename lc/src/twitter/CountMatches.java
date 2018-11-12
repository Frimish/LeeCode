package twitter;
import java.util.ArrayList;
import java.util.List;

public class CountMatches {

	private static int n;
	private static int m;

	static int countMatches(List<String> grid1, List<String> grid2) {
		if (grid1 == null || grid1.size() == 0)
			return 0;
		n = grid1.size();
		m = grid1.get(0).length();
		int[][] g1 = new int[n][m];
		int[][] g2 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g1[i][j] = grid1.get(i).charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g2[i][j] = grid2.get(i).charAt(j) - '0';
			}
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (g1[i][j] == 1 && dfs(g1, g2, i, j))
					res++;
			}
		}

		return res;

	}

	static boolean dfs(int[][] g1, int g2[][], int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m || g1[x][y] == g2[x][y] && g1[x][y] == 0)
			return true;
		if (g1[x][y] != g2[x][y]) 
			return false;
		g1[x][y] = 0;
		g2[x][y] = 0;
		boolean d1 = dfs(g1, g2, x + 1, y);
		boolean d2 = dfs(g1, g2, x - 1, y);
		boolean d3 = dfs(g1, g2, x, y - 1);
		boolean d4 = dfs(g1, g2, x, y + 1);
		return d1 && d2 && d3 && d4;
	}

	public static void main(String[] args) {
		List<String> grid1 = new ArrayList<>(), grid2 = new ArrayList<>();
		grid1.add("001");
		grid1.add("011");
		grid1.add("100");
		grid2.add("001");
		grid2.add("011");
		grid2.add("100");
		System.out.println(countMatches(grid1, grid2));
	}
}
