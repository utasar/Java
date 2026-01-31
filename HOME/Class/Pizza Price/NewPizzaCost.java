public class NewPizzaCost {
    public static void main(String[] args) {
        
    }
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


