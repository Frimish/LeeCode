package twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PrimesinSubtree {
	private static Map<Integer, Integer> primes = new HashMap<>();
	private static Map<Integer, Integer> total = new HashMap<>();
	
	static List<Integer> primesinSubtree(int n, int[] u, int[] v, int[] val, int q, int[] queries) {
		List<Integer>[] tree = new List[n + 1];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 1; i <=n; i++) {
			tree[i] = new ArrayList<>();
			map.put(i, new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			List<Integer> sonu = map.get(u[i]);
			sonu.add(v[i]);
			List<Integer> sonv = map.get(v[i]);
			sonv.add(u[i]);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] vis = new boolean[n + 1];
		queue.offer(1);
		vis[1] = true;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			List<Integer> soncur = map.get(cur);
			for (int son : soncur)
				if (!vis[son]) {
					tree[cur].add(son);
					queue.offer(son);
					vis[son] = true;
				}
		}
	
		dfs(tree, val, 1);
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < q; i++) {
			res.add(total.get(queries[i]));
		}
		return res;
	}
	
	private static int dfs(List<Integer>[] tree, int[] val ,int root) {
		if (tree[root].isEmpty()) {
			total.put(root, checkPrimes(val[root - 1]));
			return total.get(root);
		}
		int sum = 0;
		for (int son : tree[root]) {
			sum += dfs(tree, val, son);
		}
		total.put(root, sum + checkPrimes(val[root - 1]));
		return total.get(root);
	}
	
	private static int checkPrimes(int root) {
		if (primes.containsKey(root)) return primes.get(root);
		if (root < 2) return 0;
		for (int i = 2; i * i <= root; i++) 
			if (root % i == 0) {
				primes.put(root, 0);
				return 0;
			}
		primes.put(root, 1);
		return 1;
	}
	
	public static void main(String[] args) {
		System.out.println(primesinSubtree(10, new int[] {6, 8, 3, 6, 4, 1, 8, 5, 1, 9}, new int[] {9, 9, 5, 7, 8, 8, 10, 8, 2, 10}, new int[] {17, 29, 3, 20, 11, 8, 3, 23, 5, 15}, 6, new int[] {1, 8, 9, 6, 4, 3}));
	}
}
