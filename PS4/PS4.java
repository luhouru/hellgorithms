
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
        Collections.reverse(k);
        Collections.reverse(l);
        ArrayList<Integer> answers = new ArrayList<>();

        int c1 = k.size() - 1;
        int c2 = l.size() - 1;
        int c = c1 + c2;

        int sum;
        for (int i = 0; i <= c; i++) {
            if (i == 0) {
                sum = k.get(i) * l.get(i);
                answers.add(0, sum);
                continue;
            }
            if (i == 1) {
                int first = k.get(i - 1) * l.get(i);
                int second = k.get(i) * l.get(i - 1);
                sum = first + second;
                answers.add(0, sum);
                continue;
            }
            
            ArrayList<Integer> sums = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) { //
                int firstNum = j; // 0 // 1 // 2
                int secondNum = i - j; // 2 // 1 // 0
                int firstMul;
                try {
                    firstMul = k.get(firstNum) * l.get(secondNum);
                    sums.add(firstMul);
                } catch (IndexOutOfBoundsException e) {
                    firstMul = 0;
                    sums.add(firstMul);
                }
            }
            int sumLa = 0;
            for (int b = 0; b < sums.size(); b++) {
                int temp = sums.get(b);
                sumLa += temp;
            }
            answers.add(0, sumLa);
            continue;
        }

        for (int a = 0; a < answers.size(); a++) {
            System.out.print(answers.get(a));
            if (!(a==(answers.size()-1))) {
                System.out.print(" ");
            }
        }
    }
}