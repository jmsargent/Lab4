package com.company;

/** This class acts as a reference implementation for the Sorter
    interface; it is an obviously correct (but inefficient)
    implementation of the Sorter interface. All implementations of the
    Sorter interface are to have a sort function that is functionally
    equivalent to the sort function of CorrectSorter. */
public class CorrectSorter implements Sorter {

    /** sorts the given array with a straightforward bubble sort */
    public void sort(int[] a) {
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a.length-1; j++) {
                if (a[j] > a[j+1]) {
                    swap(a,j,j+1);
                }
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int ai = a[i];
        int aj = a[j];
        a[i] = aj;
        a[j] = ai;
    }

}
