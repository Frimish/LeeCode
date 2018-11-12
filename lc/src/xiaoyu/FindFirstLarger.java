package xiaoyu;

public class FindFirstLarger {
	public static int find(int[] array, int target) {
		//if (array == null || array.length == 0) {
		if (array.length == 0 || array == null) { 
			// if array = null what will happen?
			// check array == null firstly, then check array.length == 0
			return -1;
		}
		int left = 0;
		int right = array.length - 1; 
		while (left < right - 1) { 
			int mid = left + (right - left) / 2;// int mid = left + ((right - left) >> 1)
			if (array[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (target >= array[left] && target < array[right]) {
			return right;
		}
		if (target < array[left]) {
			return left;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 2, 2, 6, 6, 8, 9 };
		System.out.println(find(array, 3));
	}
}