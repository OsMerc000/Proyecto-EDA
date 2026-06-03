public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double distanciaX(Punto other) {
        return Math.abs(this.x - other.x);
    }
    public double distanciaY(Punto other) {
        return Math.abs(this.y - other.y);
    }
    public double distancia(Punto other) {
        return Math.sqrt(Math.pow(this.distanciaX(other), 2) + Math.pow(this.distanciaY(other), 2));
    }
}
