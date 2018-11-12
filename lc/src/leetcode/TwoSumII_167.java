package leetcode;

public class TwoSumII_167 {
    public static int[] twoSum(int[] numbers, int target) {
		int l = 0, r = numbers.length - 1;
		while (l < r) {
			int sum = numbers[l] + numbers[r];
			if (sum == target) {
				return new int[] { l + 1, r + 1 };
			} else if (sum < target) {
				l++;
			} else {
				r--;
			}
		}
		return null;
    }
    
    public static void main(String[] args) {
    	int[] res = twoSum(new int[] {2, 7, 9, 11, 18}, 18);
		System.out.println(res[0] + " " + res[1]);
	}
}
