import java.util.PriorityQueue;
import java.util.Random;

public class MinHeapExample {

    public static void main(String[] args) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Random rand = new Random();

        System.out.println("Inserted Elements:");

        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100);
            minHeap.add(num);
            System.out.print(num + " ");
        }

        System.out.println("\nSorted Order:");

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}
