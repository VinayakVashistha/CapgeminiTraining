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

public class BubbleSortObjects {
    public static void main(String[] args) {
        Empoy[] arr = {
            new Empoy(201, "Aman", 45000),
            new Empoy(202, "Riya", 38000),
            new Empoy(203, "Karan", 60000),
            new Empoy(204, "Neha", 38000)
        };
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j].salary > arr[j + 1].salary) {
                    Empoy temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (Empoy e : arr) {
            System.out.println( e.empId + " " + e.name + " " + e.salary);
        }
    }
}


