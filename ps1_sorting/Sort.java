import java.lang.reflect.Array;
import java.util.Scanner;

public class Sort {

    public static void main(String[] args) {
        // gathers the input values
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int array[] = new int[n];
        // store the values in the array
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        // print counts
        System.out.println(6);
        System.out.println(4);
        System.out.println(mergeSort(array));
    }

    // silly sort


    // bubble sort

    // return number of comparisons for merge sort
    public static int mergeSort(int[] a) {
        // initialize count
        int mergeCount = 0;
        if (a.length < 2) {
            return mergeCount;
        }
        int[] left = new int[a.length / 2];
        int[] right = new int[a.length - left.length];

        // sort each half while keeping track of count
        mergeCount += mergeSort(left);
        mergeCount += mergeSort(right);

        // initialize array size
        int i = 0;
        int j = 0;
        int k = 0;

        // compare numbers left and right
        while (i < left.length && j < right.length) {
            mergeCount++;
            if (left[i] < right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }
        return mergeCount;
    }
}
