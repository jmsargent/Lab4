package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        // create an instance of the SortingTest
        SortingTest tester = new MySortingTest();

        // retrieve all sorters to test
        Map<String,Sorter> sorters = AllSo  rters.getSorters();

        // test each sorter in turn
        for (Map.Entry<String,Sorter> entry : sorters.entrySet()) {

            // retrieve sorter name and value
            String name = entry.getKey();
            Sorter s = entry.getValue();

            // run validSorter on this particular Sorter s
            System.out.println();
            System.out.println("Testing: " + name);
            if (tester.validSorter(s)) {
                System.out.println("NO ERRORS FOUND");
            }
            System.out.println();

        }

    }

}
