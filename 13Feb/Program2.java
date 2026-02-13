package LearnComparator;
import java.util.*;

public class Program2 {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple",null,"by", "hi", "banana", "cat");

        Comparator<String> comp =Comparator.nullsFirst(
                Comparator.comparing(String::length).reversed()
                          .thenComparing(Comparator.naturalOrder()));
        
        Collections.sort(words, comp);

        for(String s : words) {
            System.out.println(s);
        }
    }
}