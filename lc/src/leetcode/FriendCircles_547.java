package leetcode;

import java.util.HashSet;
import java.util.Set;

public class FriendCircles_547 {
	
	private boolean[] vis;
	
	public int findCircleNum(int[][] M) {
		vis = new boolean[M.length];
		int res = 0;
		for (int i = 0; i < M.length; i++) {
			if (!vis[i]) {
				dfs(M, i);
				res++;
			}
		}
		return res;
	}

	public void dfs(int[][] M, int i) {
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] == 1 && !vis[j]) {
				vis[j] = true;
				dfs(M, j);
			}
		}
	}
	
	private int[] father;
	
	public int findCircleNum1(int[][] M) {
		father = new int[M.length];
		for (int i = 0 ; i < father.length; i++) {
			father[i] = i;
		}
		int res = 0;
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length; j++) {
				if (M[i][j] == 1) {
					int fx = findFather(i);
					int fy = findFather(j);
					father[fx] = fy;
				}
			}
		}
		for (int i = 0; i < M.length; i++) {
			res += father[i] == i ? 1 : 0;
		}
		return res;
	}

	private int findFather(int x) {
		if (father[x] == x)  return x;
		father[x] = findFather(father[x]);
		return father[x];
	}

	
}
