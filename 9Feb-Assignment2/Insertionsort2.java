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

public class Insertionsort2 {
    public static void main(String[] args) {

        Empoy[] arr = {
            new Empoy(201, "Aman", 45000),
            new Empoy(202, "Riya", 38000),
            new Empoy(203, "Karan", 60000),
            new Empoy(204, "Neha", 38000)
        };

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            Empoy key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].salary > key.salary) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        for (Empoy e : arr) {
            System.out.println(e.empId + " " + e.name + " " + e.salary);
        }
    }
}
