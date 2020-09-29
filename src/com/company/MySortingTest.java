import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class MySortingTest implements SortingTest {

    @Override
    public boolean validSorter(Sorter s) {

        CorrectSorter cs = new CorrectSorter();
        boolean isValid = true;
        boolean sentError = false;

        int[] rndArray;
        int[] attemptSort;
        int[] correctSort;
        boolean isEqual;

        for (int i = 0; i < 20; i++) {
            rndArray = genRndArray(1000, i, true);
            attemptSort = rndArray.clone();
            correctSort = rndArray.clone();

            cs.sort(correctSort);
            try {
                s.sort(attemptSort);
            } catch (ArrayIndexOutOfBoundsException e) {
                sendErrorMessage(rndArray, e, correctSort);
                sentError = true;
                return false;
            }

            // compare Arrays
            isEqual = Arrays.equals(correctSort, attemptSort);

            // check if all indexes contain value
            //isValid = !arrayFilled(attemptSort);

            if (!isEqual) {
                sendErrorMessage(rndArray, attemptSort, correctSort);
                return false;
            }

        }
        return true;
    }

    private boolean arrayFilled(Object[] attemptSort) {
        for (Object o : attemptSort) {
            if (o != null)
                return false;
        }
        return true;
    }


    private void sendErrorMessage(int[] rnd, int[] attemptSort, int[] correctSort) {
        printArray("Before Sort: ", rnd);
        printArray("After Sort: ", attemptSort);
        printArray("Correct: ", correctSort);
    }


    private void sendErrorMessage(int[] rnd, Exception e, int[] correctSort) {
        printArray("Before Sort: ", rnd);
        System.out.println("After Sort: " + e.toString());
        printArray("Correct: ", correctSort);
    }


    /**
     * Generates an array of 20 random ints between -1000,1000
     */
    private static int[] genRndArray(int bound, int length, boolean forceDuplicates) {

        if (length == 0)
            return new int[length];

        int[] a = new int[length];
        Random rnd = new Random();
        int rndPos, duplicate, rndPos2;

        for (int i = 0; i < length; i++) {
            a[i] = rnd.nextInt() % bound;
        }

        if (forceDuplicates) {
            //number at this position is what we duplicate
            rndPos = Math.abs(rnd.nextInt() % (length));
            duplicate = a[rndPos];
            rndPos2 = rndPos;

            // make sure rndPos unique
            if(length > 1) {
                while (rndPos == rndPos2)
                    rndPos2 = Math.abs(rnd.nextInt() % (length));
            }
            a[rndPos] = a[rndPos2];

        }

        return a;
    }


    /**
     * Prints Array with message before it
     */
    private static void printArray(String printMessage, int[] rndArray) {
        System.out.print(printMessage);
        for (int i = 0; i < rndArray.length; ++i) {
            System.out.print(rndArray[i] + " ");
        }
        System.out.print("\n");
    }
}
