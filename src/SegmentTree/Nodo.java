package SegmentTree;

public class Nodo<T> {
    private T value;
    private Nodo<T> left;
    private Nodo<T> right;

    public Nodo(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public Nodo(T value, Nodo<T> left, Nodo<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }
    public Nodo<T> getLeft() {
        return left;
    }
    public Nodo<T> getRight() {
        return right;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public void setLeft(Nodo<T> left) {
        this.left = left;
    }
    public void setRight(Nodo<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        String s = "(Value: " + value;
        s += ", Left: ";
        if (left != null) {s += left.toString();} else {s += "None";}
        s += ", Right: ";
        if (right != null) {s += right.toString();} else {s += "None";}
        s += ")";
        return s;
    }
}