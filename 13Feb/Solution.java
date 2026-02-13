import java.io.*;
import java.util.*;
class Student{
    String name;
    int marks;
    public Student(String name,int marks){
        this.name=name;
        this.marks=marks;
    }
    public String toString(){
        return name+" "+marks;
    }
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        
        int n=Integer.parseInt(sc.nextLine());
        
        
        Student[] arr=new Student[n];
        for(int i=0;i<n;i++){
            String in[]=sc.nextLine().split(" ");
            String name = in[0];
            int marks = Integer.parseInt(in[1]);
            arr[i]=new Student(name, marks);
        }
        
        
        Comparator<Student> comp = Comparator.nullsFirst(
            Comparator.comparing((Student s)->s.marks).reversed()
            .thenComparing((Student s)->s.name)
        );
        Arrays.sort(arr,comp);
        for(Student s:arr){
            System.out.println(s.toString());
        }
        
    }
}
