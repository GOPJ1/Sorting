import java.util.Arrays;

/**
 * @author John Knecht V (jjk1492@rit.edu)
 *
 * Implementation of the Merge Sort algorithm. Merge sort is a divide-and-conquer algorithm with O(n*log(n)) complexity for all cases.
 *
 * Breaks down an array into sub-arrays of length 0 or 1. An array of this length is guranteed to be sorted, once the array is fully
 * broken down into subarrays, compare the elements of two sub arrays and combine them in order.
 */
public class MergeSort {

    /**
     * Given an array of two sorted sub-arrays (Example: [1, 3, 6, 9, 12, 4, 7, 11, 15] The array is sorted from 0 to the midpoint
     * and from the midpoint to the end index.) Combine the sub-arrays into one sorted array.
     * @param array - Array containing two sub-arrays to be combined.
     * @param start - The started index of the array
     * @param mid - The middle index of the array.
     * @param end - The last index of the array.
     */
    private static void merge(int[] array, int start, int mid, int end){

        //Break the array into two smaller, sorted sub-arrays
        int[] lowerHalf = new int[mid - start + 1];
        int[] upperHalf = new int[end - mid];

        //Initialize loop variables
        int k = start;
        int i;
        int j;

        //Fill the lowerHalf array with the first set of sorted values
        for( i=0; k<=mid; i++, k++){
            lowerHalf[i] = array[k];
        }

        //Fill the upperHalf array with the second set of sorted values
        for(j=0; k<=end; j++, k++){
            upperHalf[j] = array[k];
        }

        //Re-initialize the looping variables
        k = start;
        i = 0;
        j = 0;

        //Compare the first element in each array until one array is empty
        while( i < lowerHalf.length && j < upperHalf.length ){
            if( lowerHalf[i] < upperHalf[j] ){
                array[k] = lowerHalf[i];
                i++;
            }else{
                array[k] = upperHalf[j];
                j++;
            }
            k++;
        }

        //Now that one sub-array is empty, the other sub-array should be appended to the main array.
        while(i < lowerHalf.length){
            array[k] = lowerHalf[i];
            k++;
            i++;
        }

        while(j < upperHalf.length){
            array[k] = upperHalf[j];
            k++;
            j++;
        }

    }

    /**
     * Recursively calls merge sort until the supplied array is broken to sub-arrays of length 0 or 1. Once broken down, combines
     * all the sub-arrays back into a sorted array.
     * @param array - Array of integers being sorted
     * @param startIndex - Starting index of the array or sub-array
     * @param endIndex - Ending index of the array or sub-array
     */
    private static void mergeSort(int[] array, int startIndex, int endIndex){

        //Base case, if the start index is >= the end index then the list is broken down to 0 or 1 elements. Therefore merge sort
        //is finished running
        if( startIndex < endIndex ){
            //Calculate middle index of array to split the array
            int midPoint = (startIndex+endIndex)/2;

            //Merge sort each half of the array then combine them
            mergeSort(array, startIndex, midPoint);
            mergeSort(array, midPoint+1, endIndex);
            merge(array, startIndex, midPoint, endIndex);
        }

    }
    public static void main(String[] args) {

        int[] array = {4, 23, -2, 1, 45, 7, 13, 6, 18};
        System.out.println("Array before sorting: " + Arrays.toString(array));
        mergeSort(array, 0, array.length-1);
        System.out.println("Array after sorting: " + Arrays.toString(array) + "\n");

        int[] array2 = {300, 12, 1, 5, 99, 43, 56, -2, -54, 5, 3, 1, 8, 9, 20, 21, 34, 22, 21, 54, 76};
        System.out.println("Array2 before sorting: " + Arrays.toString(array2));
        mergeSort(array2, 0, array2.length-1);
        System.out.println("Array2 after sorting: " + Arrays.toString(array2) + "\n");
    }
}
