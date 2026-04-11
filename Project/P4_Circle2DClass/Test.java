package P4_Circle2DClass;
import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {
        Circle2D circle1 = new Circle2D(2, 2, 5.5);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Circle 1 area: " + df.format(circle1.getArea()));
        System.out.println("Circle 1 perimeter: " + df.format(circle1.getPerimeter()));
        System.out.println("Point (3, 3) within circle 1: " + circle1.contains(3, 3));
        System.out.println("Circle 2 within circle 1: " + circle1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println("Circle 3 overlaps circle 1: " + circle1.overlaps(new Circle2D(3, 5, 2.3)));
    }
}

/*
Define the Circle2D class that contains:

• Two double data fields named x and y that specify the
center of the circle with get methods.
• A data field radius with a get method.
• A no-arg constructor that creates a default circle
with (0, 0) for (x, y) and 1 for radius.
• A constructor that creates a circle with the specified
x, y, and radius.
• A method getArea() that returns the area of the
circle.
• A method getPerimeter() that returns the perimeter of
the circle.
• A method contains(double x, double y) that returns
true if the specified point (x, y) is inside this
circle. See Figure 10.14(a).
• A method contains(Circle2D circle) that returns true
if the specified circle is inside this circle. See
Figure 10.14(b).
• A method overlaps(Circle2D circle) that returns true
if the specified circle overlaps with this circle. See
the figure below.


Figure

(a) A point is inside the circle. (b) A circle is
inside another circle. (c) A circle overlaps another
circle.

Draw the UML diagram for the class. Implement the
class. Write a test program that creates a Circle2D
object c1 (new Circle2D(2, 2, 5.5)), displays its area
and perimeter, and displays the result of
c1.contains(3, 3), c1.contains(new Circle2D(4, 5,
10.5)), and c1.overlaps(new Circle2D(3, 5, 2.3)). 
*/
