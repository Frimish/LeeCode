package leetcode;

public class PrimePalindrome_866 {
	public int primePalindrome(int n) {
		if (n == 1 || n == 2)
			return n;
		if (n % 2 == 0)
			n++;
		while (true) {
			if (isPalindrome(n) && isPrime(n))
				return n;
			n += 2;
		    if (10_000_000 < n && n < 100_000_000)
	                n = 100_000_001;
		}
	}

	private static boolean isPrime(int n) {
		int end = (int) Math.sqrt(n);
		for (int i = 3; i <= end; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}


	private boolean isPalindrome(int n) {
		if (n % 10 == 0) return false;
		int m = 0; 
		while (n > m) {
			m = m * 10 + n % 10;
			n /= 10;
		}
		return (n == m ) || (n == m / 10);
	}
	
	public static void main(String[] args) {
		System.out.println(Math.sqrt(200000000));
	}
}
