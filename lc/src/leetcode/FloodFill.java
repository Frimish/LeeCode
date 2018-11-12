package leetcode;

public class FloodFill {
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor)
			return image;
		dfs(image, sr, sc, image[sr][sc], newColor);
		return image;
	}

	private static void dfs(int[][] image, int sr, int sc, int color, int newColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
			return;
		image[sr][sc] = newColor;
		dfs(image, sr + 1, sc, color, newColor);
		dfs(image, sr - 1, sc, color, newColor);
		dfs(image, sr, sc + 1, color, newColor);
		dfs(image, sr, sc - 1, color, newColor);
	}

	public static void main(String[] args) {
		int[][] res = floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2);
		for (int[] row : res) {
			for (int e : row) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}
}
