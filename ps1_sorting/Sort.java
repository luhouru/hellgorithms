import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }

        /*System.out.println(Arrays.toString(arrayList.toArray()));
        System.exit(0);*/

        // print counts for silly sort
        if (n > 9) {
            System.out.println(-1);
        } else {
            System.out.println(sillySort(arrayList));
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
    /*public static int sillySort(int[] a) {
        // initialize count
        int sillyCount = 0;
        if (a.length < 2) {
            return 0;
        } else {
            for (int i = 0; i < a.length - 1; i++) {
                sillyCount++;
                int temp = a[0];
                a[0] = a[i];
                a[i] = temp;
                int[] maybeSorted = a.clone();
                Collections.rotate(Arrays.asList(a), -1);
                for (int j = 0; j < maybeSorted.length - 2; j++) {
                    sillyCount++;
                    if (maybeSorted[j] > maybeSorted[j + 1]) {
                        sillyCount++;
                        break;
                    } else {
                        return sillyCount;
                    }
                }
                int temp2 = a[0];
                a[0] = a[i];
                a[i] = temp2;
            }
            return sillyCount;
        }
    }*/
    public static int sillySort(ArrayList<Integer> a) {
        // initialize silly count
        int sillyCount = 0;
        if (a.size() < 2) {
            return sillyCount;
        } else {
            /*ArrayList<Integer> maybeSorted = null;
            for (int i = 0; i < a.size() - 1; i++) {
                int temp = a.get(0);
                a.set(0, a.get(i));
                a.set(i, temp);
                maybeSorted = a;
                Collections.rotate(maybeSorted, -1);
                System.out.println(Arrays.toString(maybeSorted.toArray()));
                for (int j = 0; j < maybeSorted.size() - 2; j++) {
                    if (maybeSorted.get(j) > maybeSorted.get(j + 1)) {
                        break;
                    } else {
                        return maybeSorted;
                    }
                }
                int temp2 = a.get(0);
                a.set(0, a.get(i));
                a.set(i, temp2);
            }
            return maybeSorted;*/
            ArrayList<Integer> maybeSorted = null;
            for (int i = 0; i < a.size() - 1; i++) {
                sillyCount++;
                int temp = a.get(0);
                a.set(0, a.get(i));
                a.set(i, temp);
                maybeSorted = a;
                Collections.rotate(maybeSorted, -1);
                System.out.println(Arrays.toString(maybeSorted.toArray()));
                for (int j = 0; j < maybeSorted.size() - 2; j++) {
                    if (maybeSorted.get(j) > maybeSorted.get(j + 1)) {
                        break;
                    } else {
                        return sillyCount;
                    }
                }
                int temp2 = a.get(0);
                a.set(0, a.get(i));
                a.set(i, temp2);
            }
            return sillyCount;
        }
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
