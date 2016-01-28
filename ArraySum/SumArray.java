import java.util.Scanner;

public class SumArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        // option 1
        /* // array has been initialized
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }*/

        // option 2
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}

