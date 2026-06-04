public class App {
    public static void main(String[] args) throws Exception {
        KDTree tree = new KDTree();
        System.out.println(tree);
        Punto p1 = new Punto(4, 1);
        Punto p2 = new Punto(-1, 1);
        Punto p3 = new Punto(1, 6);
        Punto p4 = new Punto(7, -3);
        tree.push(p1);
        tree.push(p2);
        tree.push(p3);
        tree.push(p4);
        Punto p5 = new Punto(0, 0);
        Punto closestToP5 = tree.searchNearestPoint(p5);
        System.out.println("Closest point to the origin: " + closestToP5);
        System.out.println(tree);
    }
}
