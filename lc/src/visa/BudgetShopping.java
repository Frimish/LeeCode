package visa;

import java.util.List;

public class BudgetShopping {
	public static int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
	    // Write your code here
		int[] f = new int[n + 1];
		for (int i = 0; i < bundleCosts.size(); i++) {
			for (int j = bundleCosts.get(i); i <= n; i++) {
				f[j] = Math.max(f[j - bundleCosts.get(i)] + bundleQuantities.get(i), f[j]);
			}
		}
		return f[n];
	}
	
	public static void main(String[] args) {
	}
}
