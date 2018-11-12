package job;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
* @Package job 
* @Title: Firewall.java   
* @Description: Firewall class refer to https://github.com/OmkarMalusare/Illumio-Coding-Test/blob/master/Firewall.java 
* @author Frimish  
* @date 2018年10月7日 下午5:50:54
* @version V1.0
 */
public class Firewall {

	private String path;
	HashSet<String> allowedDirections = new HashSet<String>();
	HashSet<String> allowedProtocol = new HashSet<String>();

	// Constructor
	public Firewall(String path) {
		this.path = path;
	}

	public boolean accept_packet(String direction, String protocol, int port, String ip_address) {

		allowedDirections.add("inbound");
		allowedDirections.add("outbound");

		allowedProtocol.add("tcp");
		allowedProtocol.add("udp");

		return (allowedDirections.contains(direction) && allowedProtocol.contains(protocol) && checkvalidPort(port)
				&& checkIP(ip_address));
	}

	public boolean checkvalidPort(int port) {

		return (port >= 1 && port <= 65535);
	}

	public boolean checkIP(String ip_address) {
		// when there is a range of ip addresses
		if (ip_address.contains("-")) {
			String[] splitIP = ip_address.split("-");
			String startPort = splitIP[0];
			String endPort = splitIP[1];
			return (validate(startPort) && validate(endPort) && compareIP(startPort, endPort));
		}
		// when there is a single ip address
		return validate(ip_address);
	}

	public boolean validate(String ip_address) {

		String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
		Pattern pattern = Pattern.compile(ip);
		Matcher matcher = pattern.matcher(ip_address);
		return matcher.matches();

	}

	public boolean compareIP(String startPort, String endPort) {

		String[] start = startPort.split("\\.");
		String[] end = endPort.split("\\.");
		for (int i = 0; i < start.length; i++) {
			int startInt = Integer.parseInt(start[i]);
			int endInt = Integer.parseInt(end[i]);
			if (startInt == endInt)
				continue;
			if (startInt < endInt)
				return true;
			return false;
		}
		// when the ip addresses will be exactly same
		return false;

	}
	
    


	public static void main(String[] args) {
		Firewall fw = new Firewall("/path/to/fw.csv");
		// Looked up the code to parse a file line by line on the internet
		try {
			BufferedReader br = new BufferedReader(new FileReader(fw.path));

			String line = null;
			while ((line = br.readLine()) != null) {
				// split each line of the csv file by "," and further store the splitted values
				// in an array
				String[] eachLine = line.split(",");
				String direction = eachLine[0];
				String protocol = eachLine[1];
				int port = Integer.parseInt(eachLine[2]);
				String ip_address = eachLine[3];
				// to determine the fate of the packet
				if (fw.accept_packet(direction, protocol, port, ip_address))
					System.out.println("Accepted");
				else
					System.out.println("Blocked");
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}