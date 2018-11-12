package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle_118 {
	public static List<List<Integer>> generate(int n) {
		if (n <= 0)
			return Collections.emptyList();
		List<List<Integer>> row = new ArrayList<List<Integer>>();
		row.add(new ArrayList<Integer>());
		row.get(0).add(1);
		for (int i = 1; i < n; i++) {
			row.add(new ArrayList<Integer>());
			row.get(i).add(1);
			for (int j = 1; j < i; j ++) {
				row.get(i).add(row.get(i - 1).get(j -1) + row.get(i - 1).get(j));
			}
			row.get(i).add(1);
		}
		
		return row;
	}
	
	public static void main(String[] args) {
		generate(5);
	}
}
