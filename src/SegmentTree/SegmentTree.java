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
            int middle = (right - left)/2 + left;
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

    public Integer query(int left, int right) {
        if (left > right || right >= len || left < 0) {
            new RuntimeException("Invalid indexes.");
        }
        if (left == 0 && right == len - 1) {
            return head.getValue();
        } else {
            return query(head, left, right, 0, len - 1);
        }
    }

    private Integer query(Nodo<Integer> currentNode,int queryLeft, int queryRight, int currentLeft, int currentRight) {
        int middle = (currentRight - currentLeft)/2;
        if (queryLeft == currentLeft) {
            if (currentRight <= queryRight) {
                return currentNode.getValue();
            } else {
                return query(currentNode.getLeft(), queryLeft, queryRight, currentLeft, middle);
            }
        }
        if (queryRight == currentRight) {
            if (currentLeft >= queryLeft) {
                return currentNode.getValue();
            } else {
                return query(currentNode.getRight(), queryLeft, queryRight, middle + 1, currentRight);
            }
        }
        int left = query(currentNode.getLeft(), queryLeft, queryRight, currentLeft, middle);
        int right = query(currentNode.getRight(), queryLeft, queryRight, middle + 1, currentRight);
        return left + right;
    }
}
