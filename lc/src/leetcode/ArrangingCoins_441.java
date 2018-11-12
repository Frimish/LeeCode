package leetcode;

public class ArrangingCoins_441 {
    public static int arrangeCoins(int n) {
        long l = 0, r = n, mid = (r - l) / 2 + l;  
        while (l < r) {
        	 mid = (r - l) / 2 + l;
        	 if (mid * (mid + 1) / 2 == n) return (int)mid;
        	 if (mid * (mid + 1) / 2 > n) {
        		 r = mid - 1;
        	 } else {
        		 l = mid + 1;
        	 }
        }
        l = l * (l + 1)/ 2 > n ? l - 1 : l;
        return (int) l;
    }
    
    
    public static void main(String[] args) {
    	for (int i = 0; i < 100; i++) {
    		System.out.println(i + " " + arrangeCoins(i));
    	}
	}
}
