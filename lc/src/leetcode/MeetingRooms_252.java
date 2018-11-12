package leetcode;

import java.util.Arrays;

public class MeetingRooms_252 {
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals.length <= 1) return true;
		Arrays.sort(intervals, (x, y) -> x.start == y.start ? y.end - x.end : x.start - y.start);
		int end = intervals[0].end;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start > end) {
				end = intervals[i].end;
			} else {
				return false; 
			}
		}
		return true;
	}
}
