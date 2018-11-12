package leetcode;

public class MaximumProductSubarray_152 {
    public static int maxProduct(int[] A) {
        if (A == null || A.length == 0) return 0;
        int res = A[0], max = A[0], min = A[0], tmp = A[0];
        for (int i = 1; i < A.length; i++) {
        	tmp = max;
        	max = Math.max(A[i], Math.max(A[i] * min, A[i] * max));
        	min = Math.min(A[i], Math.min(A[i] * min, A[i] * tmp));
        	res = Math.max(max, res);
        }
        return res;
    }
    
    public static void main(String[] args) {
		System.out.println(maxProduct(new int[] {}));
	}
}
