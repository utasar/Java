import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
       GeometricFigure geo1 = new GeometricFigure("Triangle",3);
       geo1.setName("pentagon");
       geo1.setNumberOfSize(5);
       geo1.calcPrintPeremeter();
       System.out.println(geo1);

       GeometricFigure geo2 = new GeometricFigure("Square",4);
       geo2.setName("triangle");
       geo2.setNumberOfSize(3);
       geo2.calcPrintPeremeter();
        System.out.println(geo2);

//creating an arraylist of 3-4 sided figures
    ArrayList <GeometricFigure> figurList = new ArrayList<>();
    figurList.add(geo1);
    figurList.add(geo2);
// creating an array of 3-4 sided figurs
    GeometricFigure [] figurArray = new GeometricFigure[3];
    figurArray[0]=new GeometricFigure("Triangle",3);
    figurArray[1]= new GeometricFigure("Rectangle",4);
    figurArray[2]= new GeometricFigure("rhombus", 4);
    

    }
}
