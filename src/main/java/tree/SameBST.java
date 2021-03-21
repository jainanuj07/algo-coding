package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBST {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

        if(arrayOne.size() != arrayTwo.size()) return false;

        if(arrayOne.size()==0 && arrayTwo.size()==0) return true;

        if(arrayOne.get(0) != arrayTwo.get(0)) return false;

        List<Integer> leftOne = smaller(arrayOne);
        List<Integer> leftTwo = smaller(arrayTwo);
        List<Integer> rightOne = largerEqual(arrayOne);
        List<Integer> rightTwo = largerEqual(arrayTwo);

        return sameBsts(leftOne,leftTwo) && sameBsts(rightOne,rightTwo);
    }

    static List<Integer> smaller(List<Integer> arr) {
        List<Integer> smaller = new ArrayList<>();
        for(int i=0 ; i<arr.size(); i++) {
            if(arr.get(i).intValue() < arr.get(0).intValue())
            {
                smaller.add(arr.get(i).intValue());
            }
        }
        return smaller;
    }

    static List<Integer> largerEqual(List<Integer> arr) {
        List<Integer> bigger = new ArrayList<>();
        for(int i =0 ; i<arr.size(); i++) {
            if(arr.get(i).intValue() >= arr.get(0).intValue())
            {
                bigger.add(arr.get(i).intValue());
            }
        }
        return bigger;
    }

    public static  void main(String args[]) {
        List<Integer> arrayOne = new ArrayList<Integer>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList<Integer>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        System.out.println(sameBsts(arrayOne,arrayTwo));
    }
}


