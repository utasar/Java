import java.util.*;

public class MultiDimensionalArrays
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("How many students are we going to enter grades for?");
        int numStudents = input.nextInt();

        System.out.println("How many grades are we going to enter per student?");
        int numGrades = input.nextInt();

        int[][] studentGrades = new int[numStudents][numGrades];

        // for (int i = 0; i < studentGrades.length; i++)
        for (int i = 0; i < numStudents; i++)
        {
            // for (int j = 0; j < studentGrades[0].length; j++)
            for (int j = 0; j < numGrades; j++)
            {
                System.out.println("What is student #" + (i + 1) + "'s grade for assignment #" + (j + 1) + "?");
                int grade = input.nextInt();
                studentGrades[i][j] = grade;
            }
        }

        System.out.println(Arrays.toString(studentGrades));

        double sum = 0.0;
        int numAssignments = 0;
        int studentNumber = 1;

        for (int[] grades : studentGrades)
        {
            System.out.println(Arrays.toString(grades));
            for (int grade : grades)
            {
                System.out.println(grade);
                sum += grade;
                numAssignments++;
            }
            //System.out.println("Avg grade for student #" + studentNumber + " was " + sum/numAssignments);
            System.out.printf("Avg grade for student #%d was %.3f", studentNumber, (sum/numAssignments));
            sum = 0.0;
            numAssignments = 0;
            studentNumber++;
        }
    }
}
