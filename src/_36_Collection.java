import java.util.*;

public class _36_Collection {
    public static void main(String[] args) {

        Collection<String> coll = null; // Collection, generic type

//        Collections.emptyList(); // collections class with a lot of usefull methods

        /*
        Lists are:
        - ordered
        - not-distinct, elements can be duplicated
        - not-sorted be default
        - add/remove/update/get works on the beginning, in the middle, in the end.

        Implementations:
        - ArrayList
            * fast random access
            * very good when we know what is the size of a list
            * very good when update element at random index
            * not good when adding element at the beginning or in the middle
        - LinkedList
            * sequential access (slow if you want random access)
            * very good to add element at the beginning or at the end
            * very good to add/remove elements via iterator
            * not good to update element at random index
            * takes more memory

         If you don't know what to use start with ArrayList, switch to LinkedList later if required.
         */

        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        // convert array into linked:
        List<String> converted = new LinkedList<>(arrayList);

        /*
        Sets are: (zbiory)
        - order is not guaranteed
        - distinct (no duplicates)
        - can be sorted
        - no random access
        - can have null (only one) but it may crash app some times (compare bigger/smaller value)

        Implementations:
        - HashSet (not-ordered)
        - LinkedHashSet (ordered)
        - TreeSet (sorted)
        */

        List<String> letters = Arrays.asList("a", "A", "b", "C", "d", "d", "e", "f", "i", "j");

        Set<String> hashSet = new HashSet<>(letters);
        hashSet.add("g102");
        System.out.println(hashSet);

        Set<String> linkedSet = new LinkedHashSet<>(letters);
        linkedSet.add("g102");
        linkedSet.add("fff");
        System.out.println(linkedSet);

        Set<String> treeSet = new TreeSet<>(letters);
        treeSet.add("g");
        System.out.println(treeSet);
        treeSet.add("z");
        treeSet.add("p");
        treeSet.add("m");
        System.out.println(treeSet);

        Set<String> reversedTree = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) { // comparator - equals return 0, greater 1, lower -1.
                return -(o1.compareTo(o2)); // add "-" to reverse order
            }
        });
        reversedTree.addAll(letters); // add all elements from other collection
        System.out.println("reversed tree:" + reversedTree);

        /*
        Queues:
        - can be FIFO / LIFO
        - order is not guaranteed
        - sort is not guaranteed
        - not-distinct, can have duplicates
        - you can push, pop, shift, un-shift

        Implementations
        - LinkedList (Deque, kolejka dwukierunkowa)
        - PriorityQueue (using Comparator to prioritize elements)
        - ArrayDeque - preferred over LinkedList when using as queue (faster)
         */

        System.out.println("-----------QUEUE-----------");
        Queue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1.compareTo(o2));
            }
        });
        priorityQueue.offer("a");
        priorityQueue.offer("b");
        priorityQueue.offer("c");
        priorityQueue.offer("d");
        System.out.println(priorityQueue.poll()); // ściągnięcie elementów kolejki, usuwa
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek()); // pokaza ale nie usuwaj
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll()); // koniec kolejki, null

        System.out.println("-------------DEQUE------------");
        Deque<String> deque = new ArrayDeque<>(letters);
        System.out.println(deque);
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque);
    }
}
