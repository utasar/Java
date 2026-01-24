public class Employee
{
    private int numCurrentProjects = 0;
    private String name = "";

    public Employee()
    {
        System.out.println("Employee no-arg constructor called!");
    }

    public Employee(String name, int numProjects)
    {
        this.name = name;
        numCurrentProjects = numProjects;
    }

    // this method will get called if the object is type Employee
    // or if it is a subclass of Employee that DOES NOT override
    // this method
    public boolean canTakeLeave()
    {
        if (numCurrentProjects < 3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getNumCurrentProjects()
    {
        return numCurrentProjects;
    }

    public void setNumCurrentProjects(int numCurrentProjects)
    {
        if (numCurrentProjects >= 0)
        {
            this.numCurrentProjects = numCurrentProjects;
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    // this method will get called if the object is type Employee
    // or if it is a subclass of Employee that DOES NOT override
    // this method
    @Override
    public String toString()
    {
        String result = "Employee " + name + " is currently working on " + numCurrentProjects + " projects.";
        return result;
    }
}
