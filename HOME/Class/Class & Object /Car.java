public class Car 
    {
       public int noOfWheels = 4;
       public int numberOfDoors =2;
       public String color = "red";
       public boolean isNew = true; // true: new, false used
       public String make = "Toyota";
       public String model = "Corolla";

       //behaviour
       public void startTheCar(boolean startStopsCar)
       {
        if (startStopsCar)
            System.out.println("broommmmm");
        else
            System.out.println("Turn on the car!!");            
       }

    }

