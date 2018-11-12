package leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctIslands_694 {
	public static int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        Set<String> set = new HashSet<String>();
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[i].length; j++) {
        		if (grid[i][j] == 1) {
        			StringBuilder sb = new StringBuilder();
        			dfs(grid, i, j, sb, "o");
        			if (!set.contains(sb.toString())) {
        				res++;
        				set.add(sb.toString());
        			}
        		}
        	}
        }
        return res;
    }

	private static void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return;
		grid[i][j] = 0;
		sb.append(dir);
		dfs(grid, i - 1, j, sb, "u");
		dfs(grid, i + 1, j, sb, "d");
		dfs(grid, i, j - 1, sb, "l");
		dfs(grid, i, j + 1, sb, "r");
		sb.append("b");
	}
	
	public static void main(String[] args) {
		System.out.println(numDistinctIslands(new int[][] {{1,1,0},{0,1,1},{0,0,0},{1,1,1},{0,1,0}}));
	}
}
