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

    public double getDistanciaX(Punto other) {
        return Math.abs(this.x - other.x);
    }
    public double getDistanciaY(Punto other) {
        return Math.abs(this.y - other.y);
    }
    public double getDistancia(Punto other) {
        return Math.sqrt(Math.pow(this.getDistanciaX(other), 2) + Math.pow(this.getDistanciaY(other), 2));
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
