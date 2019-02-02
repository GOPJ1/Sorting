import java.util.Arrays;

public class BubbleSort {

    /**
     * Bubble sort algorithm. Loops over the array and compares adjacent indexes. If the lower indexes value is greater than the higher
     * indexes value, switch the position of the elements.
     * @param array - Array being sorted.
     */
    private static void bubbleSort(int array[]){

        //Keeps track of the arrays length
        int ArrLength = array.length-1;

        //Used to check to the next index to the current
        int nextNum;

        //Loop over the array and compare each value to the next
        for( int i = ArrLength ; i >= 0; i--){
            for( int j = 0; j <= ArrLength-1; j++){
                nextNum = j+1;
                if( array[j] > array[nextNum]){
                    swapNumbers(j, nextNum, array);
                }
            }
        }
    }

    /**
     * Given two indexes and array, switch the positions of the elements.
     * @param index1 - First index to be switched
     * @param index2 - Second index to be switched
     * @param array - Array having it's items switched
     */
    private static void swapNumbers(int index1, int index2, int array[]){
        //Save the first value for later use
        int temp = array[index1];

        //Switch the elements at the given indexes
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Prints the supplied array before and after sorting. Calculates how long the sorting takes.
     * @param array - Array being sorted
     */
    private static void printResults(int array[]){
        System.out.println("Pre-sorted: " + Arrays.toString(array));
        long startTime = System.nanoTime();
        bubbleSort(array);
        long endTime = System.nanoTime();
        System.out.println("Post-sorted: " + Arrays.toString(array));
        long executionTime = endTime-startTime;
        System.out.println("Sort time: " + executionTime/1000 + " seconds.\n");
    }


    public static void main(String[] args) {
        int[] array1 = {1, 4, 6, 10, 14, 55, 7, 2, 43, 5, 32};
        printResults(array1);

        int[] array2 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
        printResults(array2);
    }
}
