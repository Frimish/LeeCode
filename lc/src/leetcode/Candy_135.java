package leetcode;

import java.util.Arrays;

public class Candy_135 {
	public static int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
		}
		int[] left = new int[ratings.length];
		int[] right = new int[ratings.length];
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		for (int i = 1; i < left.length; i++) {
			left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
		}

		for (int i = right.length - 2; i >= 0; i--) {
			right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 1;
		}
		int res = 0;
		for (int i = 0; i< left.length; i++) {
			res = res + Math.max(left[i], right[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(candy(new int[] {1,1,1}));
	}
}
