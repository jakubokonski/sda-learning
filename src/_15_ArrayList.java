import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class _15_ArrayList {
    public static void main(String[] args) {

        int[] arr = new int[10];

        // Array list - collection, array with modified length

        List<Integer> integers = new ArrayList<>(); // default capacity 10, adds by 10s

        // array list - pass own capacity
        List<Integer> ints = new ArrayList<>(50); // capacity

        // add 100 elements
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int element = random.nextInt(100);
            integers.add(element);
            ints.add(element);
        }
        System.out.println("integers: " + integers);
        System.out.println("ints: " + ints);

        // get elements from list
        int a = integers.get(10);
        System.out.println("Element at index 10: " + a);

        int last = integers.get(integers.size() - 1);
        System.out.println("last element: " + last);

        // methods
        // contains element
        boolean containsElement = integers.contains(23);
        System.out.println("array list contains: " + containsElement);

        // is empty
        System.out.println("is empty? " + integers.isEmpty());

        // how to remove element
        // remove object
        boolean removedEl1 = integers.remove(new Integer(69));
        System.out.println("removed el by object " + removedEl1);
        // remove by index
        Integer removeObject = integers.remove(98);
        System.out.println("removed object: " + removeObject);

        System.out.println("integers: " + integers);

        // check size
        System.out.println("size is: " + integers.size()); // method, array.length - property

        // add element in specified index
        integers.add(0, 101);
        System.out.println("integers is: " + integers);

        // replace element
        integers.set(0, 200);
        System.out.println("replaced: " + integers);

        // retain only 10 and 20, remove other
        boolean result = integers.retainAll(Arrays.asList(10, 20));
        // integers.retainAll(Arrays.asList(10, 20)); - short ver
        System.out.println("retained: " + integers);
        System.out.println(result);

        // clear
        integers.clear();
        System.out.println("list is " + integers + " " + integers.size());


    }
}
