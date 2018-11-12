package leetcode;

public class ConvertSortedListtoBinarySearchTree_109 {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		ListNode p = head;
		int length = 0;
		while (p != null) {
			length++;
			p = p.next;
		}
		int[] nums = new int[length];
		int index = 0;
		p = head;
		while (p != null) {
			nums[index] = p.val;
			index++;
			p = p.next;

		}
		return arrayToBST(nums, 0, nums.length - 1);
	}

	private TreeNode arrayToBST(int[] nums, int l, int r) {
		if (l > r)
			return null;

		int mid = l + (r - l) / 2;

		TreeNode node = new TreeNode(nums[mid]);

		if (l < r) {
			node.left = arrayToBST(nums, l, mid - 1);
			node.right = arrayToBST(nums, mid + 1, r);
		}

		return node;
	}
}
