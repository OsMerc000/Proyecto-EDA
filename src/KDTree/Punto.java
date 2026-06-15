package KDTree;

public class Punto {
    private double[] coordenadas;
    private int dimension;

    public Punto(double[] coordenadas) {
        this.coordenadas = coordenadas;
        this.dimension = coordenadas.length;
    }

    public double[] getCoordenadas() {
        return coordenadas;
    }
    public int getDimension() {
        return dimension;
    }

    public void setCoordenadas(double[] coordenadas) {
        this.coordenadas = coordenadas;
        this.dimension = coordenadas.length;
    }
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public static Punto punto2D(double x, double y) {
        double[] coordenadas = {x, y};
        return new Punto(coordenadas);
    }
    public static Punto punto3D(double x, double y, double z) {
        double[] coordenadas = {x, y, z};
        return new Punto(coordenadas);
    }

    public double getDistanceInK(Punto other, int k) {
        if (this.dimension != other.dimension) {
            new RuntimeException("The points do not have the same dimension.");
        }
        if (k < 0 || k >= dimension) {
            new RuntimeException("K is not a valid dimension.");
        }
        return Math.abs(this.coordenadas[k] - other.coordenadas[k]);
    }
    
    public double getDistance(Punto other) {
        if (this.dimension != other.dimension) {
            new RuntimeException("The points do not have the same dimension.");
        }
        for (int i = 0; i < dimension; i++) {
            
        }
    }

    @Override
    public String toString() {
        String s = "(";
        for (int i = 0; i < dimension - 1; i++) {
            s += i + ": " + coordenadas[i] + ", ";
        }
        s += dimension - 1 + ": " + coordenadas[dimension - 1] + ")";
        return s;
    }

    // public double getPositionFrom(Punto other, boolean inX) {
    //     if (inX) {
    //         return this.x - other.x; //"other.x - this.x" Te odio, atte. 3h de mi vida;
    //     } else {
    //         return this.y - other.y; //Y tú también;
    //     }
    // }
}
