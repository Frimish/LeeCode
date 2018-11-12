package xiaoyu;

public class Search_a_2D_Matrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int x = matrix.length - 1;
		int y = matrix[0].length - 1;
		int m = x;
		int n = 0;
		while (m >= 0 && n <= y) {
			if (matrix[m][n] == target) {
				return true;
			}
			if (matrix[m][n] < target) {
				n++;
			} else {
				m--;
			}
		}
		return false;

	}
	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][]{
		                                         {1,   4,  7, 11, 15},
		                                         {2,   5,  8, 12, 19},
		                                         {3,   6,  9, 16, 22},
		                                         {10, 13, 14, 17, 24},
		                                         {18, 21, 23, 26, 30}
		},1));
	}

}
