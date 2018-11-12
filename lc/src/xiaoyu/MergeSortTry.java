package xiaoyu;

public class MergeSortTry {

	public static void mergeSort(int[] array) {
		if (array.length == 0 || array == null) {
			return;
		}
		mergeSort(array, 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int left, int right) {
		if (left == right) {
			return;
		}

		int mid = left + (right - left) / 2;
		mergeSort(array, left, mid);
		mergeSort(array, mid + 1, right);

		int[] helper = new int[array.length];
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}
		int i = left;
		int j = mid + 1;
		int idx = i;

		while (i <= mid && j <= right) {
			if (helper[i] <= helper[j]) {
				array[idx++] = helper[i++];
			} else {
				array[idx++] = helper[j++];
			}
		}

		while (i <= mid) {
			array[idx++] = helper[i++];
		}

		while (j <= right) {
			array[idx++] = helper[j++];
		}

	}
}
