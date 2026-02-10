import java.util.LinkedList;

public class Task2 {
    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();


        queue.add("Patient A");
        queue.add("Patient B");
        queue.add("Patient C");
        queue.add("Patient D");
        queue.add("Patient E");


        queue.addFirst("Emergency Patient");

        System.out.println("Queue after emergency entry: " + queue);


        queue.removeFirst();
        queue.removeFirst();

    
        System.out.println("Current Queue: " + queue);
    }
}
