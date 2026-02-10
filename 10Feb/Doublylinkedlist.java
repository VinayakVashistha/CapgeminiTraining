package capg;

public class Doublylinkedlist{

    static class Node {
        int d;
        Node p, n;

        Node(int d) {
            this.d = d;
        }
    }

    static Node h, t;
    static int sz;

    static void addEnd(int x) {
        Node nn = new Node(x);
        if (h == null) {
            h = t = nn;
        } else {
            t.n = nn;
            nn.p = t;
            t = nn;
        }
        sz++;
    }

    static void addBeg(int x) {
        Node nn = new Node(x);
        if (h == null) {
            h = t = nn;
        } else {
            nn.n = h;
            h.p = nn;
            h = nn;
        }
        sz++;
    }

    static void remove(int idx) {
        if (idx < 0 || idx >= sz)
            return;

        if (idx == 0) {
            h = h.n;
            if (h != null)
                h.p = null;
            else
                t = null;
        } else {
            Node c = h;
            for (int i = 0; i < idx; i++)
                c = c.n;

            if (c.n != null)
                c.n.p = c.p;
            else
                t = c.p;

            c.p.n = c.n;
        }
        sz--;
    }

    static int search(int x) {
        Node c = h;
        int i = 0;
        while (c != null) {
            if (c.d == x)
                return i;
            c = c.n;
            i++;
        }
        return -1;
    }

    static void fwd() {
        Node c = h;
        while (c != null) {
            System.out.print(c.d + " ");
            c = c.n;
        }
        System.out.println();
    }

    static void bwd() {
        Node c = t;
        while (c != null) {
            System.out.print(c.d + " ");
            c = c.p;
        }
        System.out.println();
    }

    static int size() {
        return sz;
    }

    public static void main(String[] args) {

        addEnd(10);
        addEnd(20);
        addEnd(30);

        addBeg(5);
        addBeg(1);

        fwd();
        bwd();

        remove(2);
        fwd();

        System.out.println(search(20));
        System.out.println(size());
    }
}