package capgemini;

class Empoy {
    int empId;
    String name;
    int salary;

    Empoy(int empId, String name, int salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
}

public class Selectionsort2 {
    public static void main(String[] args) {

        Empoy[] arr = {
            new Empoy(201, "Aman", 45000),
            new Empoy(202, "Riya", 38000),
            new Empoy(203, "Karan", 60000),
            new Empoy(204, "Neha", 38000)
        };

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j].salary < arr[minIndex].salary) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Empoy temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        for (Empoy e : arr) {
            System.out.println(e.empId + " " + e.name + " " + e.salary);
        }
    }
}
