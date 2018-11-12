package leetcode;

public class MaximumSumof3NonOverlappingSubarrays {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int K) {
        //W is an array of sums of windows
        int[] W = new int[nums.length - K + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= K) sum -= nums[i-K];
            if (i >= K-1) W[i-K+1] = sum;
        }

        int[] left = new int[W.length];
        int best = 0;
        for (int i = 0; i < W.length; i++) {
            if (W[i] > W[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[W.length];
        best = W.length - 1;
        for (int i = W.length - 1; i >= 0; i--) {
            if (W[i] >= W[best]) best = i;
            right[i] = best;
        }

        int[] ans = new int[]{-1, -1};
        for (int i = 0; i < W.length - K; i++) {
            int l = left[i], r = right[i + K];
            if (ans[0] == -1 || W[l] + W[r]>
                    W[ans[0]] + W[ans[1]]) {
                ans[0] = l;
                ans[1] = r;
            }
        }
        return ans;
    }
    
    public static int[] maxSumOfThreeSubarrays1(int[] nums, int K) {
        int n = nums.length;
        if (n < K) return new int[]{-1, -1, -1};
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] A = new int[n - K + 1];
        for (int i = 0; i < n - K + 1; i++) {
            A[i] = sum[i + K] - sum[i];
        }
        int[] left = new int[n - K + 1];
        int max = 0, best = 0;
        for (int i = 0; i < n - K + 1; i++) {
            if (A[i] > max) {
                max = A[i];
                best = i;
            }
            left[i] = best;
        }
        int[] right = new int[n - K + 1];
        max = 0;
        best = n - K;
        for (int i = n - K; i >= 0; i--) {
            if (A[i] >= max) {
                max = A[i];
                best = i;
            }
            right[i] = best;
        }
        
        max = 0;
        int[] res = new int[]{-1, -1, -1};
        for (int j = K; j < n - K * 2 + 1; j++) {
            int i = left[j - K], k = right[j + K];
            if (A[i] + A[j] + A[k] > max) {
                max = A[i] + A[j] + A[k];
                res[0] = i;
                res[1] = j;
                res[2] = k;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
		int[] res = maxSumOfThreeSubarrays1(new int[] {7,13,20,19,19,2,10,1,1,19}, 3);
		for (int x : res) {
			System.out.println(x);
		}
	}
}
