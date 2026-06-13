import SegmentTree.SegmentTree;
import KDTree.Punto;

public class TestSegmentTree {
    public TestSegmentTree() {
        Punto A = new Punto(4, 1);
        Punto B = new Punto(-1, 1);
        Punto C = new Punto(1, 6);
        Punto D = new Punto(7, -3);
        Punto E = new Punto(5.46, 3.76);
        Punto F = new Punto(1.82, 1.36);
        Punto G = new Punto(2.48, -1.97);
        Punto H = new Punto(6.92, 0.56);
        Punto I = new Punto(8.81, 3.28);
        Punto J = new Punto(9.43, -1.7);
        Punto K = new Punto(2.77, -0.64);
        Punto L = new Punto(0, -1);
        Punto M = new Punto(2.87, 4.1);
        Punto[] arr = {A, B, C, D, E, F, G, H, I, J, K, L, M};
        Punto p = new Punto(0, 0);
        SegmentTree tree = new SegmentTree(arr, p);
        System.out.println("Tree:\n" + tree);
        System.out.println("arr[0] + ... + arr[13] = " + tree.query(0, 12));
        System.out.println("arr[0] + ... + arr[2] = " + tree.query(0, 2));
        System.out.println("arr[5] + ... + arr[7] = " + tree.query(5, 7));
        System.out.println("arr[2] + ... + arr[6] = " + tree.query(2, 6));
    }
}
