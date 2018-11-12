package leetcode;

public class VerifyPreorderSequenceBinarySearchTree_255 {
    public static boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0) return true;
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private static boolean helper(int[] preorder, int l, int r) {
        if (r - l < 2) return true;
        int root = preorder[l];
        int p = l + 1;
        while (p <= r && preorder[p] < root) p++;
        for (int i = p; i <= r; i++) {
            if (preorder[i] < root) return false;
        }
        boolean left = true;
        if (p - 1 > l) {
            left = left & helper(preorder, l + 1, p - 1);
        }
        boolean right = true;
        if (p <= r) {
            right = right & helper(preorder, p , r);
        }
        return left && right;   
    }
    
    public static void main(String[] args) {
		System.out.println(verifyPreorder(new int[] {5,2,1,6,4}));
	}
}
