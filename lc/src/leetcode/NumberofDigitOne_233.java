package leetcode;

public class NumberofDigitOne_233 {
    public static int countDigitOne(int n) {
        int q = n, e = 1, ans = 0;
        while (q > 0) {
            int digit = q % 10;
            q /= 10;
            ans += q * e;
            if (digit == 1) ans += n % e + 1;
            if (digit >  1) ans += e;
            e *= 10;
        } 
        return ans;
    }
    
    
    public static void main(String[] args) {
		System.out.println(countDigitOne(111));
	}
}
