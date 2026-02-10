import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.addAll(Arrays.asList(12, 5, 8, 19, 20, 3, 7, 14, 9, 6));

        System.out.println("Original List: " + list);

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            if (itr.next() % 2 == 0) {
                itr.remove();
            }
        }

        System.out.println("After removing even numbers: " + list);

        int max = Collections.max(list);
        int min = Collections.min(list);

        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);

    
        Collections.sort(list, Collections.reverseOrder());

    
        System.out.println("Final Sorted List (Descending): " + list);
    }
}
