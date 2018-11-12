package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Codeccc {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("|").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int pos = -1, len = 0;
        while (!s.isEmpty()) {
            pos = s.indexOf("|");
            len = Integer.valueOf(s.substring(0, pos));
            res.add(s.substring(pos + 1, pos + len + 1));
            s = s.substring(pos + len + 1);
        }
        return res;
    }
}
