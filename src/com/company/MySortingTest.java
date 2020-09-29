import java.util.Random;

public class MySortingTest implements SortingTest {

    private int[] arraymaker() {

        int[] intArray = new int[20];

        Random purerandom = new Random();

        for (int i = 0; i < 20; i++) {


            intArray[i] = purerandom.nextInt() % 1000;
            //System.out.print(IntArray[i]);
            //System.out.print(" ");
        }
        System.out.println();
        return intArray;
    }

    private int[] copyray(int arr[]) {

        int[] copyArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            copyArray[i] = arr[i];
        }
        return copyArray;
    }

    private String arrayString(int arr[]) {
        int arrlen = arr.length;
        String arrString = "";
        for (int i = 0; i < arrlen; i++) {


            String tempString = String.valueOf(arr[i]);
            arrString = arrString + " " + tempString;

        }
        //System.out.println(arrString);
        return arrString;
    }

    @Override
    public boolean validSorter(Sorter s) {
        CorrectSorter minSorterare = new CorrectSorter();
        int arrstart[] = arraymaker();
        int arrSortTest[] = copyray(arrstart);
        int arrSortSafe[] = copyray(arrstart);
        minSorterare.sort(arrSortSafe);
        String correct = arrayString(arrSortSafe);
        //if array-size over 20 return error
        try {
            s.sort(arrSortTest);
            //if array contains val = -1000 to 1000 return true
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Before sort:   " + arrayString(arrstart));
            System.out.println("ERROR: " + e);
            System.out.println("Expected after: " + correct);
            return false;
        }
        //if array contains the same number twice then return !true



        return true;
    }
}
