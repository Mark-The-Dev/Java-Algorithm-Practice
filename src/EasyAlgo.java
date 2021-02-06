public class EasyAlgo {

    public static int binarySearch(int[] array, int target) {
        // Write your code here.


        int leftIdx = 0;
        int rightIdx = array.length - 1;
        int currentIdx = (leftIdx + rightIdx) / 2;
        int size = array.length;

        if (array[rightIdx] == target){
            return rightIdx;
        }

        while (size > 1) {

            if (array[currentIdx] == target){
                return currentIdx;
            } else if (array[currentIdx +1] == target){
                return currentIdx + 1;
            } else if (array[currentIdx - 1] == target){
                return currentIdx - 1;
            }



            if (array[currentIdx] > target){
                rightIdx = currentIdx;
                currentIdx /= 2;
            } else if ( array[currentIdx] < target){
                leftIdx = currentIdx;
                currentIdx = (leftIdx + rightIdx) /2;
            }

            size /=2;

        }

        return -1;
    }

}
