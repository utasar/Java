import java.util.Scanner;
public class TempConv {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is the temperature in Fahrenheit? ");// Question says to enter the value inline
        double tempFaren = scan.nextDouble();
        double tempCelsius = (tempFaren - 32.0) * 5.0/9.0;
        System.out.printf("The celsius temperature is: %.2f",tempCelsius);// output to format into 2 decimal place
    }
}
