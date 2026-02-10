package capg;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>();

        a.add(78);
        a.add(85);
        a.add(92);
        a.add(66);
        a.add(74);

        a.add(2, 88);

        int min = Collections.min(a);
        a.remove(Integer.valueOf(min));

        for (int x : a)
            System.out.print(x + " ");
    }
}