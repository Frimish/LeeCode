package leetcode;

public class ShiftingLetters_848 {
	public static String shiftingLetters(String S, int[] shifts) {
		shifts[shifts.length - 1] = shifts[shifts.length - 1] % 26;
		for (int i = shifts.length - 2; i >= 0; i--) {
			shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
		}
		char[] ch = new char[S.length()];
		for (int i = 0; i < S.length(); i++) {
			ch[i] = (char) ((S.charAt(i) - 'a' + shifts[i]) % 26 + 'a');
		}
		return String.valueOf(ch);
	}
	
	public static void main(String[] args) {
		System.out.println(shiftingLetters("ruu",
				new int[] {26,9,17}));
	}
}
