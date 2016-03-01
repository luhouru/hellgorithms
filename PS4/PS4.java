import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PS4 {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // lies
        ArrayList<Integer> k = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            k.add(in.nextInt());
        }

        int m = in.nextInt(); // illusions
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            l.add(in.nextInt());
        }

        ArrayList<Integer> costs = new ArrayList<>();

        System.out.println("lies: " + n + k);
        System.out.println("illusions: " + m + l);

    }
}