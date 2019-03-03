import java.util.*;

public class _37_Maps {
    public static void main(String[] args) {
        /*
            Maps are:
            - key-value based data structures
            - equals and hashcode are very important!
            - no guarantee for ordering
            - distinct (keys) one value for one key, but the same value for different keys are ok
            - inserting/retrieving/removing elements via keys

            Implementations
            - HashMap not-ordered
            - LinkedHashMap ordered via keys
            - TreeMap sorted via keys using comparator
         */

        Map<String, Double> hashMap = new HashMap<>();
        hashMap.put("n1", 1.00);
        hashMap.put("n2", 4.12);
        hashMap.put("n3", 5.23);
        hashMap.put("n10", 54.03);
        hashMap.put("n23", 34.22);
        hashMap.put("n15", 12.00);
        System.out.println(hashMap);

        Map<String, Double> linkedMap = new LinkedHashMap<>(hashMap);
        linkedMap.put("n33", 6.78);
        linkedMap.put("n41", 5.43);
        linkedMap.put("n1", 5.213); // nadpisywanie wartosci klucza
        System.out.println(linkedMap);

        System.out.println(linkedMap.get("n2"));

        Map<String, Double> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1.compareTo(o2));
            }
        });
        treeMap.putAll(linkedMap);
        System.out.println("Tree Map: " + treeMap);

        System.out.println(treeMap.get("no key")); // incorrect key returns null
        System.out.println(treeMap.containsKey("n3"));
        System.out.println(treeMap.containsValue(2.00));

        if (treeMap.containsKey(5.23)) {
            for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
                System.out.println(entry);
            }
        }
    }
}
