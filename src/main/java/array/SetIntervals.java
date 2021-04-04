package array;

import java.util.Arrays;

public class SetIntervals {

    public static void main(String args[]) {
        int[][] intervals = {
                {3,4},
                {3,6},
                {1,2},
                {2,3}
        };

        Arrays.sort(intervals,(a,b) -> a[0]!=b[0] ? a[0]-b[0] : b[1]-a[1]);
        System.out.println(Arrays.deepToString(intervals));


    }
}
