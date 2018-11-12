package job;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HostsandTotalNumber {
	public static void Hosts(String fileName) {
		Map<String, Integer> map = new HashMap<String, Integer>();
        try { 
            File filename = new File(fileName); 
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); 
            BufferedReader br = new BufferedReader(reader);
            String line, url;
            while ((line = br.readLine()) != null) {
            	url = line.substring(0, line.indexOf("-") - 1);
            	map.put(url, map.getOrDefault(url, 0) + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File writename = new File("/Users/Frimish/Desktop/output.txt"); 
            writename.createNewFile(); 
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
            	 out.write(entry.getKey() + " " + entry.getValue() +  "\r\n"); 
            }
            out.flush(); 
            out.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		String filename = "/Users/Frimish/Desktop/input.txt";
		Map<String, Integer> map = new HashMap<String, Integer>();
        try { 
            File file = new File(filename); 
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(file)); 
            BufferedReader br = new BufferedReader(reader);
            String line;
            map.put("burger.letters.com", 0);
            map.put("d104.aa.net", 0);
            map.put("unicomp6.unicomp.net", 0);
            while ((line = br.readLine()) != null) {
            	if (line.indexOf(" ") > 0) {
            		String url = line.substring(0, line.indexOf(" "));
		            if (map.containsKey(url)) {
		            	map.put(url, map.get(url) + 1);
		            }
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File writename = new File("/Users/Frimish/Desktop/records_hosts_access_log_00"); 
            writename.createNewFile(); 
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
            	 out.write(entry.getKey() + " " + entry.getValue() +  "\r\n"); 
            }
            out.flush(); 
            out.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("dynip42.efn.org".split(".").length);
	}
}
