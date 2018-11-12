package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CloneGraph_133 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Set<Integer> set = new HashSet<Integer>();
		queue.offer(node);
		set.add(node.label);
		UndirectedGraphNode firstnode = null;
		boolean first = true;
		while (!queue.isEmpty()) {
			UndirectedGraphNode curnode = queue.poll();
			UndirectedGraphNode newnode = new UndirectedGraphNode(curnode.label);
			for (UndirectedGraphNode neighbor : curnode.neighbors) {
				if (!set.contains(neighbor.label)) {
					set.add(neighbor.label);
					newnode.neighbors.add(neighbor);
					queue.offer(neighbor);
				}
			}
			
    		if (first) {
    			first = false;
    			firstnode = newnode;
    		}
		}
		return firstnode;
	}
}
