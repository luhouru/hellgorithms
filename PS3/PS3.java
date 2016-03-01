import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PS3 {

    static int maxThreat = 0;
    static int index1;
    static int index2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // # of stations 1≤n≤10^6  // 4
        int m = in.nextInt(); // # of wires              // 4
        int f = in.nextInt(); // # of wires found 1≤f≤3  // 2

        ArrayList<ArrayList<Integer>> wires = new ArrayList<ArrayList<Integer>>(); // on the next m lines
        // loop through wires to add empty list
        for (int i = 0; i < m; i++) {
            wires.add(new ArrayList<>());
        }
        // loop through wires to add 3 integers per wire

        for (int j = 0; j < m; j++) {
            // loop through wire
            for (int k = 0; k < 3; k++) {
                wires.get(j).add(in.nextInt());
            }
        }

        ArrayList<ArrayList<Integer>> wiresFound = new ArrayList<ArrayList<Integer>>(); // on the next f lines
        // loop through wiresFound to add empty list
        for (int l = 0; l < f; l++) {
            wiresFound.add(new ArrayList<>());
        }
        // loop through wiresFound to add 2 integers per wireFound
        for (int o = 0; o < wiresFound.size(); o++) {
            // loop through wire
            for (int p = 0; p < 2; p++) {
                wiresFound.get(o).add(in.nextInt());
            }
        }

        for (int s = 0; s < m; s++) {
            // loop through wire
            for (int k = 0; k < 3; k++) {
                if (k == 2) {
                    if (wires.get(s).get(2) > maxThreat) {
                        maxThreat = wires.get(s).get(k);
                        index1 = wires.get(s).get(0);
                        index2 = wires.get(s).get(1);
                    }
                }
            }
        }

        // output
        if (wiresFound.size() == 1) {
            System.out.println("yes");
            System.exit(n);
        }
        for (int v = 0; v < f; v++) {
            ArrayList<Integer> wire = wiresFound.get(v);
            if ((index1 == wire.get(0)) && (index2 == wire.get(1))) {
                System.out.println("no");
            } else if ((index1 == wire.get(1)) && (index2 == wire.get(0))) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
}