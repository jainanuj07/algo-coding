/***
 *
 * Merge Sort with in place merge
 */

// Example arr[]=  [ 5 9 2 3 7 1 8 ]

import java.util.Arrays;

public class MergeSort {

    public static void main(String args[]) {
        int arr[] = new int[] {5, 9, 2, 3, 7, 1, 8};
        int arr1[] = new int[] {1,2,3,2,5,6};

        System.out.println(Arrays.toString(arr));
        mergeSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        System.out.println("mergeSort--" + start + " " + end);

        if (start < end) {
            try {
                int mid = (start + end) / 2;
                mergeSort(arr, start, mid);
                mergeSort(arr, mid + 1, end);
                merge(arr, start, mid, end);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        System.out.println("merge--" + start + " " + mid + " " + end);

        int start2 = mid + 1;
        if (arr[mid] <= arr[start2]) {
            return;
        }
        while (start <= mid && start2 <= end) {
            System.out.println(start +" "+ mid+ "  "+start2);
            if (arr[start] <= arr[start2]) {
                start++;
            } else {
                int index = start2;
                int value = arr[start2];
                while (index > start) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start] = value;
                start++;
                mid++;
                start2++;
            }
        }
    }
}
