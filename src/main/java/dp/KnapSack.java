package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapSack {
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        // Write your code here.
        // Replace the code below.

        int[][] profit = new int[items.length+1][capacity+1];

        for(int i=1;i<items.length+1;i++)
        {

            int currentvalue = items[i-1][0];
            int currentweight = items[i-1][1];

            for(int j=0;j<capacity+1;j++)
            {
                if(currentweight>j)
                {
                    profit[i][j] = profit[i-1][j];
                }
                else
                {
                    profit[i][j]=Math.max(profit[i-1][j],currentvalue+profit[i-1][j-currentweight]);
                }
            }
        }

        for(int i=0;i<items.length+1;i++)
        {
            for(int j=0;j<capacity+1;j++)
            {
                System.out.print(profit[i][j]+" ");
            }
            System.out.println();
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(profit[items.length][capacity]));
        ArrayList<Integer> res1 = new ArrayList<>();

        int i=items.length;
        int j = capacity;

        while(i>0)
        {
            if(profit[i][j] == profit[i-1][j])
            {
                i--;
            }
            else
            {
                res1.add(0,i-1);
                i--;
                j= j-items[i][1];
            }
        }
        res.add(res1);
        return res;
    }

    public static void main(String args[]) {

        int[][] input = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        System.out.println(knapsackProblem(input,10).toString());
    }
}
