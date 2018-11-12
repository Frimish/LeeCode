package leetcode;

public class Searcha2DMatrixII_220 {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int n = matrix.length - 1, m = matrix[0].length - 1, x = n, y = 0;
		while (x >= 0 && y <= m) {
			if (matrix[x][y] == target)
				return true;
			if (matrix[x][y] > target)
				x--;
			else
				y++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][] {{0}
		                                            }, 0));
	}
}
