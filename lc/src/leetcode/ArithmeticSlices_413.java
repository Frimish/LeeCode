package leetcode;

public class ArithmeticSlices_413 {
    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int count = 0, res = 0;
        for (int i = 1; i < A.length - 1; i++) {
        	if (A[i] * 2 == A[i - 1] + A[i + 1]) {
        		count ++;
        	} else {
        		res += count * (count + 1) / 2;
        		count = 0;
        	}
        }
        return res + count * (count + 1) / 2;
     }
    
    public static void main(String[] args) {
		System.out.println(numberOfArithmeticSlices(new int[] {1, 1, 2, 5, 7, 9, 3, 4, 5, 6}));
	}
}
