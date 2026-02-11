[11:27 AM, 2/11/2026] Himanshu Singh: package capg;


interface KeyExtractor<T, K extends java.lang.Comparable<K>> {
    K extract(T obj);
}

class GenericBubbleSort {

    public static <T, K extends java.lang.Comparable<K>>
    void sort(T[] arr, KeyExtractor<T, K> extractor) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                K key1 = extractor.extract(arr[j]);
                K key2 = extractor.extract(arr[j + 1]);

                if (key1.compareTo(key2) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

class Student_x {
    int id;
    String name;
    int age;

    Student_x(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return id + " " + name + " " + age;
    }
}

public class GenericSortFinal{

    public static void main(String[] args) {

        Student_x[] students = {
            new Student_x(3, "ABC", 23),
            new Student_x(1, "XYZ", 20),
            new Student_x(2, "LMN", 22)
        };

        GenericBubbleSort.sort(students, s -> s.id);

        System.out.println("Sorted by ID:");
        for (Student_x s : students)
            System.out.println(s);

        GenericBubbleSort.sort(students, s -> s.name);

        System.out.println("\nSorted by Name:");
        for (Student_x s : students)
            System.out.println(s);

        GenericBubbleSort.sort(students, s -> s.age);

        System.out.println("\nSorted by Age:");
        for (Student_x s : students)
            System.out.println(s);
    }
}