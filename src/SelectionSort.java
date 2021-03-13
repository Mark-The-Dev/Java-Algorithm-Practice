import java.util.Arrays;

public class SelectionSort {
    public static int[] selectionSort(int[] array) {

        Arrays.sort(array);
        int idx = 0;

        while(idx < array.length - 1){
            int smallIdx = idx;
            for (int i = idx + 1; i < array.length; i++){
                if(array[smallIdx] > array[i]){
                    smallIdx = i;
                }
            }

            swap(idx, smallIdx, array);
            idx++;

        }
        return array;
    }

    public static void swap(int i, int j, int[] array ){

        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
