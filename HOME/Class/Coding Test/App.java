public class App {
    public class Main {
        public static void main(String[] args) {
            // Create instance of Point named pointA
            Point pointA = new Point(5, 6);  // Example coordinates
            // Create instance of Point named pointB
            Point pointB = new Point(4, 4);  // Example coordinates
            // Create instance of Point named pointC
            Point pointC = new Point(6, 6);  // Example coordinates 
            Point[] pointsArray = {
                pointA,
                pointB,
                pointC
            }; // Assigning them in array of point

            double distance = Math.sqrt(Math.pow((pointA.getX()-pointB.getX()),2)+Math.pow((pointA.getY()-pointB.getY()),2));
            System.out.println("Distance between points:"+pointA +" And "+pointB+" is "+distance);
        }
    }
}
