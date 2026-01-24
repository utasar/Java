public class BasicNestedLoops
{
    public static void main(String[] args)
    {
        int count = 0;
        for (int i = 0; i < 11; i++)
        {
            System.out.println("outside loop start: i = " + i);
            for (int j = 0; j < 3; j++)
            {
                System.out.println("inside loop: j = " + j);
                System.out.println("inside loop: i = " + i);
                count++;
            }
            System.out.println("outside loop end: i = " + i);
        }
        System.out.println(count);
    }
}
