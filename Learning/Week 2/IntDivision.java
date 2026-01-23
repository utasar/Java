public class IntDivision
{
    public static void main(String[] args)
    {
        double answer = 9 / 3;
        System.out.println(answer);

        // by default, the compiler reads any number without a decimal place as an integer
        // this means that if we divide one integer by another integer,
        // our answer will also be an integer even if it's supposed to be a decimal
        answer = 9 / 2;
        System.out.println(answer);

        // adding .0 tells the compiler to read the number as a decimal
        answer = 9.0 / 2;
        System.out.println(answer);

        answer = 9 / 2.0;
        System.out.println(answer);

        // we can also use type-casting to force the compiler to read a number as a decimal
        answer = (double) 9 / 2;
        System.out.println(answer);

        // java automatically appends a .0 to any variable it recognizes as a decimal type
        double decimal = 9;
        System.out.println(decimal);

        // java automatically allows casting when no information will be lost
        // i.e. int to double
        int integer = -3;
        decimal = integer;
        System.out.println(decimal);

        // if information will be lost in the casting process,
        // then we must type-cast explicitly
        // i.e. double to int
        decimal = 54.248923;
        integer = (int) decimal;
        System.out.println(integer);

    }
}
