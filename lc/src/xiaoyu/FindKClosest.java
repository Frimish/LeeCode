package xiaoyu;

import java.util.ArrayList;
import java.util.List;

public class FindKClosest {
	public static List<Integer> closestk(int[] array, int target, int k) {
		if (array == null || array.length == 0) {
			return null;
		}
		List<Integer> res = new ArrayList<>();
		int left = 0;
		int right = array.length - 1;

		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		
		for (int i = 0; i < k; i++) {
			if (target <= array[0]) {
				res.add(array[left++]);
			} else if (target >= array[array.length - 1]) {
				res.add(array[right--]);

			} else if (left < 0 || (right <= array.length - 1
					&& (target - array[left] ) > array[right] - target)) {
				res.add(array[right++]);
			} else {
				res.add(array[left--]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		
	}

}
