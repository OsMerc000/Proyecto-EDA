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

    public double getDistanceX(Punto other) {
        return Math.abs(this.x - other.x);
    }
    public double getDistanceY(Punto other) {
        return Math.abs(this.y - other.y);
    }
    public double getDistance(Punto other) {
        return Math.sqrt (
            this.getDistanceX(other) * this.getDistanceX(other) + 
            this.getDistanceY(other) * this.getDistanceY(other)
        );
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public double getPositionFrom(Punto other, boolean inX) {
        if (inX) {
            return this.x - other.x;
        } else {
            return this.y - other.y;
        }
    }
}
