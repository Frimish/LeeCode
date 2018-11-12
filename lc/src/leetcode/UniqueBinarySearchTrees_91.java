package leetcode;

public class UniqueBinarySearchTrees_91 {
    public int numTrees(int n) {
        long res = 1;
    	for (int i = 2 * n; i > n; i++) {
    		res = res * i / (2 * n - i + 1);
    	}
    	return (int)(res / (n + 1));
    }
}
