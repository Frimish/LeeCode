package leetcode;

public class GraphValidTree_261 {
	private boolean res = true;
	private boolean[] vis;
	public boolean validTree(int n, int[][] edges) {
		int[][] tree = new int[n + 1][n + 1];
		for (int i = 0; i < edges.length; i++) {
			tree[edges[i][0]][0]++;
			tree[edges[i][0]][tree[edges[i][0]][0]] = edges[i][1];
			tree[edges[i][1]][0]++;
			tree[edges[i][1]][tree[edges[i][1]][0]] = edges[i][0];
		}
		
		vis = new boolean[n];
		dfs(tree, 0, -1);
		
		for (int i = 0; i < n; i++) {
			res &= vis[i];
		}
		
		return res;
	}
	private void dfs(int[][] tree, int x, int pre) {
		if (vis[x]) {
			res = false;
			return; 
		}
		vis[x] = true;
		for (int i = 1; i <= tree[x][0]; i++) {
			if (tree[x][i] != pre){
				if (!res) return;
				dfs(tree, tree[x][i], x);
			}
		}
	}
}
