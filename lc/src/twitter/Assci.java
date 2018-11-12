package twitter;

public class Assci {
	static String decode(String encoded) {
		if (encoded.length() == 0)
			return "";
		StringBuilder sb = new StringBuilder(encoded.trim());
		String s = sb.reverse().toString();
		StringBuilder res = new StringBuilder();
		while (s.length() != 0) {
			if (s.startsWith("3")) {
				res.append(" ");
				s = s.substring(2);
			} else if (s.startsWith("1")) {
				int code = Integer.valueOf(s.substring(0, 3));
				res.append((char)code);
				s = s.substring(3);
			} else {
				int code = Integer.valueOf(s.substring(0, 2));
				res.append((char)code);
				s = s.substring(2);
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		System.out.println(decode("2312179862310199501872379231018117927"));
	}
}
