package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        
        int i = 0; 
        while (i < words.length) {
            int count = 0, sum = 0;
            while (i < words.length && sum + words[i].length() <= maxWidth) {
                count++;
                sum += words[i].length() + 1;
                i++;
            }

            StringBuilder sb = new StringBuilder();
            if (count == 1 || i == words.length - 1) {
                for (int j = i - count; j < i; j++) {
                    sb.append(words[j]);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int j = 0; j < maxWidth - sb.length(); j++) {
                    sb.append(" ");
                }
            } else {
                int avespace = (maxWidth - sum + count) / (count - 1); // 计算
                int remains = (maxWidth - sum + count) % (count - 1);
                for (int j = i - count; j < i - 1; j++) {
                    sb.append(words[j]);
                    int times = 0;
                    if (j == i - 2) {
                        times = remains;
                    } else {
                        times = avespace;
                    }
                    for (int k = 0; k < times; k++)
                        sb.append(" ");
                }
                sb.append(words[i - 1]);
            }
        res.add(sb.toString());
        }    
        return res;
    }
    
    public static void main(String[] args) {
        TextJustification a = new TextJustification();
        List<String> list = a.fullJustify(new String[]{"Don't","go","around","saying","the",
                "world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."}, 30);
        System.out.println(list);
        for (String s : list) {
            System.out.println(s);
        }

    }

}
