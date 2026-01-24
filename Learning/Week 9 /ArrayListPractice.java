import java.util.ArrayList;

public class ArrayListPractice
{
    public static void main(String[] args)
    {
        ArrayList<String> studentNames = new ArrayList<>();

        studentNames.add("Connor");
        studentNames.add("JoeStar");
        studentNames.add("Peter");

        System.out.println(studentNames);

        studentNames.set(1, "John");
        System.out.println(studentNames);

        studentNames.add(1, "Aiden");
        System.out.println(studentNames);

        System.out.println(studentNames.remove(0));
        System.out.println(studentNames);

        System.out.println(studentNames.get(0));
        System.out.println(studentNames);

        System.out.println(studentNames.size());

        for (String name : studentNames)
        {
            System.out.println(name);
        }

        studentNames.clear();
        System.out.println(studentNames);

        System.out.println(studentNames.isEmpty());

        ArrayList<Double> decimals = new ArrayList<>();
        decimals.add(3.4);
        String myGrade = Double.toString(decimals.get(0));
        System.out.println(myGrade);
    }
}
