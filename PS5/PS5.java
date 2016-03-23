import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class PS5 {

    static int possibleDecoding = 0;
    public static int stringConverter(String s) {
        return Integer.valueOf(s);
    }
    public static ArrayList<ArrayList<Integer>> master = new ArrayList<>();
    public static void split(String s) {
        ArrayList<Integer> one = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                Integer la = stringConverter(s);
                one.add(la);
            } else {
                Integer first = stringConverter(s.substring(0, i + 1));
                //System.out.println(first);
                one.add(first);
                String sec = s.substring(i + 1, s.length());
                Integer second = stringConverter(sec);
                one.add(second);
                //System.out.println(one);
                master.add(one);
                for (int j = 0; j < sec.length(); j++) {
                    split(sec);
                } 
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(); // encodings
        ArrayList<Integer> encodings = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            encodings.add(in.nextInt());
        }
        int sEncoding = in.nextInt(); // decimal encoding


        String s = String.valueOf(sEncoding); // encoding in string

        split(s);

        for(ArrayList g : master) { // loop through array of splits
            boolean current = true;
            for (int b = 0; b < g.size(); b++) {
                if (encodings.contains(g.get(b))) {
                    continue;
                } else {
                    current = false;
                }
            }
            if (current) {
                possibleDecoding++;
            }
        }
        System.out.println(master);
        System.out.println(possibleDecoding);
    }
}