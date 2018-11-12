package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges_228 {
	public List<String> summaryRanges(int[] A) {
		if (A == null || A.length == 0)
			return Collections.emptyList();

		List<String> res = new ArrayList<>();
		int start = A[0];
		int n = A.length;

		for (int i = 1; i < n; i++) {
			if (A[i] != A[i - 1] + 1) {
				res.add(start + "" + (start == A[i - 1] ? "" : "->" + A[i - 1]));
				start = A[i];
			}
		}

		res.add(start + "" + (start == A[n - 1] ? "" : "->" + A[n - 1]));

		return res;
	}
}
