public class KDTree {
    private Nodo root;

    public KDTree() {
        this.root = null;
    }

    public Nodo getRoot() {
        return root;
    }
    public void setRoot(Nodo root) {
        this.root = root;
    }

    public void push(Punto punto) {
        Nodo new_nodo = new Nodo(punto);
        if (root == null) {
            root = new_nodo;
        }  else {
            node_push(root, true, new_nodo);
        }
    }

    private Nodo node_push(Nodo current_node, boolean inX, Nodo new_node) {
        if (current_node == null) {
            return new_node;
        }

        if (inX) {
            if (new_node.getPunto().getX() < current_node.getPunto().getX()) {
                current_node.setLeft(node_push(current_node.getLeft(), !inX, new_node));
            } else {
                current_node.setRight(node_push(current_node.getRight(), !inX, new_node));
            }
        } else {
            if (new_node.getPunto().getY() < current_node.getPunto().getY()) {
                current_node.setLeft(node_push(current_node.getLeft(), !inX, new_node));
            } else {
                current_node.setRight(node_push(current_node.getRight(), !inX, new_node));
            }
        }

        return current_node;
    }

    @Override
    public String toString() {
        if (this.root == null) {
            return "None";
        } else {
            return this.root.toString();
        }
    }
}
