/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true
*/

/*
Time Complexity : nlog(n)
Space Complexity: O(1)
 */

package leetcode;

import java.util.Arrays;

public class MeetingRooms252 {

    public static boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i + 1][0] < intervals[i][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int intervals[][] = new int[][] {{0,30},{5,10},{15,20}};
        System.out.println(canAttendMeetings(intervals));
    }
}
