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
        System.out.println(bubbleSort(array));
        System.out.println(mergeSort(array));
    }

    // return number of comparisons for silly sort
    public static int sillySort(int[] a) {
        return 0;
    }

    // return number of comparisons for bubble sort
    public static int bubbleSort(int[] a) {
        // initialize count
        int bubbleCount = 0;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < a.length - 1; i++) {
                bubbleCount++;
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return bubbleCount;
    }
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
