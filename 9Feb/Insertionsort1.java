package capgemini;

public class Insertionsort1 {
    public static void main(String[] args) {

        int[] arr1 = {5, 3, 4, 1, 2};
        int n1 = arr1.length;

        for (int i = 1; i < n1; i++) {

            int key = arr1[i];
            int j = i - 1;

            while (j >= 0 && arr1[j] > key) {
                arr1[j + 1] = arr1[j];
                j--;
            }

            arr1[j + 1] = key;
        }

        for (int x : arr1) {
            System.out.print(x + " ");
        }
    }
}
