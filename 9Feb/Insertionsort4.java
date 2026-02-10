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

public class Insertionsort4 {
    public static void main(String[] args) {

        StudentZ[] arr = {
            new StudentZ(new int[]{80, 70, 60}, "A"),
            new StudentZ(new int[]{80, 70, 50}, "B"),
            new StudentZ(new int[]{80, 60, 90}, "C"),
            new StudentZ(new int[]{75, 90, 95}, "DD"),
            new StudentZ(new int[]{80, 70, 60}, "E")
        };

        for (int i = 1; i < arr.length; i++) {

            StudentZ key = arr[i];
            int j = i - 1;

            while (j >= 0) {

                boolean move = false;

                for (int k = 0; k < key.marks.length; k++) {

                    if (arr[j].marks[k] > key.marks[k]) {
                        move = true;
                        break;
                    }

                    if (arr[j].marks[k] < key.marks[k]) {
                        break;
                    }
                }

                if (!move)
                    break;

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        for (StudentZ s : arr)
            System.out.println(s);
    }
}
