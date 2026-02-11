import java.util.Stack;

public class Task3 {

    public static void reverse(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        // Push elements
        for (int num : arr) {
            stack.push(num);
        }

        // Pop back into array
        int i = 0;
        while (!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        reverse(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
