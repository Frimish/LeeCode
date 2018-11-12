package leetcode;

import java.util.Arrays;

public class WiggleSortII_324 {
	public void wiggleSort(int[] A) {
		if (A == null || A.length == 0)
			return;
		Arrays.sort(A);
		int idx = 0;
		int[] tmp = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			tmp[idx] = A[i];
			idx += 2;
			idx = idx >= A.length ? idx - A.length : idx;
		}
		
		for (int i = 0; i < A.length; i++) {
			A[i] = tmp[i];
		}
	}
}
