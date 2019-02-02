import java.util.Arrays;

public class BubbleSort {

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

    private static void swapNumbers(int index1, int index2, int array[]){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

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
