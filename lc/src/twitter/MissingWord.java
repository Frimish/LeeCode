package twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingWord {
	public static List<String> missingWords(String s, String t) {
	    // Write your code here
	        List<String> words = new ArrayList<>();

	        String[] tTokens = t.split(" ");
	        String[] sTokens = s.split(" ");

	        System.out.println("sTokens = " + Arrays.asList(sTokens));
	        System.out.println("tTokens = " + Arrays.asList(tTokens));

	        for (int i = 0, j = 0; i < sTokens.length; i++) {
	            if (!sTokens[i].trim().equals(tTokens[j].trim())) {
	                words.add(sTokens[i]);
	            } else {
	                if (j >= tTokens.length - 1) {
	                    continue;
	                } else {
	                    j++;
	                }
	            }
	        }

	        return words;
	}
}
