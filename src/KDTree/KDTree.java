package KDTree;

public class KDTree {
    private Nodo root;
    private int dimension;

    public KDTree() {
        this.root = null;
        this.dimension = 0;
    }
    public KDTree(Punto punto) {
        this.root = new Nodo(punto);
        this.dimension = punto.getDimension();
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

    private Nodo pushNode(Nodo currentNode, int kDim, Nodo newNode) {
        if (currentNode == null) {
            return newNode;
        }

        if (kDim > dimension) {
            kDim = kDim - dimension;
        }

        if (newNode.getPunto().getKValue(kDim) < currentNode.getPunto().getKValue(kDim)) {
            currentNode.setLeft(pushNode(currentNode.getLeft(), kDim + 1, newNode));
        } else {
            currentNode.setRight(pushNode(currentNode.getRight(), kDim + 1, newNode));
        }

        return currentNode;
    }

    public Punto getNearestPoint(Punto point) {
        if (point == null || this.isEmpty()) {
            return null;
        } else {
            return getNearest(this.root, this.root.getPunto(), point, 1);
        }
    }

    private Punto getNearest(Nodo currentNode, Punto closestSoFar, Punto point, int kDim) {
        if (currentNode == null) {
            return closestSoFar;
        }

        if (currentNode.getPunto().equals(point)) {
            return currentNode.getPunto();
        }

        if (currentNode.getPunto().getDistance(point) < closestSoFar.getDistance(point)) {
            closestSoFar = currentNode.getPunto();
        }

        if (kDim > dimension) {
            kDim = kDim - dimension;
        }

        if (point.getRelativePositionInKDim(currentNode.getPunto(), kDim) < 0) {
            closestSoFar = getNearest(currentNode.getLeft(), closestSoFar, point, kDim + 1);
            if (Math.abs(point.getRelativePositionInKDim(currentNode.getPunto(), kDim)) < closestSoFar.getDistance(point)) {
                closestSoFar = getNearest(currentNode.getRight(), closestSoFar, point, kDim + 1);
            }
        } else {
            closestSoFar = getNearest(currentNode.getRight(), closestSoFar, point, kDim + 1);
            if (Math.abs(point.getRelativePositionInKDim(currentNode.getPunto(), kDim)) < closestSoFar.getDistance(point)) {
                closestSoFar = getNearest(currentNode.getLeft(), closestSoFar, point, kDim + 1);
            }
        }

        return closestSoFar;
    }

    // private Punto getNearest(Nodo currentNode, Punto closestSoFar, Punto point, boolean inX) {
    //     
    //     double positionRespectoAlCurrentNode = point.getPositionFrom(currentNode.getPunto(), inX);
    //     if (positionRespectoAlCurrentNode < 0) {
    //         //System.out.println("LEFT");
    //         closestSoFar = getNearest(currentNode.getLeft(), closestSoFar, point, !inX);
    //         if (Math.abs(positionRespectoAlCurrentNode) < closestSoFar.getDistance(point)) {
    //             //System.out.println("SWITCH/RIGHT");
    //             closestSoFar = getNearest(currentNode.getRight(), closestSoFar, point, !inX);
    //         }
    //     } else {
    //         //System.out.println("RIGHT");
    //         closestSoFar = getNearest(currentNode.getRight(), closestSoFar, point, !inX);
    //         //System.out.println("PSL " + positionRespectoAlCurrentNode);
    //         //System.out.println("CSFD: " + closestSoFar.getDistance(point));
    //         if (Math.abs(positionRespectoAlCurrentNode) < closestSoFar.getDistance(point)) {
    //             //System.out.println("SWITCH/LEFT");
    //             closestSoFar = getNearest(currentNode.getLeft(), closestSoFar, point, !inX);
    //         }
    //     }
    //     //System.out.println("UP");
    //     return closestSoFar;
    // }

    @Override
    public String toString() {
        if (this.root == null) {
            return "None";
        } else {
            return this.root.toString();
        }
    }
}
