import java.util.ArrayList;
import java.util.List;

public class MediumAlgo {

    // traverse a 2d array in spiral pattern.

    public static List<Integer> spiralTraverse(int[][] array) {

        if (array.length == 0) return new ArrayList<Integer>();

        int startRow = 0;
        int startCol = 0;
        int endRow = array.length -1;
        int endCol = array[0].length -1;

        ArrayList<Integer> spiralList = new ArrayList<Integer>();

        // traverse through these, while start row/col <= end row/col


        while(startCol <= endCol && startRow <= endRow){

            // loop through first row
            for (int col = startCol; col <= endCol; col++){
                spiralList.add(array[startRow][col]);
            }

            // loop through end collumn tracking downwards
            for (int row = startRow + 1; row <= endRow; row++){

                spiralList.add(array[row][endCol]);
            }

            // loop through bottom row backwards
            for (int col = endCol -1; col >= startCol; col--){

                // break if single row

                if (startRow == endRow) break;

                spiralList.add(array[endRow][col]);
            }


            // loop through first first collum in reverse
            for (int row = endRow -1; row > startRow; row--){

                // break if single collumn
                if (startCol == endCol) break;
                spiralList.add(array[row][startCol]);

            }

            // at end adjust all counters
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }


        return spiralList;
    }

    // check if array values are monotonic
    public static boolean isMonotonic(int[] array) {
        // Write your code here.

        boolean inc = false;
        boolean dec = false;

        for (int i =1; i < array.length; i++){

            if (array[i] > array[i -1]){

                inc = true;

            } else if (array[i] < array[i - 1]){

                dec = true;
            }

            if (inc && dec){

                return false;
            }

        }

        return true;
    }
    //first duplicate value in array
    public int firstDuplicateValue(int[] array) {
        // Write your code here.

        ArrayList<Integer> newVals =  new ArrayList<Integer>();

        for (int i= 0; i < array.length; i++){

            if (newVals.contains(array[i])){

                return array[i];
            }

            newVals.add(array[i]);
        }

        return -1;
    }

}
