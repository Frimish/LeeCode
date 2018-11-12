package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LRUCache1 {
	
	private List<Integer> keys = new ArrayList<Integer>();
	private List<Integer> values = new ArrayList<Integer>();
	private int capacity = 0;
	private int size = 0;
	
    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	int idx = keys.indexOf(key);
    	if (idx >= 0) {
    		int value = values.get(idx);
    		keys.add(keys.remove(idx));
    		values.add(values.remove(idx));
    		return value;
    	} 
    	return -1;
    }
    
    public void put(int key, int value) {
    	int idx = keys.indexOf(key);
    	if (idx >= 0) {
    		keys.remove(idx);
    		values.remove(idx);
        } else if (size == capacity) {
        	keys.remove(0);
        	values.remove(0);
        }
        keys.add(key);
		values.add(value);
    }
}
