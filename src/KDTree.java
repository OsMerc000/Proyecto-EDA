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
        Nodo aux_ptr = this.root;
        Nodo new_nodo = new Nodo(punto);
        if (aux_ptr == null) {
            root = new_nodo;
        }  else {
            boolean inX = true;
            while (aux_ptr != null) {
                if (inX) {
                    if (new_nodo.getPunto().getX() < aux_ptr.getPunto().getX()) {
                        if (aux_ptr.getLeft() != null) {
                            aux_ptr = aux_ptr.getLeft();
                        } else {
                            aux_ptr.setLeft(new_nodo);
                        }
                    } else {
                        if (aux_ptr.getRight() != null) {
                            aux_ptr = aux_ptr.getRight();
                        } else {
                            aux_ptr.setRight(new_nodo);
                        }
                    }
                } else {
                    if (new_nodo.getPunto().getY() < aux_ptr.getPunto().getY()) {
                        if (aux_ptr.getLeft() != null) {
                            aux_ptr = aux_ptr.getLeft();
                        } else {
                            aux_ptr.setLeft(new_nodo);
                        }
                    } else {
                        if (aux_ptr.getRight() != null) {
                            aux_ptr = aux_ptr.getRight();
                        } else {
                            aux_ptr.setRight(new_nodo);
                        }
                    }
                }
                inX = !inX;
            }
        }
    }

    
}
