package leetcode;

public class MonotonicArray_896 {
	public boolean isMonotonic(int[] A) {
		if (A == null || A.length < 3)
			return true;
		
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; ++i) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
	}
}
