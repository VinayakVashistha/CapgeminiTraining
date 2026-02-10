public class SinglyLinkedListDemo {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class SinglyLinkedList {
        Node head;

        void insertAtPosition(int data, int position) {
            Node newNode = new Node(data);

            if (position == 1) {
                newNode.next = head;
                head = newNode;
                return;
            }

            Node temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Position out of range");
                return;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }

        // Delete by value
        void deleteByValue(int value) {
            if (head == null) return;

            if (head.data == value) {
                head = head.next;
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.data != value) {
                temp = temp.next;
            }

            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }

        // Count total nodes
        int countNodes() {
            int count = 0;
            Node temp = head;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }

        // Find middle element using slow & fast pointer
        int findMiddle() {
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow.data;
        }

        // Reverse the linked list
        void reverse() {
            Node prev = null;
            Node current = head;
            Node next;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            head = prev;
        }

        // Display the list
        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        // Insert elements
        list.insertAtPosition(10, 1);
        list.insertAtPosition(20, 2);
        list.insertAtPosition(30, 3);
        list.insertAtPosition(40, 4);

        System.out.print("Initial List: ");
        list.display();

        // Insert at specific position
        list.insertAtPosition(25, 3);
        System.out.print("After inserting 25 at position 3: ");
        list.display();

        // Delete by value
        list.deleteByValue(20);
        System.out.print("After deleting 20: ");
        list.display();

        // Count nodes
        System.out.println("Total Nodes: " + list.countNodes());

        // Find middle element
        System.out.println("Middle Element: " + list.findMiddle());

        // Reverse list
        list.reverse();
        System.out.print("Reversed List: ");
        list.display();
    }
}
