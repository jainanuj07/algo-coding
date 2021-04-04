/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
*/
/**********************************/


/*
Time Complexity : O(NlogN)
Space Complexity: O(N)
*/


package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms253 {
    public static int minMeetingRooms(int[][] intervals) {

        PriorityQueue<Integer> rooms = new PriorityQueue<>(intervals.length,
                (a,b)->Integer.compare(a,b));

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        rooms.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0]>=rooms.peek()) {
                rooms.poll();
            }
            rooms.add(intervals[i][1]);
        }
        return rooms.size();
    }

    public static void main(String args[]) {
        int intervals[][] = new int[][] {{7,10},{2,4}};
        System.out.println(minMeetingRooms(intervals));
    }
}
