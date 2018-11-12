package leetcode;

public class H_Index_II {
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int l = 0, r = citations.length - 1, mid = 0;
        while (l < r) {
        	mid = l + ((r - l) >> 1);
        	if (citations[citations.length  - mid - 1] >= mid + 1) {
        		l = mid + 1;
        	} else {
        		r = mid;
        	}
        }
        
        return l;
    }
    
    public static void main(String[] args) {
		System.out.println(hIndex(new int[] {100}));
	}
}
