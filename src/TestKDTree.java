import java.util.Random;

import KDTree.KDTree;
import KDTree.Punto;

public class TestKDTree {
    private Punto[] generarPuntos(int n, double bound) {
        if (n < 0) {
            new RuntimeException("Ingresado una cantidad no válida.");
        }
        Punto[] arr = new Punto[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            double x = rd.nextDouble(bound);
            double y = rd.nextDouble(bound);
            Punto punto = new Punto(x, y);
            arr[i] = punto;
        }
        return arr;
    }

    private void mostrarPuntos(Punto[] puntos) {
        for (int i = 0; i < puntos.length; i++) {
            System.out.println("Punto[" + i + "]: " + puntos[i]);
        }
    }
    
    public TestKDTree() {
        Punto[] puntos = generarPuntos(15, 5);
        mostrarPuntos(puntos);
        KDTree tree = new KDTree();
        for (int i = 0; i < puntos.length; i++) {
            tree.push(puntos[i]);
        }
        // System.out.println("Tree:\n" + tree);
        // Punto A = new Punto(4, 1);
        // Punto B = new Punto(-1, 1);
        // Punto C = new Punto(1, 6);
        // Punto D = new Punto(7, -3);
        // Punto E = new Punto(5.46, 3.76);
        // Punto F = new Punto(1.82, 1.36);
        // Punto G = new Punto(2.48, -1.97);
        // Punto H = new Punto(6.92, 0.56);
        // Punto I = new Punto(8.81, 3.28);
        // Punto J = new Punto(9.43, -1.7);
        // Punto K = new Punto(2.77, -0.64);
        // Punto L = new Punto(0, -1);
        // Punto M = new Punto(2.87, 4.1);
        // tree.push(A);
        // tree.push(B);
        // tree.push(C);
        // tree.push(D);
        // tree.push(E);
        // tree.push(F);
        // tree.push(G);
        // tree.push(H);
        // tree.push(I);
        // tree.push(J);
        // tree.push(K);
        // tree.push(L);
        // tree.push(M);
        Punto p = new Punto(0, 0);
        Punto closestToP = tree.getNearestPoint(p);
        System.out.println("Closest point to the origin: " + closestToP);
        // System.out.println(tree);
    }
}