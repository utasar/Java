public class NestedShapes
{
    public static void main(String[] args)
    {
        int maxWidth = 10;
        int maxHeight = 10;

        for (int i = 1; i <= maxHeight; i++)
        {
            for (int j = 1; j <= maxWidth; j++)
            {
                if (i == j || i == 1 || j == maxWidth || (j + i - 1 == maxWidth ))
                {
                    System.out.print("# ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
