import SegmentTree.SegmentTree;
import SegmentTree.SegmentTree.Associative;

public class TestSegmentTree {
    public TestSegmentTree() {
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        Associative<Integer> method = new Associative<Integer>() {
            @Override
            public Integer method(Integer u, Integer v) {
                return u + v;
            }
        };
        SegmentTree<Integer> tree = new SegmentTree<Integer>(arr, method);
        System.out.println("Tree:\n" + tree);
        System.out.println("arr[0] + ... + arr[2] = " + tree.query(0, 2));
        System.out.println("arr[5] + ... + arr[7] = " + tree.query(5, 7));
        System.out.println("arr[2] + ... + arr[6] = " + tree.query(2, 6));
        tree.update(2, 20);
        tree.update(5, 100);
        System.out.println(tree);
    }
}
