import java.util.Scanner;
public class VolumeOfSphere {
    public static void main(String[] args) 
    {
        Scanner In =new Scanner(System.in);
        System.out.println("Enter the raius with precision");
        double radius = In.nextDouble();
        // math formula for double
        double area = (4.3/3.0)* Math.PI * Math.pow(radius, 3.0);
        System.out.println(area);
        System.out.printf("%.2f",area);
    }
}
