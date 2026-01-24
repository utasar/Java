import java.util.Scanner;

public class ObjectPractice
{
    public static void main(String[] args)
    {

        // Scanner scnr = new Scanner(System.in);

        // scnr.nextLine();

        Student bob = new Student("Bob", 32);
        System.out.println(bob.getName());
        System.out.println(bob.getAge());

        Student alice = new Student("Alice", 24);
        System.out.println(alice.getAge());


        // bob.setAge(-10);
        // bob.setAge(56);


        // bob.attendClass();

        // System.out.println(bob.name);

        // bob.name = "Alice";

        // System.out.println(bob.name);
    }

    public static int add(int a, int b)
    {
        int temp = a + b;
        return temp;
    }
}
