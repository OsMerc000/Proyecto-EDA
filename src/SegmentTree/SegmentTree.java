package SegmentTree;

import KDTree.Punto;

public class SegmentTree {
    private Nodo<Punto> head;
    private int len;
    private Punto punto;

    public SegmentTree() {
        this.head = null;
        this.len = 0;
        this.punto = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public SegmentTree(Punto arr[], Punto punto) {
        this.head = build(arr, punto, 0, arr.length - 1);
        this.len = arr.length;
        this.punto = punto;
    }

    public void build(Punto arr[], Punto punto) {
        this.head = build(arr, punto, 0, arr.length - 1);
        this.len = arr.length;
    }

    private Nodo<Punto> build(Punto arr[], Punto punto, int left, int right) {
        if (left == right) {
            return new Nodo<Punto>(arr[left]);
        } else {
            int middle = (left + right)/2;
            Nodo<Punto> leftNode = build(arr, punto, left, middle);
            Nodo<Punto> rightNode = build(arr, punto, middle + 1, right);
            Punto puntoMasCercano;
            if (leftNode.getValue().getDistance(punto) < rightNode.getValue().getDistance(punto)) {
                puntoMasCercano = leftNode.getValue();
            } else {
                puntoMasCercano = rightNode.getValue();
            }
            Nodo<Punto> newNode = new Nodo<Punto>(puntoMasCercano);
            newNode.setLeft(leftNode);
            newNode.setRight(rightNode);
            return newNode;
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "None";
        } else {
            return head.toString();
        }
    }

    public Punto query(int left, int right) {
        if (left > right || right >= len || left < 0) {
            new RuntimeException("Invalid indexes.");
        }
        return query(head, left, right, 0, len - 1);
    }

    private Punto query(Nodo<Punto> currentNode,int queryLeft, int queryRight, int currentLeft, int currentRight) {
        if (queryLeft == currentLeft && queryRight == currentRight) {
            return currentNode.getValue();
        } else {
            int middle = (currentLeft + currentRight)/2;
            if (queryRight <= middle) {
                return query(currentNode.getLeft(), queryLeft, queryRight, currentLeft, middle);
            } else if (queryLeft > middle) {
                return query(currentNode.getRight(), queryLeft, queryRight, middle + 1, currentRight);
            } else {
                Punto left = query(currentNode.getLeft(), queryLeft, middle, currentLeft, middle);
                Punto right = query(currentNode.getRight(), middle + 1, queryRight, middle + 1, currentRight);
                if (left.getDistance(punto) < right.getDistance(punto)) {
                    return left;
                } else {
                    return right;
                }
            }
        }
    }
}