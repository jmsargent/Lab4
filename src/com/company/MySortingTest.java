import java.util.Random;

public class MySortingTest implements SortingTest {

    public int[] arraymaker(){

        int [] IntArray = new int[20];

        Random purerandom = new Random();

        for (int i = 0; i <20 ; i++) {


            IntArray[i] = purerandom.nextInt()%1000;
            System.out.print(IntArray[i]);
            System.out.print(" ");
        }
        System.out.println();
    return IntArray;
    }
    @Override
    public boolean validSorter(Sorter s) {

        //if array-size up to 20 return true

        //if array contains val = -1000 to 1000 return true

        //if array contains the same number twice then return !true
        return true;
    }
}
