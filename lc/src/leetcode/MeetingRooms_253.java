package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms_253 {
	public int minMeetingRooms(Interval[] intervals) {

		if (intervals.length <= 1) return intervals.length;

		Arrays.sort(intervals, (x, y) -> x.start == y.start ? y.end - x.end : x.start - y.start);

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.offer(intervals[0].end);
		for (int i = 1; i < intervals.length; i++) {

			if (intervals[i].start >= queue.peek()) queue.poll();
			queue.offer(intervals[i].end);
		}
		return queue.size();
	}
	// sort the intervals order by start time ASC and end time DESC
	// using a PriorityQueue to maintain the earliest meeting room's end time
	// if a new interval's start time is not later than or same as the earliest
	// meeting room's end time in current queue
	// then need allocate a new room
}
