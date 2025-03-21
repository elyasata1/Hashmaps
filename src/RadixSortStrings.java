import java.util.*;

public class RadixSortStrings {
    public static void radixSort(String[] arr) {

        int maxLength = 0;
        for (String word : arr) {
            maxLength = Math.max(maxLength, word.length());
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i].length() < maxLength) {
                arr[i] += " ";
            }
        }


        for (int i = maxLength - 1; i >= 0; i--) {
            bucketSort(arr, i);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
        }
    }

    private static void bucketSort(String[] arr, int index) {
        Map<Character, List<String>> buckets = new TreeMap<>();

        for (String word : arr) {
            char key = word.charAt(index);

            if (!buckets.containsKey(key)) {
                buckets.put(key, new ArrayList<>());
            }

            buckets.get(key).add(word);
        }


        int pos = 0;
        for (List<String> bucket : buckets.values()) {
            for (String word : bucket) {
                arr[pos++] = word;
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo",
                "pupperino", "amaterasu", "amazon", "puppy", "hydra", "amazonia", "vueltiao"};

        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
