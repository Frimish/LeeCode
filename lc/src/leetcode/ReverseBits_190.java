package leetcode;

public class ReverseBits_190 {
    public static int reverseBits(int n) {
    	int res = 0;
    	int m = n;
        for (int i = 0; i < 32; i++) {
        	res = res + (((m >> i) & 1) << (31 - i));
        }
        return (int)res;
    	
//    	int ans = 0;
//    	int flag = 1;
//        while(flag!=0) {
//        	ans = (ans<<1)+(n&1);     	       	
//        	n = n>>1;
//        	flag = flag<<1;
//        }
//        return ans;
    }
    public static void main(String[] args) {
		System.out.println(reverseBits(10));
	}
}
