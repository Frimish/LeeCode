package leetcode;

public class PaintFence_276 {

	public static int numWays(int n, int k) {
		if (n == 0) return 0;
		int[][] f = new int[n + 1][k];
		for (int i = 0; i < k; i++) {
			f[1][i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < k; j++) {
				for (int h = 0; h < k; h++) {
					f[i][j] += f[i - 1][h];
				}
				f[i][j] -= f[i - 2][j];
			}
		}
		int res = 0;
		for (int j = 0; j < k; j++) {
			res += f[n][j];
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(numWays(4, 1));
	}
}
