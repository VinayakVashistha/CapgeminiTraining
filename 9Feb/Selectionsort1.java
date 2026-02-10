package capgemini;

public class Selectionsort1 {
    public static void main(String[] args) {

        int[] arr1 = {5, 3, 4, 1, 2};
        int n1 = arr1.length;

        for (int i = 0; i < n1 - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n1; j++) {
                if (arr1[j] < arr1[minIndex]) {
                    minIndex = j;
                }
            }

            // swap minimum with current position
            int temp = arr1[i];
            arr1[i] = arr1[minIndex];
            arr1[minIndex] = temp;
