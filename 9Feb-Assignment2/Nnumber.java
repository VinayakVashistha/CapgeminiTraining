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

public class SortObjectsNMarks {
    public static void main(String[] args) {

        StudentZ[] arr = {
            new StudentZ(new int[]{80, 70, 60}, "A"),
            new StudentZ(new int[]{80, 70, 50}, "B"),
            new StudentZ(new int[]{80, 60, 90}, "C"),
            new StudentZ(new int[]{75, 90, 95}, "DD"),
            new StudentZ(new int[]{80, 70, 60}, "E")
        };

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {

                boolean swap = false;

                for (int k = 0; k < arr[j].marks.length; k++) {
                    if (arr[j].marks[k] > arr[j + 1].marks[k]) {
                        swap = true;
                        break;
                    }
                    if (arr[j].marks[k] < arr[j + 1].marks[k]) {
                        break;
                    }
                }

                if (swap) {
                    StudentZ temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}