package SegmentTree;

public class SegmentTree {
    private Nodo<Integer> head;
    private final int len;

    public SegmentTree(int arr[]) {
        this.head = build(arr, 0, arr.length - 1);
        this.len = arr.length;
    }

    private Nodo<Integer> build(int arr[], int left, int right) {
        if (left == right) {
            return new Nodo<Integer>(arr[left]);
        } else {
            int middle = (right - left)/2;
            Nodo<Integer> leftNode = build(arr, left, middle);
            Nodo<Integer> rightNode = build(arr, middle + 1, right);
            Integer value = leftNode.getValue() + rightNode.getValue();
            Nodo<Integer> newNode = new Nodo<Integer>(value);
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
}
