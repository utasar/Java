public class RectangleNestedLoops
{
    public static void main(String[] args)
    {
        int maxWidth = 3;
        int maxHeight = 10;

        for (int i = 0; i < maxHeight; i++)
        {
            for (int j = 1; j <= maxWidth; j++)
            {
                if (i == 0 || i == (maxHeight - 1) || j == 1 || j == maxWidth)
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
