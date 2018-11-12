package leetcode;

public class LongestIncreasingPathinaMatrix_329 {
//	private static int[][] cache;
//	private static int n, m;
//
//	public static int longestIncreasingPath(int[][] matrix) {
//		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//			return 0;
//		n = matrix.length;
//		m = matrix[0].length;
//		int max = 0;
//		cache = new int[n][m];
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				max = Math.max(dfs(matrix, i, j), max);
//			}
//		}
//		return max;
//	}
//
//	private static int dfs(int[][] matrix, int x, int y) {
//		if (cache[x][y] > 0)
//			return cache[x][y];
//		if (x < 0 || x >= n || y < 0 || y >= m)
//			return 0;
//		int max = 0;
//		if (x + 1 < n && matrix[x + 1][y] > matrix[x][y])
//			max = Math.max(max, dfs(matrix, x + 1, y));
//		if (x - 1 >= 0 && matrix[x - 1][y] > matrix[x][y])
//			max = Math.max(max, dfs(matrix, x - 1, y));
//		if (y + 1 < m && matrix[x][y + 1] > matrix[x][y])
//			max = Math.max(max, dfs(matrix, x, y + 1));
//		if (y - 1 >= 0 && matrix[x][y - 1] > matrix[x][y])
//			max = Math.max(max, dfs(matrix, x, y - 1));
//		cache[x][y] = max + 1;
//		return cache[x][y];
//	}
//	
//	
    private int[][] memo;
    private int n;
    private int m;
    private int max = 0;
    private int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 && matrix[0].length == 0)
            return 0;
        n = matrix.length;
        m = matrix[0].length;
        memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }
    
    private int dfs(int[][] matrix, int x, int y) {
        if (memo[x][y] > 0) 
            return memo[x][y];
        for (int d = 0; d < dir.length; d++) {
            int x0 = x + dir[d][0];
            int y0 = y + dir[d][1];
            if (check(x0, y0) && matrix[x][y] > matrix[x0][y0]) {
            	dfs(matrix, x0, y0);
                memo[x][y] = Math.max(memo[x][y], memo[x0][y0]);
            }
        }
        return ++memo[x][y];
    }
    
    private boolean check(int x, int y) {
        if (x < 0 || y < 0 || x >= n | y >= m) 
            return false;
        return true;
    }

	public static void main(String[] args) {
		LongestIncreasingPathinaMatrix_329 a = new LongestIncreasingPathinaMatrix_329();
		System.out.println(a.longestIncreasingPath((new int[][] { {9,9,4},{6,6,8},{2,1,1}})));
	}
}
