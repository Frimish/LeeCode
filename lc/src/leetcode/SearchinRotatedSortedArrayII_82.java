package leetcode;

public class SearchinRotatedSortedArrayII_82 {
	public static int search(int[] A, int target) {
		int l = 0, r = A.length - 1, t = target, m = -1;
		while (l < r) {
			m = l + ((r - l) >> 1);
			if (A[m] > A[r]) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		int rot = l, n = A.length, d;
		l = 0; r = A.length - 1;
		
		while (l <= r) {
			m = l + ((r - l) >> 1);
			d = (m + rot) % n;
			if (A[d] == t) return d;
			if (A[d] < t) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return -1;
	}
	
    public int search1(int[] nums, int target) {
        int l=0, h = nums.length-1, t = target;
        while(l <= h){
            int m = l+(h-l)/2;
// If the middle element matches the target, simply return middle Index.
            if(nums[m] == t)
                return m;
// If the sequence, low to mid is increasing.
            if(nums[l] <= nums[m]){
// As my low to mid seq is increasing, and If the target is bigger than mid, then I cannot 
//have my target b/w low to mid, process right half. Similar case for if the target is 
// lesser than low.
                if(t < nums[l] || t > nums[m])
                    l = m+1;
// else process the left half.
                else
                    h = m-1;
            }
// If the sequence mid to hi is increasing. 
else{
// As the sequcence mid to Hi is increasing, and If the  target is bigger than Hi or
// lesser than Mid,  It cannot be in the right half. so Process left. 
                if(t > nums[h] || t < nums[m])
                    h = m-1;
// Else process right. 
                else
                    l = m+1;
            }
        }
// Element not found. 
        return -1;
    }
}
