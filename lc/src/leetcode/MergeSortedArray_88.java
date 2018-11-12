package leetcode;

public class MergeSortedArray_88 {
    public void merge(int[] A, int m, int[] B, int n) {
        int index = m + n - 1;
        m--;
        n--;
    	while (m >= 0 && n >= 0) {
        	if (A[m] > B[n]) {
        		A[index] = A[m];
        		m--;
        	} else {
        		A[index] = B[n];
        		n--;
        	}
        	index--;
        }
    	while (n >= 0) {
    		A[index] = B[n];
    		index--;
    		n--;
    	}
    }
}
