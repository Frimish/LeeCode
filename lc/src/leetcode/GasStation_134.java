package leetcode;

public class GasStation_134 {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int[] val = new int[gas.length * 2];
		for (int i = 0; i < gas.length; i++) {
			val[i] = gas[i] - cost[i];
			val[i + gas.length] = val[i];
		}

		int start = 0, end = 0, sum = 0, len = gas.length;
		while (start < len) {
			sum = 0;
			while (end < len * 2 && val[end] + sum >= 0) {
				sum += val[end];
				if (end - start + 1 == len) {
					return start;
				}
				end++;
			}
			start = end + 1;
			end = start;
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[] {3,3,4}, new int[] {4,4,3}));
	}
}
