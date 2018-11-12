package leetcode;

import java.util.Arrays;

public class ArithmeticSlices {
	 public static int arithmeticSlices(int[] nums) {
		 int n = nums.length;
		 int[][] dp = new int[n][n];
		 Arrays.sort(nums);
		 for (int i = 0; i < n; i++) {
			 for (int j = i + 1; j < n; j++) {
				 dp[i][j] = 2;
			 }
		 }
		 int res = 2;
		 for (int j = n - 2; j > 0; j--) {
			 int i = j - 1, k = j + 1;
			 while (k < n && i >=0) {
				 if (nums[k] + nums[i] == nums[j] * 2) {
					 dp[i][j] = dp[j][k] + 1;
					 res = Math.max(res, dp[i][j]);
				 } else if (nums[k] + nums[i] < nums[j] * 2) {
					 k++;
				 } else {
					 j--;
				 }
			 }
		 }
		 
		 return res;
	 }
	 
	 public static void main(String[] args) {
		
	}
}
