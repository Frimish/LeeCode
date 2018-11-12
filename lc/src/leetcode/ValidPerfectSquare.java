package leetcode;

public class ValidPerfectSquare {
	public static boolean isPerfectSquare(int num) {
		if (num < 0)
			return false;
		long l = 0, r = num, mid = 0;
		while (l <= r) {
			mid = l + ((r - l) >> 1);
			if (mid * mid == num)
				return true;
			if (mid * mid > num) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++ ) {
			System.out.println(i + " "+ isPerfectSquare(i));
		}
	}
}
