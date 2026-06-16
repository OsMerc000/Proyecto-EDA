package KDTree;

public class KDTree {
    private Nodo root;

    public KDTree() {
        this.root = null;
    }

    public KDTree(Punto[] puntos) {
        this.root = null;
        for (int i = 0; i < puntos.length; i++) {
            this.push(puntos[i]);
        }
    }

    public boolean isEmpty() {
        return this.root == null;
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

    public Punto getNearestPoint(Punto point) {
        if (point == null || this.isEmpty()) {
            return null;
        } else {
            return getNearest(this.root, this.root.getPunto(), point, true);
        }
    }

    private Punto getNearest(Nodo currentNode, Punto closestSoFar, Punto point, boolean inX) {
        if (currentNode == null) {
            //System.out.println("NULL/UP");
            return closestSoFar;
        }
        if (currentNode.getPunto().equals(point)) {
            return currentNode.getPunto();
        }
        if (currentNode.getPunto().getDistance(point) < closestSoFar.getDistance(point)) {
            closestSoFar = currentNode.getPunto();
            //System.out.println("CHANGE");
        }
        double positionRespectoAlCurrentNode = point.getPositionFrom(currentNode.getPunto(), inX);
        if (positionRespectoAlCurrentNode < 0) {
            //System.out.println("LEFT");
            closestSoFar = getNearest(currentNode.getLeft(), closestSoFar, point, !inX);
            if (Math.abs(positionRespectoAlCurrentNode) < closestSoFar.getDistance(point)) {
                //System.out.println("SWITCH/RIGHT");
                closestSoFar = getNearest(currentNode.getRight(), closestSoFar, point, !inX);
            }
        } else {
            //System.out.println("RIGHT");
            closestSoFar = getNearest(currentNode.getRight(), closestSoFar, point, !inX);
            //System.out.println("PSL " + positionRespectoAlCurrentNode);
            //System.out.println("CSFD: " + closestSoFar.getDistance(point));
            if (Math.abs(positionRespectoAlCurrentNode) < closestSoFar.getDistance(point)) {
                //System.out.println("SWITCH/LEFT");
                closestSoFar = getNearest(currentNode.getLeft(), closestSoFar, point, !inX);
            }
        }
        //System.out.println("UP");
        return closestSoFar;
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
