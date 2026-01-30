public class Driver {
    public static int main(String[] args) {
        // Car car1 = new Car();
        // car1.setNumberOfDoors((4));
        // System.out.println(car1.getNumberOfDoors());
        Car car2 = new Car();
        car2.setNumberOfDoors(2);
        System.out.println("Paint needed "+car2.getNumberOfDoors()*.2);
        car2.setMake("Honda");
        car2.setModel("Accord");
        System.out.println(car2);//overriden tostring automatically called while doing so.
        return 0;
    }

}
