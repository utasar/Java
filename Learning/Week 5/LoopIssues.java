public class LoopIssues
{
    public static void main(String[] args)
    {
        // scope
        int x = 0;

        while (x < 5)
        {
            int num = 3;
            x++;
        }
        // num is out of scope here.
        // x = num;

//        for (double value = 0.0; value != 1.0; value = value + 0.1)
//        {
//            System.out.println(value);
//        }

        for (double value = 0.0; value <= 1.0; value = value + 0.1)
        {
            System.out.printf("%.1f\n", value);
        }

        for (int value = 0; value != 10; value = value + 1)
        {
            System.out.println(value);
        }

    }
}
