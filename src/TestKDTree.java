import KDTree.KDTree;
import KDTree.Punto;

public class TestKDTree {
    public TestKDTree() {
        KDTree tree = new KDTree();
        System.out.println("Tree:\n" + tree);
        Punto[] puntos = {
            Punto.punto2D(4, 1),
            Punto.punto2D(-1, 1),
            Punto.punto2D(1, 6),
            Punto.punto2D(7, -3),
            Punto.punto2D(5.46, 3.76),
            Punto.punto2D(1.82, 1.36),
            Punto.punto2D(2.48, -1.97),
            Punto.punto2D(6.92, 0.56),
            Punto.punto2D(8.81, 3.28),
            Punto.punto2D(9.43, -1.7),
            Punto.punto2D(2.77, -0.64),
            Punto.punto2D(0, -1),
            Punto.punto2D(2.87, 4.1),
        };
        Punto p = Punto.punto2D(0, 0);
        Punto closestToP = tree.getNearestPoint(p);
        System.out.println("Closest point to the origin: " + closestToP);
        System.out.println(tree);
    }
}