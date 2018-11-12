package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSumII_454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		if (A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0)
			return 0;
		int res = 0;
		Map<Integer, Integer> mapAandB = createMap(A, B);
		Map<Integer, Integer> mapCandD = createMap(C, D);
		for (Integer key : mapAandB.keySet()) {
			if (mapCandD.containsKey(-key)) {
				res += mapAandB.get(key) * mapCandD.get(-key);
			}
		}
		return res;
	}

	private Map<Integer, Integer> createMap(int[] X, int[] Y) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int x : X) {
			for (int y : Y) {
				map.put(x + y, map.getOrDefault(x + y, 0) + 1);
			}
		}
		return map;
	}
}
