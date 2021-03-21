package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxIncreasingSubSeq {

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.

        int[] max = new int[array.length];
        int [] seq = new int[array.length];

        for(int i=0;i<array.length;i++) {
            max[i] = array[i];
            seq[i] = i;
        }
        int maxSumIndex=0;
        int maxsum=array[0];
        for(int i=1;i<array.length;i++)
        {
            for(int j=0;j<i;j++) {
                if(array[j] < array[i])
                {
                    if(max[j] + array[i] > max[i])
                    {
                        max[i] = max[j] + array[i];
                        seq[i] =j;
                    }
                }
            }
            if(maxsum < max[i])
            {
                maxsum= max[i];
                maxSumIndex = i;
            }
        }


        int index =maxSumIndex ;
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(maxsum));
        List<Integer> res1 = new ArrayList<>();
        while(index>=0){
            res1.add(array[index]);
            if(seq[index] == index)
            {
                break;
            }
            index = seq[index];
        }
        res.add(res1);
        return res;

    }

    public static int minNumberOfJumps(int[] array) {
        // Write your code here.
        int ways[] = new int[array.length];
        ways[0]=0;
        for(int i=0;i<array.length;i++)
        {
            ways[i] = Integer.MAX_VALUE;
        }

        for(int i=1;i<array.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(j+array[j]>=i)
                {
                    ways[i]= Math.min(ways[i],ways[j]+1);
                }
            }
        }

        return ways[array.length-1];
    }

    public static void main(String args[])
    {
        int[] input = {10, 70, 20, 30, 50, 11, 30};

        int input1 [] = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};

       // System.out.println(maxSumIncreasingSubsequence(input).toString());
        System.out.println(minNumberOfJumps(input1));
    }
}
