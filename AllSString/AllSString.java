import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AllSString {


    static ArrayList<ArrayList<Integer>> master;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        s = in.nextLine(); //apple


        for (int i = 0; i < s.length(); i++) {
            ArrayList<Integer> one = new ArrayList<Integer>();
            if (i == s.length() - 1) {
                Integer la = Integer.valueOf(s);
                one.add(la);
            } else {
                Integer first = Integer.valueOf(s.substring(0, i + 1));
                String sec = s.substring(i + 1, s.length());

                one.add(first);
                for (int j = 0; j < sec.length(); j++) {

                }
            }
            master.add(one);


        }

        System.out.println(master);
    }
}