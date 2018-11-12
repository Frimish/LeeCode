package xiaoyu;

public class MergeTwoArray {
	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int k = 0, i = 0, j = 0;
		while (i < a.length && j < b.length) {
			c[k++] = a[i] < b[j] ? a[i++] : b[j++];
		}
		while (i < a.length || j < b.length) {
			c[k++] = i < a.length ? a[i++] : b[j++];
		}
		return c;
	}
	
	
}
