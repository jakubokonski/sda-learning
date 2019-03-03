import java.util.*;

public class _38_CollectionTask {
    public static void main(String[] args) {

        String[] words = "t1 w2 e3 w2 e3 t1 o1 o1 t1 p1 i3 j1 i2 i2 i3 j1 j1 t1 w2 w2".split("\\s+"); // rozbij po spacjach, po wielu białych znakach
        System.out.println(Arrays.toString(words));

        /*
            1. count every word and put into map: key (word) -> count (value).
                print which is the most frequent.

            2. deduplicate words, sort and print - use set

            3. put deduplicated words into queue and poll them all.
         */

        // 1.

        Map<String, Integer> countWords = new HashMap<>();

        for (String word : words) {
            // System.out.println(count);
            if (!countWords.containsKey(word)) {
                countWords.put(word, 1);
            } else {
                int value = countWords.get(word);
                countWords.put(word, ++value);
            }
        }
        System.out.println("Count map: " + countWords);
        // print the most frequent value
        String mostFrequentWord = null;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : countWords.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }
        System.out.println("Most frequent word: " + mostFrequentWord);

        // 2.
        Set<String> deduplicatedAndSorted = new TreeSet<>(Arrays.asList(words));
        System.out.println("Deduplicated and sorted: " + deduplicatedAndSorted);

        // 3.
        Queue<String> queue = new PriorityQueue<>(deduplicatedAndSorted);
        String word;
        while ((word = queue.poll()) != null) {
            System.out.println("Word pulled " + word);
        }
    }
}
