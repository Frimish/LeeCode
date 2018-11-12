package leetcode;

public class SearchinRotatedSortedArray {
	public static int search1(int[] A, int target) {
		int l = 0, r = A.length - 1, t = target, m = -1;
		while (l <= r) {
			m = l + ((r - l) >> 1);
			if (A[m] == t)
				return m;
			if (A[m] >= A[l]) {
				if (t > A[m] || t < A[l]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			} else {
				if (t < A[m] || t > A[l]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			}
		}
		return -1;
	}
	
	public static int search(int[] A, int target) {
		int l = 0, r = A.length - 1, t = target, m = -1;
		while (l < r) {
			m = l + ((r - l) >> 1);
			if (A[r] < A[l]) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		int rot = l, n = A.length, d;
		l = 0; r = A.length - 1;
		
		while (l <= r) {
			m = l + ((r - l) >> 1);
			d = (m + rot) % n;
			if (A[d] == t) return d;
			if (A[d] < t) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(search(new int[] {5, 1, 3}, 1));
	}
	
	
}
