package leetcode;

import java.util.Arrays;

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        return sum;
    }
    public static void main(String[] args) {
		System.out.println(pivotIndex(new int[] {0, 1}));
	}
}
