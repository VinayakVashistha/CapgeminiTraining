import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Search
    boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // Inorder
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class BST {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        int[] elements = {50, 30, 70, 20, 40, 60, 80};

        for (int el : elements) {
            bst.root = bst.insert(bst.root, el);
        }

        System.out.println("Inorder Traversal:");
        bst.inorder(bst.root);

        System.out.println("\nPreorder Traversal:");
        bst.preorder(bst.root);

        System.out.println("\nPostorder Traversal:");
        bst.postorder(bst.root);

        System.out.println("\nSearch 40: " + bst.search(bst.root, 40));
        System.out.println("Search 100: " + bst.search(bst.root, 100));

        // -------- Min Heap using PriorityQueue --------
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Random rand = new Random();

        System.out.println("\nRandom numbers inserted into Min Heap:");

        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100);
            minHeap.add(num);
            System.out.print(num + " ");
        }

        System.out.println("\nSorted order (Min Heap output):");

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}