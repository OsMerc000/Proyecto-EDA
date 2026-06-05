import KDTree.KDTree;
import KDTree.Punto;

public class App {
    public static void main(String[] args) throws Exception {
        KDTree tree = new KDTree();
        System.out.println(tree);
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
        tree.push(A);
        tree.push(B);
        tree.push(C);
        tree.push(D);
        tree.push(E);
        tree.push(F);
        tree.push(G);
        tree.push(H);
        tree.push(I);
        tree.push(J);
        tree.push(K);
        tree.push(L);
        tree.push(M);
        Punto p = new Punto(0, 0);
        Punto closestToP = tree.getNearestPoint(p);
        System.out.println("Closest point to the origin: " + closestToP);
        System.out.println(tree);
    }
}
