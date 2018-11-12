package leetcode;

public class NthDigit_400 {
	public  static int findNthDigit(int n) {
		long scale = 1, len = 1; 
		while (n > 9 * scale * len) {
			n -=  9 * scale * len;
			len ++;
			scale *= 10;
		}
		long number = (n - 1) / len + scale;
		System.out.println(String.valueOf(number));
		return String.valueOf(number).charAt((int)((n - 1) % len)) - '0';
	}
	
	public static void main(String[] args) {
		System.out.println(findNthDigit(2147483647));
	}
}
