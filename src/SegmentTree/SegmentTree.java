package SegmentTree;

public class SegmentTree<T> {
    private Nodo<T> head;
    private int len;
    private Associative<T> methodInT;

    public SegmentTree() {
        this.head = null;
        this.len = 0;
        this.methodInT = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public SegmentTree(T arr[], Associative<T> methodInT) {
        this.methodInT = methodInT;
        this.head = build(arr, 0, arr.length - 1);
        this.len = arr.length;
    }

    public void update(T arr[], Associative<T> methodInT) {
        this.methodInT = methodInT;
        this.head = build(arr, 0, arr.length - 1);
        this.len = arr.length;
    }

    public interface Associative<T> {
        T method(T u, T v);
    }

    private Nodo<T> build(T arr[], int left, int right) {
        if (left == right) {
            return new Nodo<T>(arr[left]);
        } else {
            int middle = (left + right)/2;
            Nodo<T> leftNode = build(arr, left, middle);
            Nodo<T> rightNode = build(arr, middle + 1, right);
            T value = methodInT.method(leftNode.getValue(), rightNode.getValue());
            Nodo<T> newNode = new Nodo<T>(value);
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

    public T query(int left, int right) {
        if (left > right || right >= len || left < 0) {
            new RuntimeException("Invalid indexes.");
        }
        return query(head, left, right, 0, len - 1);
    }

    private T query(Nodo<T> currentNode,int queryLeft, int queryRight, int currentLeft, int currentRight) {
        if (queryLeft == currentLeft && queryRight == currentRight) {
            return currentNode.getValue();
        } else {
            int middle = (currentLeft + currentRight)/2;
            if (queryRight <= middle) {
                return query(currentNode.getLeft(), queryLeft, queryRight, currentLeft, middle);
            } else if (queryLeft > middle) {
                return query(currentNode.getRight(), queryLeft, queryRight, middle + 1, currentRight);
            } else {
                T left = query(currentNode.getLeft(), queryLeft, middle, currentLeft, middle);
                T right = query(currentNode.getRight(), middle + 1, queryRight, middle + 1, currentRight);
                return methodInT.method(left, right);
            }
        }
    }

    public void update(T value, int index) {
        if (index < 0 || index >= len) {
            new RuntimeException("Invalid index.");
        }
        update(value, index, 0, len - 1, head);
    }

    private T update(T value, int index, int left, int right, Nodo<T> nodo) {
        if (left == right) {
            nodo.setValue(value);
            return value;
        } else {
            int middle = (left + right) / 2;
            T leftValue;
            T rigthtValue;
            if (index <= middle) {
                leftValue = update(value, index, left, middle, nodo.getLeft());
                rigthtValue = nodo.getRight().getValue();
            } else {
                leftValue = nodo.getLeft().getValue();
                rigthtValue = update(value, index, middle + 1, right, nodo.getRight());
            }
            T branchValue = methodInT.method(leftValue, rigthtValue);
            nodo.setValue(branchValue);
            return branchValue;
        }
    }
}
