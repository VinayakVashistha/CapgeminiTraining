package capg;
public class Task3 {

    static class N {
        int d;
        N n;

        N(int d) {
            this.d = d;
            this.n = null;
        }
    }

    static N h;

    static void addBeg(int x) {
        N t = new N(x);
        t.n = h;
        h = t;
    }

    static void addEnd(int x) {
        N t = new N(x);
        if (h == null) {
            h = t;
            return;
        }
        N c = h;
        while (c.n != null)
            c = c.n;
        c.n = t;
    }

    static void trav() {
        N c = h;
        while (c != null) {
            System.out.print(c.d + " ");
            c = c.n;
        }
        System.out.println();
    }

    static int search(int x) {
        N c = h;
        int i = 0;
        while (c != null) {
            if (c.d == x)
                return i;
            c = c.n;
            i++;
        }
        return -1;
    }

    static void rev() {
        N p = null, c = h, nx;
        while (c != null) {
            nx = c.n;
            c.n = p;
            p = c;
            c = nx;
        }
        h = p;
    }

    public static void main(String[] args) {

        addBeg(10);
        addBeg(20);
        addEnd(30);
        addEnd(40);

        trav();

        System.out.println(search(30));

        rev();
        trav();
    }
}