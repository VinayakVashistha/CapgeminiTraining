class Node {
    String key;
    int value;
    Node next;

    Node(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap {
    private Node[] table;
    private int size;

    public MyHashMap(int capacity) {
        table = new Node[capacity];
        size = capacity;
    }

    // Simple hash function (replacement for hashCode())
    public int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = hash + key.charAt(i);
        }
        return hash % size;
    }

    // PUT method
    public void put(String key, int value) {
        int index = hash(key);

        Node head = table[index];

        // Check if key already exists → update value
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert new node at beginning (chaining)
        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    // GET method
    public Integer get(String key) {
        int index = hash(key);
        Node head = table[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null; // not found
    }

    // REMOVE method
    public void remove(String key) {
        int index = hash(key);
        Node head = table[index];
        Node prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    table[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    // DISPLAY method
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            Node head = table[i];
            while (head != null) {
                System.out.print("(" + head.key + ", " + head.value + ") -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        MyHashMap map = new MyHashMap(5);

        map.put("apple", 10);
        map.put("banana", 20);
        map.put("grapes", 30);
        map.put("mango", 40);
        map.put("apple", 50); // update

        map.display();

        System.out.println("Value of apple: " + map.get("apple"));
        System.out.println("Value of banana: " + map.get("banana"));

        map.remove("banana");

        System.out.println("\nAfter removing banana:");
        map.display();
    }
}
