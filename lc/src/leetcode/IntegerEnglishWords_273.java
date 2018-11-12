package leetcode;

public class IntegerEnglishWords_273 {
	private static String[] carry = new String[] { "", "Thousand", "Million", "Billion" };
	private static String[] digit = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen"};
	private static String[] tens = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	public static String numberToWords(int num) {
		StringBuilder sb = new StringBuilder();
		if (num == 0)
			return "Zero";
		read(sb, num, 0);
		return sb.toString().substring(0, sb.length() - 1);
	}

	private static void read(StringBuilder sb, int num, int idx) {
		if (num == 0) return;
		if (num < 1000) {
			if (num >= 100) {
				sb.append(digit[num / 100]).append(" ").append("Hundred").append(" ");
				num %= 100;
			}
			if (num >= 20) {
				sb.append(tens[num / 10]).append(" ");
				num %= 10;
			}
			if (digit[num].length() > 0)
			sb.append(digit[num]).append(" ");
			if (carry[idx].length() > 0)
			sb.append(carry[idx]).append(" ");
			
			return;
		}
		read(sb, num / 1000, idx + 1);
		read(sb, num % 1000, idx);
	}
	
	public static void main(String[] args) {
		System.out.println(numberToWords(1230));
	}
}
