package capgemini;

public class Bubblesort {
    public static void main(String[] args) {

        int[] arr1 = {5, 3, 4, 1, 2};
        int n1 = arr1.length;

        for (int i = 0; i < n1 - 1; i++) {          
            for (int j = 0; j < n1 - i - 1; j++) {  
                if (arr1[j] > arr1[j + 1]) {
                    // swap
                    int temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                }
            }
        }

        for (int x : arr1) {
            System.out.print(x + " ");
        }
    }
}

