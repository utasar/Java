import java.util.Arrays;

public class ArrayPractice
{
    public static void main(String[] args)
    {
//        boolean[] attendance = new boolean[5];
//
//        attendance[0] = true;
//        attendance[1] = false;
//        attendance[2] = false;
//        attendance[3] = true;
//        attendance[4] = true;

        boolean[] attendance = {true, false, false, true, true, false, true};
        System.out.println(attendance);
        System.out.println(Arrays.toString(attendance));

        int numberAttended = 0;

        //for (int i = 0; i < 5; i++)
//        for (int i = 0; i < attendance.length; i++)
//        {
//            if (attendance[i])
//            {
//                numberAttended++;
//            }
//        }
        for (boolean attended : attendance)
        {
            if (attended)
            {
                numberAttended++;
            }
        }
        System.out.println(numberAttended + " people attended class");


        double[] account = {543.53, -43.00, 1248.37, -329.43};
        double total = 0.0;

        for (double transaction : account)
        {
            total += transaction;
        }
        System.out.printf("Total after all transactions is: $%.2f", total);
    }
}
