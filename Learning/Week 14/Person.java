public class Person
{
    private String name = "";
    private int age = 0;

    // copy constructor that takes in a person object
    // and copies all of its attributes
    public Person(Person p)
    {
        this.setName(p.getName());
        this.setAge(p.getAge());
    }

    public Person(String name, int age)
    {
        setName(name);
        setAge(age);
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        String personInfo = "name: " + name + " (age " + age + ")";
        return personInfo;
    }
}
