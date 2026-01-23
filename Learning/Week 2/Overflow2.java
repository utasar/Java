public class Overflow2
{
    public static void main(String[] args)
    {
        int bigNumber = 2147483647;
        System.out.println(bigNumber);

        bigNumber = bigNumber + 1;
        System.out.println(bigNumber);

        bigNumber -= 1;
        bigNumber = bigNumber * 546;
        System.out.println(bigNumber);
    }
}
