package KDTree;

public class KDTree {
    private Nodo root;
    private int dimension;

    public KDTree() {
        this.root = null;
        this.dimension = 0;
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }

    public void push(Punto punto) {
        Nodo newNode = new Nodo(punto);
        if (root == null) {
            root = newNode;
            dimension = punto.getDimension();
        }  else {
            if (punto.getDimension() != dimension) {
                new RuntimeException("Invalid point: Different dimension.");
            }
            pushNode(root, 1, newNode);
        }
    }

    private Nodo pushNode(Nodo currentNode, int KDim, Nodo newNode) {
        if (currentNode == null) {
            return newNode;
        }

        if (KDim > dimension) {
            KDim = KDim - dimension;
        }

        if (newNode.getPunto().getKValue(KDim) < currentNode.getPunto().getKValue(KDim)) {
            currentNode.setLeft(pushNode(currentNode.getLeft(), KDim + 1, newNode));
        } else {
            currentNode.setRight(pushNode(currentNode.getRight(), KDim + 1, newNode));
        }

        return currentNode;
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
