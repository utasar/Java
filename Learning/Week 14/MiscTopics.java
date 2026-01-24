public class MiscTopics
{
    public static void main(String[] args)
    {
        // enum examples
        enum Month {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
        Month currMonth = Month.APR;

        if (currMonth == Month.MAR)
        {
            System.out.println("Hi!");
        }
        else if (currMonth.ordinal() == 3)
        {
            System.out.println("Yay!");
        }

        // demonstrates that null types will still get
        // concatenated in Strings
        String name = null;
        System.out.println(sayHi(name));
        // demonstrates that we cannot call methods
        // on null types
        //System.out.println(makeLowercase(name));


        Person p1 = new Person("Bob", 30);
        Person p2 = new Person("Nancy", 31);
        Person p3 = new Person("Jimmy", 6);

        Family myFamily = new Family(p1, p2, p3);

        Person parent = myFamily.getParent1();
        // if we are performing a shallow copy,
        // this will modify parent1 of myFamily
        // if we are performing a deep copy,
        // this will not modify parent1 of myFamily
        parent.setName("Fred");
        System.out.println(myFamily.getParent1());
    }

    public static String sayHi(String name)
    {
        return "Hi " + name + "!";
    }

    public static String makeLowercase(String name)
    {
        return name.toLowerCase();
    }
}
