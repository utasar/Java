import java.util.Scanner;

public class OtherNestedLoops
{
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        int numOfStudents = 30;
        double totalSpentOnMeals = 0;
        String meal = "";
        String question = "How much did you spend on ";

        for (int i = 0; i < numOfStudents; i++)
        {
            System.out.println("Student #" + i);
            for (int j = 0; j < 3; j++)
            {
                if (j == 0)
                {
                    meal = "breakfast?";
                }
                else if (j == 1)
                {
                    meal = "lunch?";
                }
                else
                {
                    meal = "dinner?";
                }
                System.out.println(question + meal);
                totalSpentOnMeals += scnr.nextDouble();
            }
            System.out.printf("Student #%d spent $%.2f\n", i, totalSpentOnMeals);
            totalSpentOnMeals = 0;
        }
    }
}
