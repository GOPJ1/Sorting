import java.util.Arrays;

public class MergeSort {

    private static void merge(int[] array, int start, int mid, int end){

        int[] lowerHalf = new int[mid - start + 1];
        int[] upperHalf = new int[end - mid];

        int k = start;
        int i;
        int j;

        for( i=0; k<=mid; i++, k++){
            lowerHalf[i] = array[k];
        }

        for(j=0; k<=end; j++, k++){
            upperHalf[j] = array[k];
        }

        k = start;
        i = 0;
        j = 0;

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

    private static void mergeSort(int[] array, int startIndex, int endIndex){

        if( startIndex < endIndex ){
            int midPoint = (startIndex+endIndex)/2;
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
