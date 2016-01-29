import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solutions {

    public static void main(String[] args) {
        // gathers the input values
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int array[] = new int[n];
        // store the values in the array
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        // array list for silly sort
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        // print counts for silly sort
        if (n > 9) {
            System.out.println(-1);
        } else {
            System.out.println(sillySort(list));
        }

        // print counts for bubbly sort
        if (n > 100000) {
            System.out.println(-1);
        } else {
            System.out.println(bubbleSort(array));
        }

        // print counts for merge sort
        System.out.println(mergeSort(array));
    }

    // return number of comparisons for silly sort
    public static int sillySort(ArrayList<Integer> a) {
        // initialize silly count
        int sillyCount = 0;

        // return 0 if n is less than 2
        if (a.size() < 2) {
            return sillyCount;
        }
        /*
        for (int i = 0; i < a.size() - 1; i++) {
            //sillyCount++;
            System.out.println("Before swap: " + Arrays.toString(a.toArray()));
            Integer first = a.get(0); // save first
            a.set(0, a.get(i)); // set first to a[i]
            a.set(i, first); // set a[i] to first
            //System.out.println(Arrays.toString(a.toArray));
            System.out.println("After swap: " + Arrays.toString(a.toArray()));

            // maybe sorted
            ArrayList<Integer> temp = new ArrayList<Integer>();
                // concat to end
                //sillyCount++;
                for (int b = 1; b < a.size(); b++) {
                    System.out.println("adding to temp: " + a.get(b));
                    temp.add(a.get(b));
                }

                System.out.println("Temp after swap: " + Arrays.toString(temp.toArray()));
                sillyCount++;
                sillyCount += sillySort(temp);



            for (int j = 0; j < temp.size() - 2; j++) {
                //sillyCount++;
                if (temp.get(j) > temp.get(j + 1)) {
                    sillyCount++;
                    break;
                }
                //sillyCount++;
                sillyCount += sillySort(temp);
            }
            // after second loop
            sillyCount++;
            System.out.println("After second loop: " + Arrays.toString(temp.toArray()));
            Integer swapBack = a.get(0); // save first
            a.set(0, a.get(i)); // set first to a[i]
            a.set(i, swapBack); // set a[i] to first
            System.out.println("After swap back: " + Arrays.toString(temp.toArray()));
            //sillyCount += sillySort(temp);
        }*/
        return sillyCount;
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
