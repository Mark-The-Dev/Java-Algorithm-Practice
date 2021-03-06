import java.util.ArrayList;
import java.util.Arrays;
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
    // create an output of array values as a product of the other values.
    public int[] arrayOfProducts(int[] array) {
        // Write your code here.

        if (array.length == 0) return new int[] {};

        int[] output = new int[array.length];

        int size = array.length - 1;
        int outerLoop = 0;
        int innerLoop = 0;
        int currentVal = 1;

        while(outerLoop <= size){

            if(innerLoop != outerLoop){
                currentVal *= array[innerLoop];
            }

            if (innerLoop == size){
                output[outerLoop] = currentVal;
                outerLoop++;
                innerLoop = 0;
                currentVal = 1;

            } else {
                innerLoop++;
            }
        }
        return output;
    }

    // Algorithm to find the minimum number of coins needed to hit n if possible.
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {

        int[] numOfCoins = new int[n + 1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        numOfCoins[0] = 0;
        int toCompare = 0;

        for (int denom : denoms){
            for (int amount = 0; amount < numOfCoins.length; amount++){
                if (denom <= amount){
                    if(numOfCoins[amount - denom] == Integer.MAX_VALUE){
                        toCompare = numOfCoins[amount - denom];
                    } else{
                        toCompare = numOfCoins[amount - denom] + 1;
                    }
                    numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
                }
            }
        }
        return numOfCoins[n] != Integer.MAX_VALUE ? numOfCoins[n] : -1;
    }

    // Algo to find the max sum of non adjacent numbers in array.
    // O(n) Time complexity, O(1) space complexity
    public static int maxSubsetSumNoAdjacent(int[] array) {

        // if empty or one array item
        if (array.length == 0){
            return 0;
        } else if (array.length == 1){
            return array[0];
        }

        // max value of first slot
        int second = array[0];

        // max value of second slot
        int first = Math.max(array[0], array[1]);

        for (int i =2; i< array.length; i++){
            // check the previous max vs the new idx + older adjacent value
            int current = Math.max(first, second + array[i]);

            // reset second to the previous max
            second = first;

            // set first to the current max
            first = current;
        }

        return first;
    }
}


