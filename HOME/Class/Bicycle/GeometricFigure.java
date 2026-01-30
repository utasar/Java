import java.util.Scanner;
public class GeometricFigure {
    Scanner scnr =new Scanner(System.in);
    private String name;
    private int numberOfSides;
    private int peremeter;
    public GeometricFigure(String FigureName, int numberOfSides)
        {
            setName(name);
            setNumberOfSize(numberOfSides);
        }
    public GeometricFigure()
        {
            
        }    
    public String getName() 
        {
        return name;
        }
    public int getNumberOfSize() 
        {
        return numberOfSides;
        }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumberOfSize(int numberOfSides) 
    {
        if ((numberOfSides==3)||(numberOfSides==4))
            this.numberOfSides = numberOfSides;
        else
            System.out.println("Can accept either 3 or 4 sides");
    }
    public double calcPrintPeremeter()
    {
       System.out.println("Enter length of size");
       for(int i=0; i<this.numberOfSides;i++)
            {
                peremeter+=scnr.nextDouble();
            }
       // System.out.println("Peremeter is: "+peremeter);
        return this.peremeter;
    }
    @Override
    public String toString()
    {
        return (this.name+ " "+ this.peremeter);
    }
 
}
