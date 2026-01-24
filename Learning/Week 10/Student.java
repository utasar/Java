public class Student
{

    private String name;
    private int age = 18;

    public Student()
    {

    }

    public Student(String name, int age)
    {
        this.name = name;
        this.setAge(age);
    }


    public void attendClass()
    {
        System.out.println(name + " attends class");
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int newAge)
    {
        if(newAge > 0)
        {
            age = newAge;
        }
    }
}
