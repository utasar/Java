public class Methods
{
    public static void main(String[] args)
    {
        double sumOfValues = sum(5.5, 64);
        String concat = sum("hi ", "how are you");
        System.out.println(sumOfValues);
        System.out.println(concat);

        System.out.println(concat("My favorite number", 3));
    }

    public static double sum(double num1, double num2)
    {
        double result = num1 + num2;
        return result;
    }

    public static String sum(String string1, String string2)
    {
        return string1 + string2;
    }

    public static String concat(String string1, int num1)
    {
        return string1 + ": " + num1;
    }

}
