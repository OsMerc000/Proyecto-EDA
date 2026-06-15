package KDTree;

public class Punto {
    private double[] coordenadas;

    public Punto(double[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public double[] getCoordenadas() {
        return coordenadas;
    }
    public int getDimension() {
        return coordenadas.length;
    }

    public void setCoordenadas(double[] coordenadas) {
        this.coordenadas = coordenadas;
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
        if (this.getDimension() != other.getDimension()) {
            new RuntimeException("The points do not have the same dimension.");
        }
        if (k <= 0 || k > this.getDimension()) {
            new RuntimeException("K is not a valid dimension.");
        }
        return Math.abs(this.coordenadas[k - 1] - other.coordenadas[k - 1]);
    }
    
    //Posible overflow; más especificamente, un arithmetic overflow.
    //Buscar otro algoritmo que calcule, con una precisión aceptable, la distancia.
    public double getDistance(Punto other) {
        if (this.getDimension() != other.getDimension()) {
            new RuntimeException("The points do not have the same dimension.");
        }
        double sumOfSquares = 0;
        for (int i = 1; i <= this.getDimension(); i++) {
            sumOfSquares += getDistanceInK(other, i) * getDistanceInK(other, i);
        }
        return Math.sqrt(sumOfSquares);
    }

    @Override
    public String toString() {
        String s = "(";
        for (int i = 1; i < this.getDimension() - 1; i++) {
            s += i + ": " + coordenadas[i - 1] + ", ";
        }
        s += this.getDimension() + ": " + coordenadas[this.getDimension() - 1] + ")";
        return s;
    }

    public double getKValue(int k) {
        if (k <= 0 || k > this.getDimension()) {
            new RuntimeException("K is not a valid dimension.");
        }
        return coordenadas[k - 1];
    }

    // public double getPositionFrom(Punto other, boolean inX) {
    //     if (inX) {
    //         return this.x - other.x; //"other.x - this.x" Te odio, atte. 3h de mi vida;
    //     } else {
    //         return this.y - other.y; //Y tú también;
    //     }
    // }
}
