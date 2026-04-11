package P4_Circle2DClass;

public class Circle2D {
    private double x = 0;
    private double y = 0;
    private double radius = 0;

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return (Math.PI * radius * radius);
    }

    public double getPerimeter() {
        return (2 * Math.PI * radius);
    }

    public boolean contains(Circle2D circle) {
        double otherRadius = Math.sqrt(Math.pow(circle.getX() - x, 2) + Math.pow(circle.getY() - y, 2));
        return otherRadius <= Math.abs(radius - circle.getRadius());
    }

    public boolean contains(double x, double y) {
        double otherRadius = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        return otherRadius <= radius;

    }

    public boolean overlaps(Circle2D circle) {
        double otherRadius = Math.sqrt(Math.pow(circle.getX() - x, 2) + Math.pow(circle.getY() - y, 2));
        return otherRadius <= otherRadius + circle.getRadius();
    }
}
