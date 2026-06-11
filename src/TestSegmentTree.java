import SegmentTree.SegmentTree;

public class TestSegmentTree {
    public TestSegmentTree() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        SegmentTree tree = new SegmentTree(arr);
        System.out.println("Tree:\n" + tree);
        System.out.println("arr[0] + ... + arr[2] = " + tree.query(0, 2));
        System.out.println("arr[5] + ... + arr[7] = " + tree.query(5, 7));
        System.out.println("arr[2] + ... + arr[6] = " + tree.query(2, 6));
    }
}
