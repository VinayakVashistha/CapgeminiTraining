package capgemini;

class StudentZ {
    int[] marks;
    String name;

    StudentZ(int[] m, String n) {
        marks = m;
        name = n;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < marks.length; i++)
            s += marks[i] + " ";
        return s + name;
    }
}

public class Selectionsort4 {
    public static void main(String[] args) {

        StudentZ[] arr = {
            new StudentZ(new int[]{80, 70, 60}, "A"),
            new StudentZ(new int[]{80, 70, 50}, "B"),
            new StudentZ(new int[]{80, 60, 90}, "C"),
            new StudentZ(new int[]{75, 90, 95}, "DD"),
            new StudentZ(new int[]{80, 70, 60}, "E")
        };

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                for (int k = 0; k < arr[j].marks.length; k++) {

                    if (arr[j].marks[k] < arr[minIndex].marks[k]) {
                        minIndex = j;
                        break;
                    }

                    if (arr[j].marks[k] > arr[minIndex].marks[k]) {
                        break;
                    }
                }
            }

            if (minIndex != i) {
                StudentZ temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        for (StudentZ s : arr)
            System.out.println(s);
    }
}
