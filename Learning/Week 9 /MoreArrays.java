import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MoreArrays
{
    public static void main(String[] args)
    {
        boolean[] isPresent = {true, false, true, false};
        System.out.println(Arrays.toString(isPresent));

        boolean[] newIsPresent = generateEmptyAttendance(isPresent);
        System.out.println(Arrays.toString(isPresent));
        System.out.println(Arrays.toString(newIsPresent));

        resetAttendance(isPresent);
        System.out.println(Arrays.toString(isPresent));

        Object[] things = new Object[6];
        things[0] = 4;
        things[1] = 'a';
        things[2] = false;
        things[3] = "abc";
        things[4] = 5.5;
        things[5] = new Scanner(System.in);

        int num = 4;
        double dub = 5.5;
        double number = 0;
        //number = things[0] + things[4];
        number = num + dub;

        //things[3].toUpperCase();

        ArrayList<Boolean> name = new ArrayList<>();
    }

    public static void resetAttendance(boolean[] attendance)
    {
        for (int i = 0; i < attendance.length; i++)
        {
            attendance[i] = false;
        }
    }

    public static boolean[] generateEmptyAttendance(boolean[] attendance)
    {
        boolean[] newAttendance = new boolean[attendance.length];
        newAttendance = attendance.clone();

        for (int i = 0; i < attendance.length; i++)
        {
            newAttendance[i] = false;
        }
        return newAttendance;
    }

}
