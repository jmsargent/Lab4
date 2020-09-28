/** A SortingTest contains a function for determining whether a
    given Sorter is correctly implemented. */
public interface SortingTest {

    /** This function tests that the given Sorter object's sort
      * function correctly sorts arrays of integers. The tests are
      * performed on randomly generated arrays of integers. This
      * function returns true if the Sorter passes all tests;
      * otherwise false. If a test fails, then validSorter prints
      * (1) the input state of the array for which sort failed,
      * (2) the erronous resulting state of the array (or a
      *     description of the exception, if an exception was thrown)
      * (3) the expected resulting state of the array. */
    public boolean validSorter(Sorter s);

}
