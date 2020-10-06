import java.util.Random;


public class MySortingTest implements SortingTest {

    private int[] arraymaker(int len) {

        int[] intArray = new int[len];

        Random purerandom = new Random();
        int i = -1;
        while (++i < len) {


            intArray[i] = purerandom.nextInt() % 1000;
            //System.out.print(IntArray[i]);
            //System.out.print(" ");
        }

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
        Random random = new Random();
        int randomLen = random.nextInt(20);
        boolean wasCorrect = true;


        int arrstart[] = arraymaker(randomLen);
        int arrSortTest[] = copyray(arrstart);
        int arrSortSafe[] = copyray(arrstart);
        minSorterare.sort(arrSortSafe);
        String correct = arrayString(arrSortSafe);
        //if array-size over 20 return error
        //System.out.print(MySortingTest);


        try {
            s.sort(arrSortTest);
            int testTest;
            int testSafe;
            for (int i = 0; i < randomLen - 1; i++) {
                testTest = arrSortTest[i];
                testSafe = arrSortSafe[i];
                if (testTest != testSafe) {
                    System.out.println("Before sort:   " + arrayString(arrstart));
                    System.out.println("Error: Element " + i + " is value " + testTest + " expected " + testSafe);
                    System.out.println("After test sort:   " + arrayString(arrSortTest));
                    System.out.println("After corrent sort:" + arrayString(arrSortSafe));
                    wasCorrect = false;
                    break;
                }
            }
            for (int i = 0; i < randomLen -1; i++) {
            int whyno = random.nextInt(19)+1;

            //Just fucking up array because test requires us to
            if(i == whyno){
                arrSortTest[i] = arrSortTest[i-1];
                System.out.println("I fucked up index " + i);
            }

            }


            //if(AllSorters.getSorters().containsKey())
            //catch "all-for-one"

            //catch "almost-bubbly"

            //catch i-see-no-neg

            //catch oblivious


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Before sort:   " + arrayString(arrstart));
            System.out.println("ERROR: " + e);
            System.out.println("Expected after: " + correct);
            System.out.println("");
            wasCorrect = false;
        }


        //catch tampering with duplicate


        return wasCorrect;
    }
}
