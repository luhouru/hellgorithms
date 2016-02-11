import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// Problem Set 2
public class Solution {

    // initialize static variable for cheapest price
    static int min;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int k = in.nextInt(); // # of species
        int d = in.nextInt(); // discounts

        int animals[] = new int[k]; // number of animals from each species
        for (int i = 0; i < k; i++) {
            animals[i] = in.nextInt();
        }

        int costs[] = new int[k]; // cost of carrying animals from species 1 individually
        for (int i = 0; i < k; i++) {
            costs[i] = in.nextInt();
        }

        // create a list of different discount programs
        ArrayList<ArrayList<Integer>> programs = new ArrayList<ArrayList<Integer>>();

        // loop through discounts to add empty list
        for (int j = 0; j < d; j++) {
            programs.add(new ArrayList<Integer>());
        }

        // loop through discounts to gather discount information
        for (int j = 0; j < d; j++) {
            for (int a = 0; a < k + 1; a++) {
                programs.get(j).add(in.nextInt());
            }
        }

        // store final costs. each number is the cost for each program
        ArrayList<Integer> finalCosts = new ArrayList<Integer>();
        for (int b = 0; b < d; b++) {
            finalCosts.add(0);
        }

        // loop through different discount programs
        for (int j = 0; j < d; j++) {
            // 10 (program carries 2 animals from s1) progrma carries 1 animal from s2
            ArrayList<Integer> program = programs.get(j); // were working with this
            int programCost = program.get(0); // get premium cost
            finalCosts.set(j, program.get(0)); // add cost to final cost list

            // loop through program itself
            for (int a = 1; a <= k; a++) { // start at 1 for program

                int animalsWODiscount = animals[a - 1]; // 3
                int animalsWDiscount = program.get(a); // 2
                int animalsLeftToCarry = animalsWODiscount - animalsWDiscount; // 1
                int multiplier = animalsLeftToCarry * costs[a - 1]; // 10

                // add to final costs
                finalCosts.set(j, finalCosts.get(j) + multiplier);
            }
        }

        // sort through the list of costs to get the lowest one
        if (finalCosts.isEmpty()) {
            System.out.println(0);
            System.exit(0);
        } else {
            min = finalCosts.get(0);
            for (int z = 1; z < finalCosts.size(); z++) {
                if (finalCosts.get(z) < min) {
                    min = finalCosts.get(z);
                }
            }
        }

        System.out.println(min);
    }
}
