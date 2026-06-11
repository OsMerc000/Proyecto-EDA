import SegmentTree.SegmentTree;

public class TestSegmentTree {
    public TestSegmentTree() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        SegmentTree tree = new SegmentTree(arr);
        System.out.println(tree.query(5, 7));
    }
}
