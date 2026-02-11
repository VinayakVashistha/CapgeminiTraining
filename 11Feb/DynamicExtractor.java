
class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

// Functional Interface
interface Function<T, K> {
    K call(T obj);
}

// Generic Dynamic Extractor Class
class DynamicExtractor<T, K> {

    private Function<T, K> function;

    DynamicExtractor(Function<T, K> function) {
        this.function = function;
    }

    K extract(T obj) {
        return function.call(obj);
    }
}

public class Main {
    public static void main(String[] args) {

        Student s = new Student(1, "ABC", 23);

        // Extract name
        DynamicExtractor<Student, String> nameEx =
                new DynamicExtractor<>(student -> student.name);

        System.out.println(nameEx.extract(s));
    }
}
