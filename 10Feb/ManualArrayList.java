public class MannualArrayList {
	private int[] data;
    private int size;

    public MannualArrayList() {
        data = new int[4];
        size = 0;
    }

    public void add(int value) {
        if (size == data.length) {
            resize();
        }
        data[size++] = value;
    }

    private void resize() {
        int[] newData = new int[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }
public static void main(String[] args) {
        MannualArrayList list = new MannualArrayList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        list.print();
    }
}