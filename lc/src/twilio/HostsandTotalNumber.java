package twilio;

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
		Hosts("/Users/Frimish/Desktop/input.txt");
	}
}
