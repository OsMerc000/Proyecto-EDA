package KDTree;

public class Nodo {
    private Punto punto;
    private Nodo left;
    private Nodo right;

    public Nodo(Punto punto) {
        this.punto = punto;
        this.left = null;
        this.right = null;
    }

    public Punto getPunto() {
        return punto;
    }
    public Nodo getLeft() {
        return left;
    }
    public Nodo getRight() {
        return right;
    }

    public void setPunto(Punto value) {
        this.punto = value;
    }
    public void setLeft(Nodo left) {
        this.left = left;
    }
    public void setRight(Nodo right) {
        this.right = right;
    }

    @Override
    public String toString() {
        String s = "(Punto: " + this.punto;
        s += ", Left: ";
        if (this.left != null) {s += this.left.toString();} else {s += "None";}
        s += ", Right: ";
        if (this.right != null) {s += this.right.toString();} else {s += "None";}
        s += ")";
        return s;
    }
}