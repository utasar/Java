public class Car {
    //state
    private static int numberOfWheels =4;
    private int numberOfDoors;
    private String color;
    private boolean isNew;
    private String make;
    private String model;

    public void setNumberOfDoors(int numberOfDoors){
        if((numberOfDoors==2)||(numberOfDoors==4))
        {
            this.numberOfDoors = numberOfDoors;
        }else
        {
            System.out.println("Car class only accept 2 or 4 doors");
        }
    }
    public int getNumberOfDoors()
    {
        return this.numberOfDoors;
    }
    public void setModel(String model)
    {
        this.model = model;
    }
    public String getModel()
    {
        return this.model;
    }
    public void setMake(String make)
    {
        this.make = make;
    }
    public String getMake()
    {
        return this.make;
    }
    @Override
    public String toString(){
        return this.getMake()+" "+this.getModel();
    }
}
