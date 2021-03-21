package array;

public class SpiralMatrix {

    public static void main(String []args) {

        int [][]arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int [][]arr1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int [][]arr2 = {
                {1, 2, 3},
                {4,5, 6},
                {7,8,9},
                {10,11,12}
        };

        int [][]arr3 = {
                {1, 2, 3}
        };


        printSpiralMatrix(arr3);

    }

    public static void printSpiralMatrix(int [][]arr) {

        int rows = arr.length;
        int cols = arr[0].length;

        int urow = 0;
        int brow = rows - 1;
        int lcol = 0;
        int rcol = cols - 1;

        while (urow<=brow && lcol<=rcol) {

            for (int i = lcol; i <= rcol; i++) {
                System.out.println(arr[urow][i]);
            }
            urow++;

            for (int i = urow; i <= brow; i++) {
                System.out.println(arr[i][rcol]);
            }
            rcol--;

            if(urow<brow) {
                for (int i = rcol; i >= lcol; i--) {
                    System.out.println(arr[brow][i]);
                }
                brow--;
            }

            if(lcol<rcol) {
                for (int i = brow; i >= urow; i--) {
                    System.out.println(arr[i][lcol]);
                }
                lcol++;
            }
        }
    }
}
