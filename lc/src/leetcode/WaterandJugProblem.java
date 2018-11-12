package leetcode;

import java.util.HashSet;
import java.util.Set;

public class WaterandJugProblem {
	public static boolean canMeasureWater(int x, int y, int z) {
		Set<Integer> set = new HashSet<Integer>();
		int n = 0, m = 0;
		while (true) {
			n = (m * y - z) % x;
			if (n == 0)
				return true;
			if (!set.add(n))
				return false;
			m++;
		}

	}

	public static void main(String[] args) {
		System.out.println(canMeasureWater(3, 10, 5));
	}
}
