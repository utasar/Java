import java.util.Scanner;
/*
 * @author Utsav
 */
public class PizzaCost {
    public static void main(String[] args) throws Exception {
        Scanner scnr =new Scanner(System.in);
        double pizzaCost = 0;
        System.out.print("Enter pizza size (8, 11, 16, 22):");
        int pizzadiameter = scnr.nextInt();
        switch (pizzadiameter) {
            case 8:
                pizzaCost = 0.05 * Math.PI * Math.pow(pizzadiameter, 2) / 4.0; // suppose the formula is pi* sq(r)
                System.out.printf("Your bill: $ %.2f \n",pizzaCost);
                System.out.printf("Your bill including 2%% tax $ %.2f",pizzaCost*1.02);
                break;
            case 11:
                pizzaCost = 0.05 * Math.PI * computeSquare(pizzadiameter) / 4.0;
                System.out.printf("Your bill: $ %.2f \n",pizzaCost);
                System.out.printf("Your bill including 2%% tax  $ %.2f",pizzaCost*1.02);
                break;
            case 16:
            pizzaCost = 0.1 * Math.PI * computeSquare(pizzadiameter) / 4.0;
            System.out.printf("Your bill: $ %.2f \n",pizzaCost);
            System.out.printf("Your bill including 2%% tax $ %.2f",pizzaCost*1.02);
                break;

            case 22:
            pizzaCost = 0.1 * Math.PI * computeSquare(pizzadiameter) / 4.0;
            System.out.printf("Your bill: $ %.2f \n",pizzaCost);
            System.out.printf("Your bill including 2%% tax $ %.2f",pizzaCost*1.02);
                break;
        
            default:

                break;

        }
        double pizzaArea = computeArea(pizzadiameter/2.0);
        scnr.close();
    }
    // end of Main method

/*
 * @param diameter input parameter of type double to ComputeSquare Method
 * return SquareofRadiusPizza output parameter
 */
public static double computeSquare(double diameter)
{
    return (diameter*diameter);
}
public static double pctCalculator(double baseVal, double pctVal)
{
    return (baseVal+baseVal*pctVal/100);
}

/*
* @param radius input parameter type double
* @return area output parameter of the type double to return area value after 
*/
public static double computeArea(double radius)
{
return(Math.PI*computeSquare(radius));
}

}
