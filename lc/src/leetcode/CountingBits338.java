package leetcode;

public class CountingBits338 {
	public static int[] countBits(int num) {
		int[] counts = new int[num + 1];
		counts[0] = 0;
		for (int i = 1; i < num + 1; ++i) {
			counts[i] = 1 + counts[i & (i - 1)];
		}
		return counts;
	}
	
	public static void main(String[] args) {
		int[] count  = countBits(5);
		for (int e : count) {
			System.out.println(e);
		}
	}
}
