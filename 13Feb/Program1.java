package LearnComparator;
import java.util.*;
class Student{
	int marks;
	String name;
	int age;
	public Student(int marks, String name, int age) {
		super();
		this.marks = marks;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [marks=" + marks + ", name=" + name + ", age=" + age + "]";
	}
}

class marksSort implements Comparator<Student>{
	public int compare(Student s1, Student s2) {
		return s1.marks-s2.marks;
	}
}

public class Program1 {
	public static void main(String[] args) {
		List<Student> arr = new ArrayList<>();
		arr.add(new Student(85, "Alice", 20));
		arr.add(new Student(92, "Bob", 22));
		arr.add(new Student(78, "Charlie", 21));
		arr.add(new Student(95, "Diana", 19));
		arr.add(new Student(88, "Ethan", 23));
		arr.add(new Student(73, "Fiona", 20));
		arr.add(new Student(90, "George", 22));
		arr.add(new Student(81, "Hannah", 21));
		
	
		Collections.sort(arr,new marksSort());
		System.out.println("Sort by marks");
		for(Student s : arr) {
			System.out.println(s.toString());
		}
	}
}