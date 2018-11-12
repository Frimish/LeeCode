package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Codec {

	private Map<String, String> map = new HashMap<String, String>();
	private String pre = "http:// tinyurl.com/";
	
	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		map.put(longUrl.hashCode() + "", longUrl);
		return pre + longUrl.hashCode();
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return map.get(shortUrl.substring(pre.length()));
	}
}
