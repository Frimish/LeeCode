package leetcode;

import java.util.HashSet;
import java.util.Set;

public class FrogJump_403 {

	private static Set<Integer> set = new HashSet<Integer>();
	private static Set<String> vis = new HashSet<String>();
	private static boolean res = false;
	private static int target = 0;

	public static boolean canCross(int[] stones) {
		if (stones.length < 2)
			return true;
		for (int x : stones) {
			set.add(x);
		}
		vis.add(0 + "&" + 0);
		target = stones[stones.length - 1];
		dfs(0, 0);
		return res;
	}

	private static void dfs(int start, int k) {
		if (start + k - 1 == target || start + k == target || start + k + 1 == target) {
			res = true;
			return;
		}
		if (start == target)
			return;
		for (int step = k - 1; step <= k + 1; step++) {
			int next = start + step;
			if (set.contains(next) && !vis.contains(next + "&" + step) && step > 0) {
				vis.add(next + "&" + step);
				dfs(next, step);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(canCross(new int[] {0,1,3,5,6,8,12,17}));
	}
}
