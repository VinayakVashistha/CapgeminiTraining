interface Comparator<T> {
    int compare(T a, T b);
}

class UniComparator<T> implements Comparator<T> {

    public int compare(T a, T b) {

        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;

        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a - (Integer) b;
        }

        if (a instanceof String && b instanceof String) {
            return ((String) a).compareTo((String) b);
        }

        throw new RuntimeException("Unsupported type");
    }
}

public class StringComparator {

    public static void main(String[] args) {

        Comparator<Integer> intCmp = new UniComparator<>();
        System.out.println(intCmp.compare(10, 20));

        Comparator<String> strCmp = new UniComparator<>();
        System.out.println(strCmp.compare("ABC", "BCD"));
    }
}