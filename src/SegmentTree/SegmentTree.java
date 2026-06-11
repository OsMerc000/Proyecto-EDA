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
            int middle = (left + right)/2;
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
        return query(head, left, right, 0, len - 1);
    }

    private Integer query(Nodo<Integer> currentNode,int queryLeft, int queryRight, int currentLeft, int currentRight) {
        if (queryLeft == currentLeft && queryRight == currentRight) {
            return currentNode.getValue();
        } else {
            int middle = (currentLeft + currentRight)/2;
            if (queryLeft > middle) {
                return query(currentNode.getLeft(), queryLeft, queryRight, currentLeft, middle);
            } else if (queryRight <= middle) {
                return query(currentNode.getRight(), queryLeft, queryRight, middle + 1, currentRight);
            } else {
                int left = query(currentNode.getLeft(), queryLeft, queryRight, currentLeft, middle);
                int right = query(currentNode.getRight(), queryLeft, queryRight, middle + 1, currentRight);
                return left + right;
            }
        }
    }
}
