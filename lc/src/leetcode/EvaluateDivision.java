package leetcode;

import java.util.HashMap;
import java.util.Map;

public class EvaluateDivision {
	public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		if (equations == null || values == null || equations.length == 0 || equations[0].length == 0
				|| values.length == 0)
			return new double[] {};
		Map<String, Integer> map = new HashMap<String, Integer>();
		int n = 0;
		for (String[] equation : equations) {
			for (int i = 0; i < 2; i++) {
				if (!map.containsKey(equation[i])) {
					map.put(equation[i], n);
					n++;
				}
			}
		}

		double[][] dp = new double[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = i == j ? 1 : -1;
			}
		}

		int l = 0, r = 0;
		for (int i = 0; i < values.length; i++) {
			l = map.get(equations[i][0]);
			r = map.get(equations[i][1]);
			dp[l][r] = values[i];
			dp[r][l] = 1 / values[i];
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (dp[i][k] != -1 && dp[k][j] != -1) {
						dp[i][j] = dp[i][k] * dp[k][j];
					}
				}
			}
		}

		double[] res = new double[queries.length];

		for (int i = 0; i < queries.length; i++) {
			if (map.containsKey(queries[i][0]) && map.containsKey(queries[i][1])) {
				l = map.get(queries[i][0]);
				r = map.get(queries[i][1]);
				res[i] = dp[l][r];
			} else {
				res[i] = -1;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		double[] res = calcEquation(new String[][] { { "a", "b" }, { "b", "c" } }, new double[] { 2.0, 3.0 },
				new String[][] { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } });
		for (double e : res) {
			System.out.println(e);
		}
	}
}
