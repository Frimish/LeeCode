package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    class Node{
        Node(int _key, int _value){
            key = _key;
            value = _value;
            frequency = 1;
        }
        int key;
        int value;
        int frequency;
        Node prev, next;
    }
    
    Map<Integer, Node> key2Value;
    Map<Integer, Node[]> fre2List;
    int cap;
    int size=0;
    int leastFre = 1;

    public LFUCache(int capacity) {
        cap = capacity;
        key2Value = new HashMap<>();
        fre2List = new HashMap<>();
        buildFre(1);
    }
    
    public int get(int key) {
        if(!key2Value.containsKey(key)) return -1;
        Node node = key2Value.get(key);
        deleteNode(node);
        // if the frequency has not nodes
        if(node.prev.value==-1&&node.next.value==-1){
            if(node.frequency==leastFre) leastFre++;
        }
        node.frequency++;
        if(!fre2List.containsKey(node.frequency)){
            buildFre(node.frequency);
        }
        addNode2Fre(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cap==0) return;
        if(key2Value.containsKey(key)){
            get(key);
            key2Value.get(key).value = value;
            return;
        }
        if(size==cap){
            Node[] freList = fre2List.get(leastFre);
            Node deleteNode = freList[1].prev;
            deleteNode(deleteNode);
            key2Value.remove(deleteNode.key);
            size--;
        }
        // reset leastFre
        leastFre = 1;
        Node newNode = new Node(key, value);
        addNode2Fre(newNode);
        key2Value.put(key, newNode);
        size++;
    }
    
    public void addNode2Fre(Node tmp){
        int freq = tmp.frequency;
        Node[] freList = fre2List.get(freq);
        tmp.next = freList[0].next;
        tmp.prev = freList[0];
        tmp.next.prev = tmp;
        tmp.prev.next = tmp;
    }
    
    public void buildFre(int frequency){
        fre2List.put(frequency, new Node[2]);
        Node[] tmp = fre2List.get(frequency);
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        tmp[0] = head;
        tmp[1] = tail;
    }
    
    public void deleteNode(Node tmp){
        tmp.next.prev = tmp.prev;
        tmp.prev.next = tmp.next;
    }
}
