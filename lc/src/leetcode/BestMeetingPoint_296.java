package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint_296 {
	public int minTotalDistance(int[][] grid) {
		List<Integer> rows = collectRows(grid);
		List<Integer> cols = collectCols(grid);
		return minDistance1D(rows) + minDistance1D(cols);
	}

	private int minDistance1D(List<Integer> list) {
		int l = 0, r = list.size()- 1,	res = 0;
		while(l < r) {
			res += list.get(r) - list.get(l);
	        l++;
	        r--;
		}
		return res;
	}

	private List<Integer> collectRows(int[][] grid) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					list.add(i);
				}
			}
		}
		return list;
	}

	private List<Integer> collectCols(int[][] grid) {
		List<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < grid[0].length; j++) {
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] == 1) {
					list.add(j);
				}
			}
		}
		return list;
	}
}
