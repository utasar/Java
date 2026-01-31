import java.util.Random;
public class SwitchExample {
    public static void main(String[] args) throws Exception {
        Random randGen=new Random(5);// psudo random seed 5
        int myInt=508;
        float myFloat=45.1342f;
        System.out.printf("%2d\n", myInt);
        System.out.printf("%4d\n", myInt); 
        System.out.printf("%.3e\n", myFloat);
        System.out.printf("%09.2f\n", myFloat);
        System.out.println(randGen.nextInt(5));
        System.out.print("say\"hello\"");
    }
}
