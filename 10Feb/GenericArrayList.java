public class GenericArraylist{

    public static void main(String[] args) {

        MyArrayList2<Integer> list = new MyArrayList2<>();

        list.add(1);
        list.add(20);
        list.add(50);
        list.add(60);
        list.add(90);
        list.add(100);

        list.print();

        list.add(1);
        list.add(20);
        list.add(50);
        list.add(60);
        list.add(0);
        list.add(100);

        list.add(1);
        list.add(20);
        list.add(50);
        list.add(60);
        list.add(90);
        list.add(100);

        list.print();

        System.out.println(list.search(50));

        list.sort();
        list.print();
    }
}

class MyArrayList2<T extends Comparable<T>> {

    private T[] data;
    private int size;

    MyArrayList2() {
        data = (T[]) new Comparable[4];
    }

    public void add(T el) {
        if (size == data.length)
            resize();

        data[size++] = el;
    }

    private void resize() {
        T[] newData = (T[]) new Comparable[data.length * 2];

        for (int i = 0; i < size; i++)
            newData[i] = data[i];

        data = newData;
    }

    void print() {
        for (int i = 0; i < size; i++)
            System.out.print(data[i] + " ");

        System.out.println();
    }

    int search(T el) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(el))
                return i;

        return -1;
    }

    void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (data[i].compareTo(data[j]) > 0) {
                    T temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
}