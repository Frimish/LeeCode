package leetcode;

public class CompareVersionNumbers_165 {
	public static int compareVersion(String version1, String version2) {
		version1 = version1 + ".";
		version2 = version2 + ".";
		return compare(version1, version2);
	}

	private static int compare(String version1, String version2) {
		if (version1.isEmpty() && version2.isEmpty()) return 0;
		int value1 = version1.isEmpty() ? 0 : Integer.valueOf(version1.substring(0, version1.indexOf(".")));
		int value2 = version2.isEmpty() ? 0 : Integer.valueOf(version2.substring(0, version2.indexOf(".")));
		if (value1 > value2)
			return 1;
		else if (value1 < value2)
			return -1;
		else {
			return compare(version1.substring(version1.indexOf(".") + 1), version2.substring(version2.indexOf(".") + 1));
		}
	}
	
	public static void main(String[] args) {
		System.out.println(compareVersion("7.0.1", "7.01"));
	}

}
