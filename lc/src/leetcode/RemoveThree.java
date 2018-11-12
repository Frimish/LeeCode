package leetcode;

public class RemoveThree {
    public static String removeConsecutive(String s) {
        
        for (int i=0,j=0; j<s.length(); j++) {
                // increment j until we see a different char
                if (s.charAt(i) == s.charAt(j)) continue;
                // delete the repeating sequence with more than 3 chars
                if (j-i >= 3) {
                        return removeConsecutive(s.substring(0,i) + s.substring(j));
                }
                else {
                        // search repetition for a new char. 留学申请论坛-一亩三分地
                        i = j;
                }
        }
        return s;
        
}

public static void main(String[] args) {
        
        String input1 = "AABBCCCCDD";
        String input2 = "AABBCCCCBADD";
        System.out.println(input1 + " => " + removeConsecutive(input1));
        System.out.println(input2 + " => " + removeConsecutive(input2));
        
}
}
