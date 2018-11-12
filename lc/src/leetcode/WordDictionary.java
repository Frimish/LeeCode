package leetcode;

public class WordDictionary {
	
	public class TrieNode {
		public TrieNode[] children = new TrieNode[27];
		public String val = "";
	}
	
	private TrieNode root; 
	
    /** Initialize your data structure here. */
    public WordDictionary() {
    	this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	TrieNode node = root;
        for (char ch : word.toCharArray()) {
        	if (node.children[ch - 'a'] == null) {
        		node.children[ch - 'a'] = new TrieNode();
        	}
        	node = node.children[ch - 'a'];
        }
        node.val = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return isMatch(word.toCharArray(), 0, root);
    }

	private boolean isMatch(char[] chs, int step, TrieNode node) {
		if (step == chs.length) {
			if ("".equals(node.val)) return false;
			return true;
		} 
		if (chs[step] == '.') {
			for (int i = 0; i < node.children.length; i++) {
				if(node.children[i] != null && isMatch(chs, step + 1, node.children[i]))
					return true;
			}
			return false;
		} 
		return node.children[chs[step] - 'a'] != null && isMatch(chs, step + 1, node.children[chs[step] - 'a']);
	}
    
}
