import java.util.Arrays;
import java.util.HashMap;

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

    public int nonConstructibleChange(int[] coins) {

        int canCount = 0;

        if (coins.length == 0) return 1;

        Arrays.sort(coins);

        for (int i = 0; i< coins.length; i++){
            if (coins[i] > canCount + 1){
                break;

            } else {
                canCount += coins[i];

            }
        }


        return canCount + 1;
    }

    // validates if a document can be made with a specific string.
    public boolean generateDocument(String characters, String document) {

        if (document.length() == 0) return true;
        if (characters.length() < document.length()) return false;

        HashMap<Character, Integer> chars = new HashMap<>();
        HashMap<Character, Integer> doc = new HashMap<>();

        for (int i = 0; i < characters.length(); i++){
            if (!chars.containsKey(characters.charAt(i))){
                chars.put(characters.charAt(i), 1);
            } else {
                chars.put(characters.charAt(i), chars.get(characters.charAt(i)) + 1);
            }
        }

        for (int i =0; i < document.length(); i++){
            if (!doc.containsKey(document.charAt(i))){
                doc.put(document.charAt(i), 1);
            } else {
                doc.put(document.charAt(i), doc.get(document.charAt(i)) + 1);
            }
        }




        for (Character value : doc.keySet()){
            if ( chars.get(value) == null || chars.get(value) < doc.get(value)) return false;
        }
        return true;
    }

}
