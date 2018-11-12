package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TaskSchdule {
	   //if cooldown is very small, but there are lots of tasks, how to reduce space? O(cooldown) space
	   private static int taskSchedule2(int[] tasks, int cooldown) {
	       if (tasks == null || tasks.length == 0) {
	           return 0;
	       }
	       Queue<Integer> queue = new LinkedList<>();//store tasks that are waiting for cooldown?
	       HashMap<Integer, Integer> map = new HashMap<>();//store indices, where cooldown stops, of tasks in window
	       int slots = 0;
	       for (int task : tasks) {
	    	   if (map.containsKey(task) && map.get(task) > slots) {
	    		   int waitTime = map.get(task) - slots;
	    		   slots = map.get(task);
	    	   }
	    	   if (queue.size() > cooldown) {
	    		   map.remove(queue.poll());
	    	   }
	    	   map.put(task, slots + cooldown + 1);
	    	   slots++;
	    	   queue.add(task);
	       }
	       return slots;
	   }

}
